/*
 * Copyright 2013-2016 Sander Verdonschot <sander.verdonschot at gmail.com>.
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

import publy.data.settings.ConsoleSettings;

/**
 *
 *
 */
public class ConsoleSettingsPanel extends javax.swing.JPanel {

    private final ConsoleSettings settings;
    
    /**
     * Empty constructor, for use in the NetBeans GUI editor.
     */
    public ConsoleSettingsPanel() {
        settings = new ConsoleSettings();
        initComponents();
        applyStyles();
        populateValues();
        updateEnabledStates();
    }

    /**
     * Creates new form FileSettingsPanel
     * @param settings
     */
    public ConsoleSettingsPanel(ConsoleSettings settings) {
        this.settings = settings;
        initComponents();
        applyStyles();
        populateValues();
        updateEnabledStates();
    }

    private void applyStyles() {
        UIStyles.applyHeaderStyle(warnHeader, progressHeader, debugHeader);
    }

    private void populateValues() {
        // Warnings
        warnCheckBox.setSelected(settings.isShowWarnings());
        duplicateIDCheckBox.setSelected(settings.isWarnDuplicateIDs());
        missingReferencesCheckBox.setSelected(settings.isWarnMissingReferences());
        notAuthorCheckBox.setSelected(settings.isWarnNotAuthor());
        noCategoryCheckBox.setSelected(settings.isWarnNoCategoryForItem());
        possibleMistakenAbbreviationCheckBox.setSelected(settings.isWarnPossibleMistakenAbbreviation());
        
        // Progress
        progressCheckBox.setSelected(settings.isShowLogs());
        
        // Debug
        debugCheckBox.setSelected(settings.isShowDebugLog());
        stackTraceCheckBox.setSelected(settings.isShowStackTraces());
    }
    
