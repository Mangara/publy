/*
 */
package publistgenerator.gui;

import java.awt.Component;
import java.util.EnumSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import publistgenerator.data.category.CategoryIdentifier;
import publistgenerator.data.settings.FormatSettings;
import publistgenerator.io.ResourceLocator;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class GeneralSettingsPanel extends javax.swing.JPanel {

    private FormatSettings settings;
    private DefaultListModel<CategoryIdentifier> inListModel;
    private DefaultListModel<CategoryIdentifier> outListModel;
    private CategoryIdentifier selectedCategory = null;

    /**
     * Empty constructor, for use in the NetBeans GUI editor.
     */
    public GeneralSettingsPanel() {
        initComponents();
    }

    /**
     * Creates new form GeneralSettingsPanel
     */
    public GeneralSettingsPanel(FormatSettings settings) {
        this.settings = settings;
        initComponents();
        populateValues();
    }

    @SuppressWarnings("unchecked")
    private void populateValues() {
        // Target
        updateTarget();

        // List all authors
        if (settings.isListAllAuthors()) {
            listAllRadioButton.setSelected(true);
        } else {
            listOtherRadioButton.setSelected(true);
        }

        // PresentedText
        if (settings.getPresentedText() == null) {
            presentedTextField.setText("");
        } else {
            presentedTextField.setText(settings.getPresentedText());
        }

        // Numbering
        switch (settings.getNumbering()) {
            case NONE:
                numNoneRadioButton.setSelected(true);
                break;
            case LOCAL:
                numLocalRadioButton.setSelected(true);
                break;
            case GLOBAL:
                numGlobalRadioButton.setSelected(true);
                break;
            default:
                throw new AssertionError("Unknown numbering: " + settings.getNumbering());
        }

        // Categories
        inListModel = new DefaultListModel<>();
        outListModel = new DefaultListModel<>();
        
        Set<CategoryIdentifier> out = EnumSet.allOf(CategoryIdentifier.class);

        for (CategoryIdentifier c : settings.getCategories()) {
            inListModel.addElement(c);
            out.remove(c);
        }

        for (CategoryIdentifier c : out) {
            outListModel.addElement(c);
        }

        inCatList.setModel(inListModel);
        outCatList.setModel(outListModel);
    }

    /**
     * Refreshes the target from the current settings. This property is
     * sometimes set by the MainFrame.
     */
    void updateTarget() {
        if (settings.getTarget() == null) {
            targetTextField.setText("");
            targetFileChooser.setCurrentDirectory(ResourceLocator.getBaseDirectory().toFile());
        } else {
            targetTextField.setText(ResourceLocator.getRelativePath(settings.getTarget()));
            targetFileChooser.setCurrentDirectory(settings.getTarget().getParent().toFile());
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        // Dis/enable all components
        for (Component c : getComponents()) {
            c.setEnabled(enabled);
        }

        // Handle components that are not directly on the main panel
        inCatList.setEnabled(enabled);
        outCatList.setEnabled(enabled);

        noteLabel.setEnabled(enabled);
        noteTextField.setEnabled(enabled && selectedCategory != null);

        // Handle the buttons correctly
        if (enabled) {
            if (inCatList.getSelectedIndex() > -1) {
                inButton.setEnabled(false);
                outButton.setEnabled(true);
                upButton.setEnabled(inCatList.getSelectedIndex() > 0);
                downButton.setEnabled(inCatList.getSelectedIndex() < inListModel.getSize() - 1);
            } else if (outCatList.getSelectedIndex() > -1) {
                inButton.setEnabled(true);
                outButton.setEnabled(false);
                upButton.setEnabled(false);
                downButton.setEnabled(false);
            } else {
                // No selection
                inButton.setEnabled(false);
                outButton.setEnabled(false);
                upButton.setEnabled(false);
                downButton.setEnabled(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listGroup = new javax.swing.ButtonGroup();
        numGroup = new javax.swing.ButtonGroup();
        targetFileChooser = new javax.swing.JFileChooser();
        targetTextField = new javax.swing.JTextField();
        targetBrowseButton = new javax.swing.JButton();
        presentedLabel = new javax.swing.JLabel();
        presentedTextField = new javax.swing.JTextField();
        numNoneRadioButton = new javax.swing.JRadioButton();
        numGlobalRadioButton = new javax.swing.JRadioButton();
        numLocalRadioButton = new javax.swing.JRadioButton();
        targetLabel = new javax.swing.JLabel();
        targetSeparator = new javax.swing.JSeparator();
        authorLabel = new javax.swing.JLabel();
        authorSeparator = new javax.swing.JSeparator();
        presentedSeparator = new javax.swing.JSeparator();
        listAllRadioButton = new javax.swing.JRadioButton();
        listOtherRadioButton = new javax.swing.JRadioButton();
        numLabel = new javax.swing.JLabel();
        numSeparator = new javax.swing.JSeparator();
        catLabel = new javax.swing.JLabel();
        catSeparator = new javax.swing.JSeparator();
        catPanel = new javax.swing.JPanel();
        noteLabel = new javax.swing.JLabel();
        noteSeparator = new javax.swing.JSeparator();
        noteTextField = new javax.swing.JTextField();
        inCatScrollPane = new javax.swing.JScrollPane();
        inCatList = new javax.swing.JList();
        inButton = new javax.swing.JButton();
        outButton = new javax.swing.JButton();
        catButtonSeparator = new javax.swing.JSeparator();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        outCatScrollPane = new javax.swing.JScrollPane();
        outCatList = new javax.swing.JList();

        setBorder(javax.swing.BorderFactory.createTitledBorder("General Settings"));

        targetTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                targetTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                targetTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        targetTextField.setColumns(30);
        targetTextField.setToolTipText("This file will be created or overridden with a list of your publications.");

        targetBrowseButton.setText("Browse...");
        targetBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetBrowseButtonActionPerformed(evt);
            }
        });

        presentedLabel.setText("Text added after papers I presented");

        presentedTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                presentedTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                presentedTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        presentedTextField.setColumns(40);

        numGroup.add(numNoneRadioButton);
        numNoneRadioButton.setText("None");
        numNoneRadioButton.setToolTipText("Do not number any publications.");
        numNoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numNoneRadioButtonActionPerformed(evt);
            }
        });

        numGroup.add(numGlobalRadioButton);
        numGlobalRadioButton.setText("Global numbering");
        numGlobalRadioButton.setToolTipText("Number all publications sequentially, with no regard to sections.");
        numGlobalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numGlobalRadioButtonActionPerformed(evt);
            }
        });

        numGroup.add(numLocalRadioButton);
        numLocalRadioButton.setText("Section numbering");
        numLocalRadioButton.setToolTipText("Number the publications in each section independently.");
        numLocalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numLocalRadioButtonActionPerformed(evt);
            }
        });

        targetLabel.setText("Output file");

        authorLabel.setText("Author information");

        listGroup.add(listAllRadioButton);
        listAllRadioButton.setText("List all authors");
        listAllRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllRadioButtonActionPerformed(evt);
            }
        });

        listGroup.add(listOtherRadioButton);
        listOtherRadioButton.setText("List only my co-authors");
        listOtherRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOtherRadioButtonActionPerformed(evt);
            }
        });

        numLabel.setText("Publication numbering");

        catLabel.setText("Category selection");

        catPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Category Settings"));

        noteLabel.setText("Text at the start");

        noteTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                noteTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                noteTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        noteTextField.setColumns(20);
        noteTextField.setToolTipText("This text will be inserted after the category heading, before the publications in the category.");
        noteTextField.setEnabled(false);

        javax.swing.GroupLayout catPanelLayout = new javax.swing.GroupLayout(catPanel);
        catPanel.setLayout(catPanelLayout);
        catPanelLayout.setHorizontalGroup(
            catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catPanelLayout.createSequentialGroup()
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(catPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(noteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noteSeparator))
                    .addGroup(catPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        catPanelLayout.setVerticalGroup(
            catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noteSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inCatList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        inCatList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inCatList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                inCatListValueChanged(evt);
            }
        });
        inCatScrollPane.setViewportView(inCatList);

        inButton.setText("<html>&larr;</html>");
        inButton.setToolTipText("Include the selected category.");
        inButton.setEnabled(false);
        inButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inButtonActionPerformed(evt);
            }
        });

        outButton.setText("<html>&rarr;</html>");
        outButton.setToolTipText("Remove the selected category.");
        outButton.setEnabled(false);
        outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outButtonActionPerformed(evt);
            }
        });

        upButton.setText("<html>&uarr;</html>");
        upButton.setToolTipText("Move the selected category up.");
        upButton.setEnabled(false);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText("<html>&darr;</html>");
        downButton.setToolTipText("Move the selected category down.");
        downButton.setEnabled(false);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        outCatList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        outCatList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        outCatList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                outCatListValueChanged(evt);
            }
        });
        outCatScrollPane.setViewportView(outCatList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numSeparator)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(presentedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(presentedSeparator)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(authorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorSeparator))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(targetLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(targetSeparator))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(listAllRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(listOtherRadioButton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(targetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(targetBrowseButton)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(catSeparator)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(presentedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numNoneRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(numLocalRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(numGlobalRadioButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inCatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inButton)
                                            .addComponent(outButton)
                                            .addComponent(upButton)
                                            .addComponent(downButton)
                                            .addComponent(catButtonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(outCatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inCatScrollPane, outCatScrollPane});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(targetLabel)
                    .addComponent(targetSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetBrowseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(authorSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listAllRadioButton)
                    .addComponent(listOtherRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(presentedLabel)
                    .addComponent(presentedSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presentedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numLabel)
                    .addComponent(numSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNoneRadioButton)
                    .addComponent(numLocalRadioButton)
                    .addComponent(numGlobalRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(catSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(catButtonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inCatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(outCatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(catPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void targetBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetBrowseButtonActionPerformed
        int opened = targetFileChooser.showOpenDialog(this);

        if (opened == JFileChooser.APPROVE_OPTION) {
            targetTextField.setText(ResourceLocator.getRelativePath(targetFileChooser.getSelectedFile().toPath()));
        }
    }//GEN-LAST:event_targetBrowseButtonActionPerformed

    private void targetTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        settings.setTarget(ResourceLocator.getFullPath(targetTextField.getText()));
    }

    private void presentedTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        settings.setPresentedText(presentedTextField.getText());
    }

    private void noteTextFieldTextChanged(javax.swing.event.DocumentEvent evt) {
        // Update the settings
        if (selectedCategory != null) {
            settings.getCategoryNotes().put(selectedCategory, noteTextField.getText());
        }
    }

    private void inButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inButtonActionPerformed
        CategoryIdentifier selected = (CategoryIdentifier) outCatList.getSelectedValue();

        // Update the UI
        inListModel.addElement(selected);
        outListModel.removeElement(selected);

        inCatList.setSelectedValue(selected, true);

        // Update the settings
        settings.getCategories().add(selected);
    }//GEN-LAST:event_inButtonActionPerformed

    private void outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outButtonActionPerformed
        CategoryIdentifier selected = (CategoryIdentifier) inCatList.getSelectedValue();

        // Update the UI
        outListModel.addElement(selected);
        inListModel.removeElement(selected);

        outCatList.setSelectedValue(selected, true);

        // Update the settings
        settings.getCategories().remove(selected);
    }//GEN-LAST:event_outButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int selected = inCatList.getSelectedIndex();

        if (selected > 0) {
            // Update the UI
            CategoryIdentifier up = inListModel.set(selected - 1, selectedCategory);
            inListModel.set(selected, up);
            inCatList.setSelectedValue(selectedCategory, true);

            // Update the settings
            settings.getCategories().set(selected - 1, selectedCategory);
            settings.getCategories().set(selected, up);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int selected = inCatList.getSelectedIndex();

        if (selected < inListModel.getSize() - 1) {
            // Update the UI
            CategoryIdentifier down = inListModel.set(selected + 1, selectedCategory);
            inListModel.set(selected, down);
            inCatList.setSelectedValue(selectedCategory, true);

            // Update the settings
            settings.getCategories().set(selected + 1, selectedCategory);
            settings.getCategories().set(selected, down);
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void setSelectedCategory(CategoryIdentifier c) {
        selectedCategory = c;

        if (c == null) {
            // Note
            noteTextField.setText("");
            noteTextField.setEnabled(false);
        } else {
            // Note
            noteTextField.setText(settings.getCategoryNotes().get(c));
            noteTextField.setEnabled(true);
        }
    }

    private void inCatListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_inCatListValueChanged
        if (!evt.getValueIsAdjusting()) {
            int selected = inCatList.getSelectedIndex();

            if (selected == -1) {
                // No selection, disable buttons
                outButton.setEnabled(false);
                upButton.setEnabled(false);
                downButton.setEnabled(false);

                if (outCatList.getSelectedIndex() == -1) {
                    // No selection at all, disable category settings
                    setSelectedCategory(null);
                }
            } else {
                // Selection, enable buttons
                outButton.setEnabled(true);

                upButton.setEnabled(selected > 0);
                downButton.setEnabled(selected < inListModel.getSize() - 1);

                // Remove selection in the out list
                outCatList.clearSelection();

                setSelectedCategory((CategoryIdentifier) inCatList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_inCatListValueChanged

    private void outCatListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_outCatListValueChanged
        if (!evt.getValueIsAdjusting()) {
            if (outCatList.getSelectedIndex() == -1) {
                //No selection, disable button
                inButton.setEnabled(false);

                if (inCatList.getSelectedIndex() == -1) {
                    // No selection at all, disable category settings
                    setSelectedCategory(null);
                }
            } else {
                //Selection, enable button
                inButton.setEnabled(true);

                // Remove selection in the in list
                inCatList.clearSelection();

                setSelectedCategory((CategoryIdentifier) outCatList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_outCatListValueChanged

    private void listAllRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllRadioButtonActionPerformed
        settings.setListAllAuthors(true);
    }//GEN-LAST:event_listAllRadioButtonActionPerformed

    private void listOtherRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOtherRadioButtonActionPerformed
        settings.setListAllAuthors(false);
    }//GEN-LAST:event_listOtherRadioButtonActionPerformed

    private void numNoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numNoneRadioButtonActionPerformed
        settings.setNumbering(FormatSettings.Numbering.NONE);
    }//GEN-LAST:event_numNoneRadioButtonActionPerformed

    private void numLocalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numLocalRadioButtonActionPerformed
        settings.setNumbering(FormatSettings.Numbering.LOCAL);
    }//GEN-LAST:event_numLocalRadioButtonActionPerformed

    private void numGlobalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numGlobalRadioButtonActionPerformed
        settings.setNumbering(FormatSettings.Numbering.GLOBAL);
    }//GEN-LAST:event_numGlobalRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JSeparator authorSeparator;
    private javax.swing.JSeparator catButtonSeparator;
    private javax.swing.JLabel catLabel;
    private javax.swing.JPanel catPanel;
    private javax.swing.JSeparator catSeparator;
    private javax.swing.JButton downButton;
    private javax.swing.JButton inButton;
    private javax.swing.JList inCatList;
    private javax.swing.JScrollPane inCatScrollPane;
    private javax.swing.JRadioButton listAllRadioButton;
    private javax.swing.ButtonGroup listGroup;
    private javax.swing.JRadioButton listOtherRadioButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JSeparator noteSeparator;
    private javax.swing.JTextField noteTextField;
    private javax.swing.JRadioButton numGlobalRadioButton;
    private javax.swing.ButtonGroup numGroup;
    private javax.swing.JLabel numLabel;
    private javax.swing.JRadioButton numLocalRadioButton;
    private javax.swing.JRadioButton numNoneRadioButton;
    private javax.swing.JSeparator numSeparator;
    private javax.swing.JButton outButton;
    private javax.swing.JList outCatList;
    private javax.swing.JScrollPane outCatScrollPane;
    private javax.swing.JLabel presentedLabel;
    private javax.swing.JSeparator presentedSeparator;
    private javax.swing.JTextField presentedTextField;
    private javax.swing.JButton targetBrowseButton;
    private javax.swing.JFileChooser targetFileChooser;
    private javax.swing.JLabel targetLabel;
    private javax.swing.JSeparator targetSeparator;
    private javax.swing.JTextField targetTextField;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
