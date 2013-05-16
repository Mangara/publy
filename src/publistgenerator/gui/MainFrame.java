/*
 */
package publistgenerator.gui;

import java.awt.Component;
import java.io.File;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import publistgenerator.GeneratorMain;
import publistgenerator.data.settings.HTMLSettings;
import publistgenerator.data.settings.Settings;
import publistgenerator.io.settings.SettingsWriter;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class MainFrame extends javax.swing.JFrame {

    private Settings settings;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(Settings settings) {
        this.settings = settings;
        initComponents();
        populateValues();
    }

    private void populateValues() {
        // Publications
        if (settings.getPublications() == null) {
            pubTextField.setText("");
            pubFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        } else {
            pubTextField.setText(settings.getPublications().getPath());
            pubFileChooser.setCurrentDirectory(settings.getPublications().getParentFile());
        }
        
        htmlCheckBox.setSelected(settings.generateHTML());
        setHtmlEnabled(settings.generateHTML());
        
        plainCheckBox.setSelected(settings.generateText());
        plainSettingsPanel.setEnabled(settings.generateText());

        // All general settings are already done, so populate HTML-specific settings
        // Header & Footer
        if (settings.getHtmlSettings().getHeader() == null) {
            headerTextField.setText("");
            headerFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        } else {
            headerTextField.setText(settings.getHtmlSettings().getHeader().getPath());
            headerFileChooser.setCurrentDirectory(settings.getHtmlSettings().getHeader().getParentFile());
        }
        
        if (settings.getHtmlSettings().getFooter()== null) {
            footerTextField.setText("");
            footerFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        } else {
            footerTextField.setText(settings.getHtmlSettings().getFooter().getPath());
            footerFileChooser.setCurrentDirectory(settings.getHtmlSettings().getFooter().getParentFile());
        }

        // Link to text
        linkToTextCheckBox.setSelected(settings.getHtmlSettings().linkToTextVersion());

        // Publication links
        abstractComboBox.setSelectedItem(settings.getHtmlSettings().getIncludeAbstract());
        bibtexComboBox.setSelectedItem(settings.getHtmlSettings().getIncludeBibtex());
        pdfComboBox.setSelectedItem(settings.getHtmlSettings().getIncludePDF());

        // Google analytics
        String user = settings.getHtmlSettings().getGoogleAnalyticsUser();
        analyticsUserTextField.setText(user);
        analyticsCheckBox.setSelected(user != null && !user.isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pubFileChooser = new javax.swing.JFileChooser();
        headerFileChooser = new javax.swing.JFileChooser();
        footerFileChooser = new javax.swing.JFileChooser();
        mainSplitPane = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        publicationsPanel = new javax.swing.JPanel();
        pubLabel = new javax.swing.JLabel();
        pubTextField = new javax.swing.JTextField();
        pubBrowseButton = new javax.swing.JButton();
        settingsTabbedPane = new javax.swing.JTabbedPane();
        htmlScrollPane = new javax.swing.JScrollPane();
        htmlPanel = new javax.swing.JPanel();
        htmlCheckBox = new javax.swing.JCheckBox();
        htmlGeneralSettingsPanel = new publistgenerator.gui.GeneralSettingsPanel(settings.getHtmlSettings());
        htmlOnlySettingsPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        headerTextField = new javax.swing.JTextField();
        headerBrowseButton = new javax.swing.JButton();
        footerTextField = new javax.swing.JTextField();
        footerBrowseButton = new javax.swing.JButton();
        linkToTextLabel = new javax.swing.JLabel();
        linkToTextSeparator = new javax.swing.JSeparator();
        linkToTextCheckBox = new javax.swing.JCheckBox();
        linksLabel = new javax.swing.JLabel();
        linksSeparator = new javax.swing.JSeparator();
        abstractLabel = new javax.swing.JLabel();
        abstractComboBox = new javax.swing.JComboBox();
        bibtexLabel = new javax.swing.JLabel();
        pdfLabel = new javax.swing.JLabel();
        bibtexComboBox = new javax.swing.JComboBox();
        pdfComboBox = new javax.swing.JComboBox();
        analyticsLabel = new javax.swing.JLabel();
        analyticsSeparator = new javax.swing.JSeparator();
        analyticsCheckBox = new javax.swing.JCheckBox();
        analyticsUserLabel = new javax.swing.JLabel();
        analyticsUserTextField = new javax.swing.JTextField();
        plainScrollPane = new javax.swing.JScrollPane();
        plainPanel = new javax.swing.JPanel();
        plainCheckBox = new javax.swing.JCheckBox();
        plainSettingsPanel = new publistgenerator.gui.GeneralSettingsPanel(settings.getPlainSettings());
        bottomPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        saveNQuitButton = new javax.swing.JButton();
        consoleScrollPane = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publication List Generator");

        mainSplitPane.setDividerLocation(getHeight() - 150);
        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setResizeWeight(1.0);

        topPanel.setLayout(new java.awt.BorderLayout());

        pubLabel.setText("Publications file:");

        pubTextField.setEditable(false);

        pubBrowseButton.setText("Browse...");
        pubBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout publicationsPanelLayout = new javax.swing.GroupLayout(publicationsPanel);
        publicationsPanel.setLayout(publicationsPanelLayout);
        publicationsPanelLayout.setHorizontalGroup(
            publicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pubLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pubTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pubBrowseButton)
                .addContainerGap())
        );
        publicationsPanelLayout.setVerticalGroup(
            publicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(publicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pubLabel)
                    .addComponent(pubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pubBrowseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        topPanel.add(publicationsPanel, java.awt.BorderLayout.NORTH);

        htmlCheckBox.setSelected(true);
        htmlCheckBox.setText("Generate an HTML publication list");
        htmlCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htmlCheckBoxActionPerformed(evt);
            }
        });

        htmlOnlySettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("HTML-Only Settings"));

        headerLabel.setText("Header & Footer");

        headerTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                headerTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                headerTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });

        headerBrowseButton.setText("Browse...");
        headerBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headerBrowseButtonActionPerformed(evt);
            }
        });

        footerTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                footerTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                footerTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });

        footerBrowseButton.setText("Browse...");
        footerBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                footerBrowseButtonActionPerformed(evt);
            }
        });

        linkToTextLabel.setText("Link to plain text");

        linkToTextCheckBox.setText("Include a link to the plaintext publication list");
        linkToTextCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkToTextCheckBoxActionPerformed(evt);
            }
        });

        linksLabel.setText("Per publication links");

        abstractLabel.setText("Include the abstract for:");

        abstractComboBox.setModel(new DefaultComboBoxModel(HTMLSettings.PublicationType.values()));
        abstractComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abstractComboBoxActionPerformed(evt);
            }
        });

        bibtexLabel.setText("Include the BibTeX for:");

        pdfLabel.setText("Include the PDF for:");

        bibtexComboBox.setModel(new DefaultComboBoxModel(Arrays.copyOfRange(HTMLSettings.PublicationType.values(), 0, 4)));
        bibtexComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bibtexComboBoxActionPerformed(evt);
            }
        });

        pdfComboBox.setModel(new DefaultComboBoxModel(HTMLSettings.PublicationType.values()));
        pdfComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfComboBoxActionPerformed(evt);
            }
        });

        analyticsLabel.setText("Google analytics");

        analyticsCheckBox.setText("Include analytics code");
        analyticsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyticsCheckBoxActionPerformed(evt);
            }
        });

        analyticsUserLabel.setText("Account identifier:");

        analyticsUserTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                analyticsUserTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                analyticsUserTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        analyticsUserTextField.setEnabled(false);

        javax.swing.GroupLayout htmlOnlySettingsPanelLayout = new javax.swing.GroupLayout(htmlOnlySettingsPanel);
        htmlOnlySettingsPanel.setLayout(htmlOnlySettingsPanelLayout);
        htmlOnlySettingsPanelLayout.setHorizontalGroup(
            htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerSeparator))
                    .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                        .addComponent(linkToTextLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linkToTextSeparator))
                    .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                        .addComponent(linksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linksSeparator))
                    .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                        .addComponent(analyticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analyticsSeparator))
                    .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(footerTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(footerBrowseButton))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(headerTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(headerBrowseButton))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(bibtexLabel)
                                .addGap(18, 18, 18)
                                .addComponent(bibtexComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(abstractLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(abstractComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(pdfLabel)
                                .addGap(31, 31, 31)
                                .addComponent(pdfComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(linkToTextCheckBox)
                                    .addComponent(analyticsCheckBox))
                                .addGap(0, 93, Short.MAX_VALUE))
                            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                                .addComponent(analyticsUserLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analyticsUserTextField)))))
                .addContainerGap())
        );
        htmlOnlySettingsPanelLayout.setVerticalGroup(
            htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(htmlOnlySettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(footerBrowseButton))
                .addGap(18, 18, 18)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linkToTextLabel)
                    .addComponent(linkToTextSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linkToTextCheckBox)
                .addGap(18, 18, 18)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linksLabel)
                    .addComponent(linksSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abstractLabel)
                    .addComponent(abstractComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bibtexLabel)
                    .addComponent(bibtexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfLabel)
                    .addComponent(pdfComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(analyticsLabel)
                    .addComponent(analyticsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyticsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(htmlOnlySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyticsUserLabel)
                    .addComponent(analyticsUserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout htmlPanelLayout = new javax.swing.GroupLayout(htmlPanel);
        htmlPanel.setLayout(htmlPanelLayout);
        htmlPanelLayout.setHorizontalGroup(
            htmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(htmlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(htmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(htmlPanelLayout.createSequentialGroup()
                        .addComponent(htmlCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(htmlPanelLayout.createSequentialGroup()
                        .addComponent(htmlGeneralSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(htmlOnlySettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        htmlPanelLayout.setVerticalGroup(
            htmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(htmlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(htmlCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(htmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(htmlGeneralSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(htmlOnlySettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        htmlScrollPane.setViewportView(htmlPanel);

        settingsTabbedPane.addTab("HTML", htmlScrollPane);

        plainCheckBox.setSelected(true);
        plainCheckBox.setText("Generate a plain text publication list");
        plainCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plainPanelLayout = new javax.swing.GroupLayout(plainPanel);
        plainPanel.setLayout(plainPanelLayout);
        plainPanelLayout.setHorizontalGroup(
            plainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plainCheckBox)
                    .addComponent(plainSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        plainPanelLayout.setVerticalGroup(
            plainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plainCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plainSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        plainScrollPane.setViewportView(plainPanel);

        settingsTabbedPane.addTab("Text", plainScrollPane);

        topPanel.add(settingsTabbedPane, java.awt.BorderLayout.CENTER);

        mainSplitPane.setTopComponent(topPanel);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        generateButton.setText("Generate");
        generateButton.setToolTipText("Run the generator with the current settings.");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Closes the application without saving any changes to the settings.");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveNQuitButton.setText("Save & Quit");
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
                    .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveNQuitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveNQuitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomPanel.add(buttonPanel, java.awt.BorderLayout.LINE_END);

        consoleTextArea.setEditable(false);
        consoleTextArea.setColumns(20);
        consoleTextArea.setLineWrap(true);
        consoleTextArea.setRows(5);
        consoleScrollPane.setViewportView(consoleTextArea);

        bottomPanel.add(consoleScrollPane, java.awt.BorderLayout.CENTER);

        mainSplitPane.setRightComponent(bottomPanel);

        getContentPane().add(mainSplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        GeneratorMain.generatePublicationList(settings);
    }//GEN-LAST:event_generateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveNQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNQuitButtonActionPerformed
        SettingsWriter.writeSettings(settings);
        dispose();
    }//GEN-LAST:event_saveNQuitButtonActionPerformed

    private void pubBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubBrowseButtonActionPerformed
        int opened = pubFileChooser.showOpenDialog(this);

        if (opened == JFileChooser.APPROVE_OPTION) {
            pubTextField.setText(pubFileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_pubBrowseButtonActionPerformed

    private void htmlCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htmlCheckBoxActionPerformed
        // Update the settings
        settings.setGenerateHTML(htmlCheckBox.isSelected());

        // Update the UI
        setHtmlEnabled(htmlCheckBox.isSelected());
    }//GEN-LAST:event_htmlCheckBoxActionPerformed

    private void setHtmlEnabled(boolean enabled) {
        htmlGeneralSettingsPanel.setEnabled(enabled);

        htmlOnlySettingsPanel.setEnabled(enabled);
        for (Component c : htmlOnlySettingsPanel.getComponents()) {
            c.setEnabled(enabled);
        }

        analyticsUserTextField.setEnabled(enabled && analyticsCheckBox.isSelected());
    }
    
    private void linkToTextCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkToTextCheckBoxActionPerformed
        settings.getHtmlSettings().setLinkToTextVersion(linkToTextCheckBox.isSelected());
    }//GEN-LAST:event_linkToTextCheckBoxActionPerformed

    private void analyticsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyticsCheckBoxActionPerformed
        if (analyticsCheckBox.isSelected()) {
            // Update settings
            settings.getHtmlSettings().setGoogleAnalyticsUser(analyticsUserTextField.getText());

            // Update UI
            analyticsUserTextField.setEnabled(true);
        } else {
            // Update settings
            settings.getHtmlSettings().setGoogleAnalyticsUser(null);

            // Update UI
            analyticsUserTextField.setEnabled(false);
        }
    }//GEN-LAST:event_analyticsCheckBoxActionPerformed

    private void abstractComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abstractComboBoxActionPerformed
        settings.getHtmlSettings().setIncludeAbstract((HTMLSettings.PublicationType) abstractComboBox.getSelectedItem());
    }//GEN-LAST:event_abstractComboBoxActionPerformed

    private void bibtexComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bibtexComboBoxActionPerformed
        settings.getHtmlSettings().setIncludeBibtex((HTMLSettings.PublicationType) bibtexComboBox.getSelectedItem());
    }//GEN-LAST:event_bibtexComboBoxActionPerformed

    private void pdfComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfComboBoxActionPerformed
        settings.getHtmlSettings().setIncludePDF((HTMLSettings.PublicationType) pdfComboBox.getSelectedItem());
    }//GEN-LAST:event_pdfComboBoxActionPerformed

    private void headerBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headerBrowseButtonActionPerformed
        int opened = headerFileChooser.showOpenDialog(this);

        if (opened == JFileChooser.APPROVE_OPTION) {
            headerTextField.setText(headerFileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_headerBrowseButtonActionPerformed

    private void footerBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_footerBrowseButtonActionPerformed
        int opened = footerFileChooser.showOpenDialog(this);

        if (opened == JFileChooser.APPROVE_OPTION) {
            footerTextField.setText(footerFileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_footerBrowseButtonActionPerformed

    private void plainCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plainCheckBoxActionPerformed
        // Update the settings
        settings.setGenerateText(plainCheckBox.isSelected());

        // Update the UI
        plainSettingsPanel.setEnabled(plainCheckBox.isSelected());
    }//GEN-LAST:event_plainCheckBoxActionPerformed

    private void analyticsUserTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        settings.getHtmlSettings().setGoogleAnalyticsUser(analyticsUserTextField.getText());
    }

    private void headerTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        settings.getHtmlSettings().setHeader(new File(headerTextField.getText()));
    }

    private void footerTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        settings.getHtmlSettings().setFooter(new File(footerTextField.getText()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(new Settings()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox abstractComboBox;
    private javax.swing.JLabel abstractLabel;
    private javax.swing.JCheckBox analyticsCheckBox;
    private javax.swing.JLabel analyticsLabel;
    private javax.swing.JSeparator analyticsSeparator;
    private javax.swing.JLabel analyticsUserLabel;
    private javax.swing.JTextField analyticsUserTextField;
    private javax.swing.JComboBox bibtexComboBox;
    private javax.swing.JLabel bibtexLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane consoleScrollPane;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JButton footerBrowseButton;
    private javax.swing.JFileChooser footerFileChooser;
    private javax.swing.JTextField footerTextField;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton headerBrowseButton;
    private javax.swing.JFileChooser headerFileChooser;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JTextField headerTextField;
    private javax.swing.JCheckBox htmlCheckBox;
    private publistgenerator.gui.GeneralSettingsPanel htmlGeneralSettingsPanel;
    private javax.swing.JPanel htmlOnlySettingsPanel;
    private javax.swing.JPanel htmlPanel;
    private javax.swing.JScrollPane htmlScrollPane;
    private javax.swing.JCheckBox linkToTextCheckBox;
    private javax.swing.JLabel linkToTextLabel;
    private javax.swing.JSeparator linkToTextSeparator;
    private javax.swing.JLabel linksLabel;
    private javax.swing.JSeparator linksSeparator;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JComboBox pdfComboBox;
    private javax.swing.JLabel pdfLabel;
    private javax.swing.JCheckBox plainCheckBox;
    private javax.swing.JPanel plainPanel;
    private javax.swing.JScrollPane plainScrollPane;
    private publistgenerator.gui.GeneralSettingsPanel plainSettingsPanel;
    private javax.swing.JButton pubBrowseButton;
    private javax.swing.JFileChooser pubFileChooser;
    private javax.swing.JLabel pubLabel;
    private javax.swing.JTextField pubTextField;
    private javax.swing.JPanel publicationsPanel;
    private javax.swing.JButton saveNQuitButton;
    private javax.swing.JTabbedPane settingsTabbedPane;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