    private void updateEnabledStates() {
        duplicateIDCheckBox.setEnabled(settings.isShowWarnings());
        missingReferencesCheckBox.setEnabled(settings.isShowWarnings());
        notAuthorCheckBox.setEnabled(settings.isShowWarnings());
        noCategoryCheckBox.setEnabled(settings.isShowWarnings());
        possibleMistakenAbbreviationCheckBox.setEnabled(settings.isShowWarnings());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warnHeader = new javax.swing.JLabel();
        warnSeparator = new javax.swing.JSeparator();
        warnCheckBox = new javax.swing.JCheckBox();
        missingReferencesCheckBox = new javax.swing.JCheckBox();
        progressHeader = new javax.swing.JLabel();
        progressSeparator = new javax.swing.JSeparator();
        notAuthorCheckBox = new javax.swing.JCheckBox();
        progressCheckBox = new javax.swing.JCheckBox();
        debugHeader = new javax.swing.JLabel();
        debugSeparator = new javax.swing.JSeparator();
        stackTraceCheckBox = new javax.swing.JCheckBox();
        noCategoryCheckBox = new javax.swing.JCheckBox();
        debugCheckBox = new javax.swing.JCheckBox();
        duplicateIDCheckBox = new javax.swing.JCheckBox();
        possibleMistakenAbbreviationCheckBox = new javax.swing.JCheckBox();

        warnHeader.setText("Warnings");

        warnCheckBox.setText("Show warnings:");
        warnCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warnCheckBoxActionPerformed(evt);
            }
        });

        missingReferencesCheckBox.setText("When a referenced file or publication does not exist");
        missingReferencesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                missingReferencesCheckBoxActionPerformed(evt);
            }
        });

        progressHeader.setText("Progress");

        notAuthorCheckBox.setText("When a paper was not written by you");
        notAuthorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notAuthorCheckBoxActionPerformed(evt);
            }
        });

        progressCheckBox.setText("Show progress indications");
        progressCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressCheckBoxActionPerformed(evt);
            }
        });

        debugHeader.setText("Debug");

        stackTraceCheckBox.setText("Show exception stack traces");
        stackTraceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stackTraceCheckBoxActionPerformed(evt);
            }
        });

        noCategoryCheckBox.setText("When a publication does not fit any category");
        noCategoryCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noCategoryCheckBoxActionPerformed(evt);
            }
        });

        debugCheckBox.setText("Show debug messages");
        debugCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugCheckBoxActionPerformed(evt);
            }
        });

        duplicateIDCheckBox.setText("When multiple publications have the same identifier");
        duplicateIDCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicateIDCheckBoxActionPerformed(evt);
            }
        });

        possibleMistakenAbbreviationCheckBox.setText("For likely mistakes with abbreviations");
        possibleMistakenAbbreviationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                possibleMistakenAbbreviationCheckBoxActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(missingReferencesCheckBox)
                            .addComponent(notAuthorCheckBox)
                            .addComponent(noCategoryCheckBox)
                            .addComponent(duplicateIDCheckBox)
                            .addComponent(warnCheckBox)
                            .addComponent(possibleMistakenAbbreviationCheckBox))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(warnHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(warnSeparator))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressCheckBox)
                                    .addComponent(debugCheckBox)
                                    .addComponent(stackTraceCheckBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(debugHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(debugSeparator))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progressHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressSeparator)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(warnSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warnHeader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warnCheckBox)
                .addGap(10, 10, 10)
                .addComponent(duplicateIDCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(missingReferencesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notAuthorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noCategoryCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(possibleMistakenAbbreviationCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressHeader)
                    .addComponent(progressSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(debugHeader)
                    .addComponent(debugSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(debugCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stackTraceCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void warnCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warnCheckBoxActionPerformed
        settings.setShowWarnings(warnCheckBox.isSelected());
        updateEnabledStates();
    }//GEN-LAST:event_warnCheckBoxActionPerformed

    private void missingReferencesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_missingReferencesCheckBoxActionPerformed
        settings.setWarnMissingReferences(missingReferencesCheckBox.isSelected());
    }//GEN-LAST:event_missingReferencesCheckBoxActionPerformed

    private void notAuthorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notAuthorCheckBoxActionPerformed
        settings.setWarnNotAuthor(notAuthorCheckBox.isSelected());
    }//GEN-LAST:event_notAuthorCheckBoxActionPerformed

    private void progressCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressCheckBoxActionPerformed
        settings.setShowLogs(progressCheckBox.isSelected());
    }//GEN-LAST:event_progressCheckBoxActionPerformed

    private void stackTraceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stackTraceCheckBoxActionPerformed
        settings.setShowStackTraces(stackTraceCheckBox.isSelected());
    }//GEN-LAST:event_stackTraceCheckBoxActionPerformed

    private void noCategoryCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noCategoryCheckBoxActionPerformed
        settings.setWarnNoCategoryForItem(noCategoryCheckBox.isSelected());
    }//GEN-LAST:event_noCategoryCheckBoxActionPerformed

    private void debugCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugCheckBoxActionPerformed
        settings.setShowDebugLog(debugCheckBox.isSelected());
    }//GEN-LAST:event_debugCheckBoxActionPerformed

    private void duplicateIDCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicateIDCheckBoxActionPerformed
        settings.setWarnDuplicateIDs(duplicateIDCheckBox.isSelected());
    }//GEN-LAST:event_duplicateIDCheckBoxActionPerformed

    private void possibleMistakenAbbreviationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_possibleMistakenAbbreviationCheckBoxActionPerformed
        settings.setWarnPossibleMistakenAbbreviation(possibleMistakenAbbreviationCheckBox.isSelected());
    }//GEN-LAST:event_possibleMistakenAbbreviationCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox debugCheckBox;
    private javax.swing.JLabel debugHeader;
    private javax.swing.JSeparator debugSeparator;
    private javax.swing.JCheckBox duplicateIDCheckBox;
    private javax.swing.JCheckBox missingReferencesCheckBox;
    private javax.swing.JCheckBox noCategoryCheckBox;
    private javax.swing.JCheckBox notAuthorCheckBox;
    private javax.swing.JCheckBox possibleMistakenAbbreviationCheckBox;
    private javax.swing.JCheckBox progressCheckBox;
    private javax.swing.JLabel progressHeader;
    private javax.swing.JSeparator progressSeparator;
    private javax.swing.JCheckBox stackTraceCheckBox;
    private javax.swing.JCheckBox warnCheckBox;
    private javax.swing.JLabel warnHeader;
    private javax.swing.JSeparator warnSeparator;
    // End of variables declaration//GEN-END:variables
}
