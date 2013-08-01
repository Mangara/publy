/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import publy.data.bibitem.BibItem;
import publy.data.settings.Settings;
import publy.gui.MainFrame;
import publy.io.BibTeXParser;
import publy.io.PublicationListWriter;
import publy.io.bibtex.BibtexPublicationListWriter;
import publy.io.html.HTMLPublicationListWriter;
import publy.io.plain.PlainPublicationListWriter;
import publy.io.settings.SettingsReader;

/**
 *
 * @author Sander
 */
public class Publy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read settings
        Settings settings = null;
        Throwable exception = null;

        try {
            settings = SettingsReader.parseSettings();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            exception = ex;
        }

        try {
            if (UIManager.getSystemLookAndFeelClassName().contains("GTK") || UIManager.getSystemLookAndFeelClassName().contains("Motif")) {
                // Running on Linux. The system L&F has issues with font rendering, so reverting to the (nice) cross-platform "Metal" L&F
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // Unavailable: use default L&F
        }

        boolean showSettings = false;

        if (settings == null) {
            showSettings = true;

            // Notify the user
            if (exception == null) {
                JOptionPane.showMessageDialog(null, "No configuration information was found. Please set up your preferences.", "Publy - Launching Settings Window", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "An exception occurred while parsing the configuration. Loading the default configuration.", "Publy - Launching Settings Window", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Path pubList = settings.getPublications();
            Path target = settings.getGeneralSettings().getTarget();
            
            if (pubList == null || target == null) {
                showSettings = true;
                JOptionPane.showMessageDialog(null, "Some critical settings have not been specified yet. Please complete your configuration.", "Publy - Launching Settings Window", JOptionPane.INFORMATION_MESSAGE);
            } else if (Files.notExists(pubList)) {
                showSettings = true;
                JOptionPane.showMessageDialog(null, "The publication list \"" + pubList.getFileName().toString() + "\" could not be found at the indicated location.", "Publy - Launching Settings Window", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (showSettings) {
            // Launch the GUI
            // Variables need to be final in order to be shared
            final Settings guiSettings = (settings == null ? Settings.defaultSettings() : settings);
            final Throwable guiException = exception;

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainFrame mf = new MainFrame(guiSettings);

                    // Report an Exception, if one occurred
                    if (guiException != null) {
                        Console.except(guiException, "Exception occurred while parsing the configuration:");
                    }

                    mf.setVisible(true);
                }
            });
        } else {
            generatePublicationList(settings);
        }
    }

    public static void generatePublicationList(Settings settings) {
        // Check if the publication list is set and exists
        Path pubList = settings.getPublications();

        if (pubList == null) {
            Console.error("No publication list was set.");
        } else if (Files.notExists(pubList)) {
            Console.error("No publication list was found at: %s", pubList);
        } else {
            // Parse all publications
            List<BibItem> items = null;

            try {
                items = BibTeXParser.parseFile(settings.getPublications());
                Console.log("Publications list \"%s\" parsed successfully.", settings.getPublications().getFileName());
            } catch (Exception | AssertionError ex) {
                Console.except(ex, "Exception while parsing publications list:");
            }

            if (items != null && settings.getHtmlSettings().generateTextVersion()) {
                try {
                    PublicationListWriter writer = new PlainPublicationListWriter(settings.getGeneralSettings());
                    writer.writePublicationList(items, settings.getGeneralSettings().getPlainTextTarget());
                    Console.log("Plain text publication list written successfully.");
                } catch (Exception | AssertionError ex) {
                    Console.except(ex, "Exception while writing plain text publication list:");
                }
            }

            if (items != null && settings.getHtmlSettings().generateBibtexVersion()) {
                try {
                    PublicationListWriter writer = new BibtexPublicationListWriter(settings.getGeneralSettings());
                    writer.writePublicationList(items, settings.getGeneralSettings().getBibtexTarget());
                    Console.log("BibTeX publication list written successfully.");
                } catch (Exception | AssertionError ex) {
                    Console.except(ex, "Exception while writing BibTeX publication list:");
                }
            }

            if (items != null) {
                try {
                    PublicationListWriter writer = new HTMLPublicationListWriter(settings.getGeneralSettings(), settings.getHtmlSettings());
                    writer.writePublicationList(items, settings.getGeneralSettings().getTarget());
                    Console.log("HTML publication list written successfully.");
                } catch (Exception | AssertionError ex) {
                    Console.except(ex, "Exception while writing HTML publication list:");
                }
            }

            Console.log("Done.");
        }
    }
}