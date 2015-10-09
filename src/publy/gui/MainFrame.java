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

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import publy.Console;
import publy.Runner;
import publy.algo.PublicationListGenerator;
import publy.data.settings.Settings;
import publy.io.settings.SettingsWriter;

/**
 *
 *
 */
public class MainFrame extends javax.swing.JFrame {

    private final Settings settings;

    /**
     * Creates new form MainFrame
     *
     * @param settings
     */
    public MainFrame(Settings settings) {
        this.settings = settings;

        initComponents();        
        changeTabs();
        setLocationRelativeTo(null); // Center

        // Make sure all console output from the generation is redirected to the text area.
        Console.setOutputTarget(consoleTextPane);

        // Make sure the console reads from the correct settings object
        Console.setSettings(settings.getConsoleSettings());
    }

    private void changeTabs() {
        if (Runner.isMacOS()) { // OSX doesn't handle custom tabs well
            settingsTabbedPane.setTabPlacement(JTabbedPane.TOP);
            this.setPreferredSize(new Dimension(getWidth(), getHeight() + 50));
            pack();
        } else {
            settingsTabbedPane.setTabComponentAt(0, new TabTitle("Files", new ImageIcon(getClass().getResource("/publy/gui/resources/folder-32.png")))); // Files
            settingsTabbedPane.setTabComponentAt(1, new TabTitle("Categories", new ImageIcon(getClass().getResource("/publy/gui/resources/puzzle-32.png")))); // Categories
            settingsTabbedPane.setTabComponentAt(2, new TabTitle("General", new ImageIcon(getClass().getResource("/publy/gui/resources/document-32.png")))); // General
            settingsTabbedPane.setTabComponentAt(3, new TabTitle("HTML", new ImageIcon(getClass().getResource("/publy/gui/resources/globe-32.png")))); // HTML
            settingsTabbedPane.setTabComponentAt(4, new TabTitle("Console", new ImageIcon(getClass().getResource("/publy/gui/resources/console-32.png")))); // Console
            settingsTabbedPane.setTabComponentAt(5, new TabTitle("About", new ImageIcon(getClass().getResource("/publy/gui/resources/about-32.png")))); // About
        }
    }

    public Settings getSettings() {
        return settings;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSplitPane = new javax.swing.JSplitPane();
        settingsTabbedPane = new javax.swing.JTabbedPane();
        fileSettingsPanel = new publy.gui.FileSettingsPanel(settings.getFileSettings());
        categorySettingsPanel = new publy.gui.CategorySettingsPanel(settings.getCategorySettings());
        generalSettingsPanel = new publy.gui.GeneralSettingsPanel(settings.getGeneralSettings());
        htmlSettingsPanel = new publy.gui.HTMLSettingsPanel(settings.getHtmlSettings());
        consoleSettingsPanel = new publy.gui.ConsoleSettingsPanel(settings.getConsoleSettings());
        aboutPanel = new publy.gui.AboutPanel();
        bottomPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        saveNQuitButton = new javax.swing.JButton();
        consoleScrollPane = new javax.swing.JScrollPane();
        consoleTextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publy " + UIConstants.MAJOR_VERSION + "." + UIConstants.MINOR_VERSION);
        setIconImages(UIConstants.PUBLY_ICONS);
        setPreferredSize(new java.awt.Dimension(670, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainSplitPane.setDividerLocation(getHeight() - 150);
        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        settingsTabbedPane.setFont(settingsTabbedPane.getFont().deriveFont(settingsTabbedPane.getFont().getSize2D() + 2));
        settingsTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        settingsTabbedPane.addTab("Files", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/folder-16.png")), fileSettingsPanel); // NOI18N
        settingsTabbedPane.addTab("Categories", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/puzzle-16.png")), categorySettingsPanel); // NOI18N
        settingsTabbedPane.addTab("General", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/document-16.png")), generalSettingsPanel); // NOI18N
        settingsTabbedPane.addTab("HTML", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/globe-16.png")), htmlSettingsPanel); // NOI18N
        settingsTabbedPane.addTab("Console", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/console-16.png")), consoleSettingsPanel); // NOI18N
        settingsTabbedPane.addTab("About", new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/about-16.png")), aboutPanel); // NOI18N

        mainSplitPane.setTopComponent(settingsTabbedPane);

        bottomPanel.setPreferredSize(new java.awt.Dimension(117, 143));
        bottomPanel.setLayout(new java.awt.BorderLayout());

        generateButton.setText("Generate");
        generateButton.setToolTipText("Run the generator with the current settings.");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        saveNQuitButton.setText("Exit");
        saveNQuitButton.setToolTipText("Closes the application and saves all changes to the settings.");
        saveNQuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNQuitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(saveNQuitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveNQuitButton)
                .addContainerGap())
        );

        bottomPanel.add(buttonPanel, java.awt.BorderLayout.LINE_END);

        consoleTextPane.setEditable(false);
        consoleScrollPane.setViewportView(consoleTextPane);

        bottomPanel.add(consoleScrollPane, java.awt.BorderLayout.CENTER);

        mainSplitPane.setBottomComponent(bottomPanel);

        getContentPane().add(mainSplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // Change cursor to hourglass
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // Clear the console before generating
        consoleTextPane.setText("");

        PublicationListGenerator.generatePublicationList(settings);

        // Move to the top of the console output
        consoleTextPane.setCaretPosition(0);

        // Change cursor back
        setCursor(Cursor.getDefaultCursor());
        
        // Open the output file in the browser
        Runner.openFileInBrowser(settings.getFileSettings().getTarget());
    }//GEN-LAST:event_generateButtonActionPerformed

    private void saveNQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNQuitButtonActionPerformed
        try {
            SettingsWriter.writeSettings(settings);
            dispose();
        } catch (Exception | AssertionError ex) {
            Console.except(ex, "Exception when saving settings:");
        }
    }//GEN-LAST:event_saveNQuitButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            SettingsWriter.writeSettings(settings);
        } catch (Exception | AssertionError ex) {
            Console.except(ex, "Exception when saving settings:");
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private publy.gui.AboutPanel aboutPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel buttonPanel;
    private publy.gui.CategorySettingsPanel categorySettingsPanel;
    private javax.swing.JScrollPane consoleScrollPane;
    private publy.gui.ConsoleSettingsPanel consoleSettingsPanel;
    private javax.swing.JTextPane consoleTextPane;
    private publy.gui.FileSettingsPanel fileSettingsPanel;
    private publy.gui.GeneralSettingsPanel generalSettingsPanel;
    private javax.swing.JButton generateButton;
    private publy.gui.HTMLSettingsPanel htmlSettingsPanel;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JButton saveNQuitButton;
    private javax.swing.JTabbedPane settingsTabbedPane;
    // End of variables declaration//GEN-END:variables
}
