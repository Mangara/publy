/*
 * Copyright 2013-2015 Sander Verdonschot <sander.verdonschot at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package publy.gui;

import publy.Constants;
import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent;
import com.apple.eawt.Application;
import com.apple.eawt.PreferencesHandler;
import java.awt.Cursor;
import java.io.IOException;
import javax.swing.JOptionPane;
import publy.Console;
import publy.Runner;
import publy.algo.PublicationListGenerator;
import publy.data.settings.Settings;
import publy.io.settings.SettingsReaderCurrent;

public class ConsoleFrame extends javax.swing.JFrame {

    /**
     * Creates new form ConsoleFrame
     */
    public ConsoleFrame() {
        initComponents();
        setLocationRelativeTo(null); // Center
        
        if (Runner.isMacOS()) {
            addMacMenuListeners();
        }
        
        Console.setOutputTarget(consoleTextPane);
    }

    /**
     * Adds listeners for the default Mac application menu 'Quit', 'About', and 'Preferences' buttons.
     */
    private void addMacMenuListeners() {
        Application macApplication = Application.getApplication();
        
        if (macApplication == null) {
            return;
        }

        macApplication.setAboutHandler(new AboutHandler() {
            @Override
            public void handleAbout(AppEvent.AboutEvent ae) {
                openSettings(MainFrame.Tab.ABOUT);
            }
        });
        
        macApplication.setPreferencesHandler(new PreferencesHandler() {
            @Override
            public void handlePreferences(AppEvent.PreferencesEvent pe) {
                openSettings();
            }
        });
        
        // Quit menu handler is unnecessary: we don't need to do anything special before terminating
    }
    
    private void openSettings() {
        openSettings(null);
    }
    
    private void openSettings(MainFrame.Tab initialTab) {
        // Parse the settings again (the user might have changed them manually)
        Settings settings = null;

        try {
            settings = (new SettingsReaderCurrent()).parseSettings();
        } catch (IOException ex) {
            Console.except(ex, "Exception occurred while parsing the configuration:");
        }

        if (settings == null) {
            // Display an alert to the user
            JOptionPane.showMessageDialog(null, "The configuration could not be parsed. The default configuration will be shown.", "Publy - Launching Settings Window", JOptionPane.WARNING_MESSAGE);
        }
        
        // Create the settings GUI
        MainFrame mainFrame = new MainFrame(settings);
        
        if (initialTab != null) {
            mainFrame.setTab(initialTab);
        }
        
        // The current console text is copied automatically

        // Close this window and open the settings GUI
        dispose();
        mainFrame.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        consoleScrollPane = new javax.swing.JScrollPane();
        consoleTextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publy " + publy.Constants.MAJOR_VERSION + "." + publy.Constants.MINOR_VERSION + " - Console");
        setIconImages(publy.Constants.PUBLY_ICONS);

        generateButton.setText("Generate");
        generateButton.setToolTipText("Run the generator with the current settings.");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        settingsButton.setText("Edit Settings");
        settingsButton.setToolTipText("Opens the settings editor.");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.setToolTipText("Closes the application.");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(buttonPanel, java.awt.BorderLayout.LINE_END);

        consoleScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        consoleTextPane.setEditable(false);
        consoleTextPane.setPreferredSize(new java.awt.Dimension(300, 20));
        consoleScrollPane.setViewportView(consoleTextPane);

        getContentPane().add(consoleScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // Change cursor to hourglass
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        // Clear the console before generating
        consoleTextPane.setText("");
        
        // Parse the settings again (the user might have changed them manually)
        Settings settings = null;

        try {
            settings = (new SettingsReaderCurrent()).parseSettings();
        } catch (IOException ex) {
            Console.except(ex, "Exception occurred while parsing the configuration:");
        }

        if (settings != null) {
            PublicationListGenerator.generatePublicationList(settings);
        }
        
        // Change cursor back
        setCursor(Cursor.getDefaultCursor());
        
        // Open the output file in the browser
        Runner.openFileInBrowser(settings.getFileSettings().getTarget());
    }//GEN-LAST:event_generateButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        openSettings();
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane consoleScrollPane;
    private javax.swing.JTextPane consoleTextPane;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton settingsButton;
    // End of variables declaration//GEN-END:variables
}
