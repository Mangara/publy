/*
 * Copyright 2013 Sander Verdonschot <sander.verdonschot at gmail.com>.
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

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import publy.data.category.OutputCategory;
import publy.data.category.conditions.TypeCondition;
import publy.data.settings.CategorySettings;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class CategorySettingsPanel extends javax.swing.JPanel {

    private CategorySettings settings;
    private DefaultListModel<OutputCategory> inListModel;
    private DefaultListModel<OutputCategory> outListModel;
    private OutputCategory selectedCategory = null;

    /**
     * Empty constructor, for use in the NetBeans GUI editor.
     */
    public CategorySettingsPanel() {
        settings = CategorySettings.defaultSettings();
        initComponents();
        applyStyles();
        populateValues();
    }

    /**
     * Creates new form FileSettingsPanel
     */
    public CategorySettingsPanel(CategorySettings settings) {
        this.settings = settings;
        initComponents();
        applyStyles();
        populateValues();
    }

    private void applyStyles() {
        UIStyles.applyHeaderStyle(catSelectionHeader, nameHeader, noteHeader, filtersHeader);
        UIStyles.applyHeaderStyle((TitledBorder) catPanel.getBorder());
    }

    @SuppressWarnings("unchecked")
    private void populateValues() {
        // Categories
        inListModel = new DefaultListModel<>();
        outListModel = new DefaultListModel<>();

        List<OutputCategory> out = new ArrayList<>(settings.getAllCategories());

        for (OutputCategory c : settings.getActiveCategories()) {
            inListModel.addElement(c);
            out.remove(c);
        }

        for (OutputCategory c : out) {
            outListModel.addElement(c);
        }

        inCatList.setModel(inListModel);
        outCatList.setModel(outListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inCatScrollPane = new javax.swing.JScrollPane();
        inCatList = new javax.swing.JList<OutputCategory>();
        catPanel = new javax.swing.JPanel();
        noteHeader = new javax.swing.JLabel();
        noteSeparator = new javax.swing.JSeparator();
        noteTextField = new javax.swing.JTextField();
        nameHeader = new javax.swing.JLabel();
        shortNameLabel = new javax.swing.JLabel();
        nameSeparator = new javax.swing.JSeparator();
        shortNameTextField = new javax.swing.JTextField();
        fullNameLabel = new javax.swing.JLabel();
        fullNameTextField = new javax.swing.JTextField();
        filtersHeader = new javax.swing.JLabel();
        filtersSeparator = new javax.swing.JSeparator();
        editFiltersButton = new javax.swing.JButton();
        catSelectionHeader = new javax.swing.JLabel();
        catSeparator = new javax.swing.JSeparator();
        inButton = new javax.swing.JButton();
        outButton = new javax.swing.JButton();
        catButtonSeparator = new javax.swing.JSeparator();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        outCatScrollPane = new javax.swing.JScrollPane();
        outCatList = new javax.swing.JList<OutputCategory>();
        newCategoryButton = new javax.swing.JButton();
        deleteCategoryButton = new javax.swing.JButton();

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

        catPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Category Properties"));

        noteHeader.setText("HTML Note");

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

        nameHeader.setText("Name");

        shortNameLabel.setText("Short:");

        shortNameTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                shortNameTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                shortNameTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        shortNameTextField.setEnabled(false);

        fullNameLabel.setText("Full:");

        fullNameTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                fullNameTextFieldTextChanged(e);
            }
            public void removeUpdate(DocumentEvent e) {
                fullNameTextFieldTextChanged(e);
            }
            public void changedUpdate(DocumentEvent e) {
                //Plain text components do not fire these events
            }
        });
        fullNameTextField.setEnabled(false);

        filtersHeader.setText("Filters");

        editFiltersButton.setText("Edit Filters...");
        editFiltersButton.setEnabled(false);

        javax.swing.GroupLayout catPanelLayout = new javax.swing.GroupLayout(catPanel);
        catPanel.setLayout(catPanelLayout);
        catPanelLayout.setHorizontalGroup(
            catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catPanelLayout.createSequentialGroup()
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(catPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(catPanelLayout.createSequentialGroup()
                                .addComponent(nameHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameSeparator))
                            .addGroup(catPanelLayout.createSequentialGroup()
                                .addComponent(noteHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteSeparator))
                            .addGroup(catPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(catPanelLayout.createSequentialGroup()
                                        .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(shortNameLabel)
                                            .addComponent(fullNameLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(shortNameTextField)
                                            .addComponent(fullNameTextField)))
                                    .addComponent(noteTextField)))))
                    .addGroup(catPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(catPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(editFiltersButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(catPanelLayout.createSequentialGroup()
                                .addComponent(filtersHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtersSeparator)))))
                .addContainerGap())
        );
        catPanelLayout.setVerticalGroup(
            catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameHeader)
                    .addComponent(nameSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortNameLabel)
                    .addComponent(shortNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameLabel)
                    .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noteHeader)
                    .addComponent(noteSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(catPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filtersHeader)
                    .addComponent(filtersSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editFiltersButton)
                .addContainerGap())
        );

        catSelectionHeader.setText("Category selection");

        inButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/left-26.png"))); // NOI18N
        inButton.setToolTipText("Include category");
        inButton.setEnabled(false);
        inButton.setPreferredSize(new java.awt.Dimension(40, 40));
        inButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inButtonActionPerformed(evt);
            }
        });

        outButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/right-26.png"))); // NOI18N
        outButton.setToolTipText("Exclude category");
        outButton.setEnabled(false);
        outButton.setPreferredSize(new java.awt.Dimension(40, 40));
        outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outButtonActionPerformed(evt);
            }
        });

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/up-26.png"))); // NOI18N
        upButton.setToolTipText("Move up");
        upButton.setEnabled(false);
        upButton.setPreferredSize(new java.awt.Dimension(40, 40));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/down-26.png"))); // NOI18N
        downButton.setToolTipText("Move down");
        downButton.setEnabled(false);
        downButton.setPreferredSize(new java.awt.Dimension(40, 40));
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

        newCategoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/add_list-26.png"))); // NOI18N
        newCategoryButton.setToolTipText("New category");
        newCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCategoryButtonActionPerformed(evt);
            }
        });

        deleteCategoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publy/gui/resources/delete-26.png"))); // NOI18N
        deleteCategoryButton.setToolTipText("Delete category");
        deleteCategoryButton.setEnabled(false);
        deleteCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(inCatScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(catButtonSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(inButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outCatScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(newCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catSelectionHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(catSeparator))
                    .addComponent(catPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {catButtonSeparator, deleteCategoryButton, downButton, inButton, newCategoryButton, outButton, upButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(catSelectionHeader)
                    .addComponent(catSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newCategoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteCategoryButton))
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
                        .addComponent(inCatScrollPane)
                        .addComponent(outCatScrollPane)))
                .addGap(18, 18, 18)
                .addComponent(catPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteCategoryButton, downButton, inButton, newCategoryButton, outButton, upButton});

    }// </editor-fold>//GEN-END:initComponents

    private void noteTextFieldTextChanged(DocumentEvent evt) {
        if (selectedCategory != null) {
            selectedCategory.setHtmlNote(noteTextField.getText());
        }
    }
    
    private void fullNameTextFieldTextChanged(DocumentEvent evt) {
        if (selectedCategory != null) {
            selectedCategory.setName(fullNameTextField.getText());
        }
    }
    
    private void shortNameTextFieldTextChanged(DocumentEvent evt) {
        if (selectedCategory != null) {
            selectedCategory.setShortName(shortNameTextField.getText());
            
            // Repaint the lists so the name updates there as well
            inCatList.repaint();
            outCatList.repaint();
        }
    }

    private void setSelectedCategory(OutputCategory c) {
        selectedCategory = c;
        boolean active = c != null;

        // Name
        shortNameTextField.setText(active ? c.getShortName(): "");
        shortNameTextField.setEnabled(active);
        fullNameTextField.setText(active ? c.getName(): "");
        fullNameTextField.setEnabled(active);
        
        // Note
        noteTextField.setText(active ? c.getHtmlNote() : "");
        noteTextField.setEnabled(active);
        
        // Filters
        editFiltersButton.setEnabled(active);
        
        // Delete
        deleteCategoryButton.setEnabled(active);
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

                setSelectedCategory(inCatList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_inCatListValueChanged

    private void inButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inButtonActionPerformed
        OutputCategory selected = outCatList.getSelectedValue();

        // Update the UI
        inListModel.addElement(selected);
        outListModel.removeElement(selected);

        inCatList.setSelectedValue(selected, true);

        // Update the settings
        settings.activate(selected);
    }//GEN-LAST:event_inButtonActionPerformed

    private void outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outButtonActionPerformed
        OutputCategory selected = inCatList.getSelectedValue();

        // Update the UI
        outListModel.addElement(selected);
        inListModel.removeElement(selected);

        outCatList.setSelectedValue(selected, true);

        // Update the settings
        settings.deactivate(selected);
    }//GEN-LAST:event_outButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int selected = inCatList.getSelectedIndex();

        if (selected > 0) {
            // Update the UI
            OutputCategory up = inListModel.set(selected - 1, selectedCategory);
            inListModel.set(selected, up);
            inCatList.setSelectedValue(selectedCategory, true);

            // Update the settings
            settings.getActiveCategories().set(selected - 1, selectedCategory);
            settings.getActiveCategories().set(selected, up);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int selected = inCatList.getSelectedIndex();

        if (selected < inListModel.getSize() - 1) {
            // Update the UI
            OutputCategory down = inListModel.set(selected + 1, selectedCategory);
            inListModel.set(selected, down);
            inCatList.setSelectedValue(selectedCategory, true);

            // Update the settings
            settings.getActiveCategories().set(selected + 1, selectedCategory);
            settings.getActiveCategories().set(selected, down);
        }
    }//GEN-LAST:event_downButtonActionPerformed

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

                setSelectedCategory(outCatList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_outCatListValueChanged

    private void newCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCategoryButtonActionPerformed
        // Find a unique name
        int n = 0;
        
        for (OutputCategory c : settings.getAllCategories()) {
            if (c.getShortName().equals("New")) {
                n = 2;
            } else if (c.getShortName().startsWith("New ")) {
                try {
                    Integer i = Integer.parseInt(c.getShortName().substring(4));
                    n = Math.max(n, i + 1);
                } catch (NumberFormatException e) {
                    // The name doesn't collide, we're fine
                    System.out.println("No collision with name: \"" + c.getShortName() + "\"");
                }
            }
        }
        
        String name = (n > 0 ? "New " + n : "New");
        
        // Create the new category
        OutputCategory newCategory = new OutputCategory(name, name, new TypeCondition(false, "*"));
        
        settings.addCategory(newCategory);
        outListModel.addElement(newCategory);
        outCatList.setSelectedValue(newCategory, true);
    }//GEN-LAST:event_newCategoryButtonActionPerformed

    private void deleteCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryButtonActionPerformed
        OutputCategory remove = selectedCategory;
        
        // Remove the category from the GUI
        setSelectedCategory(null);
        inListModel.removeElement(remove);
        outListModel.removeElement(remove);
        
        // Remove it from the settings
        settings.removeCategory(remove); // (also deactivates it if necessary)
    }//GEN-LAST:event_deleteCategoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator catButtonSeparator;
    private javax.swing.JPanel catPanel;
    private javax.swing.JLabel catSelectionHeader;
    private javax.swing.JSeparator catSeparator;
    private javax.swing.JButton deleteCategoryButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton editFiltersButton;
    private javax.swing.JLabel filtersHeader;
    private javax.swing.JSeparator filtersSeparator;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JButton inButton;
    private javax.swing.JList<OutputCategory> inCatList;
    private javax.swing.JScrollPane inCatScrollPane;
    private javax.swing.JLabel nameHeader;
    private javax.swing.JSeparator nameSeparator;
    private javax.swing.JButton newCategoryButton;
    private javax.swing.JLabel noteHeader;
    private javax.swing.JSeparator noteSeparator;
    private javax.swing.JTextField noteTextField;
    private javax.swing.JButton outButton;
    private javax.swing.JList<OutputCategory> outCatList;
    private javax.swing.JScrollPane outCatScrollPane;
    private javax.swing.JLabel shortNameLabel;
    private javax.swing.JTextField shortNameTextField;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
