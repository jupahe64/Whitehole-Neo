/*
 * Copyright (C) 2022 Whitehole Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package whitehole;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import whitehole.io.FilesystemBase;

public class SettingsForm extends javax.swing.JDialog {
    public SettingsForm(JFrame parent) {
        super(parent, true);
        
        initComponents();
        
        ((KeybindButton)btnPosition).setKeyBind(Settings.getKeyPosition());
        ((KeybindButton)btnRotation).setKeyBind(Settings.getKeyRotation());
        ((KeybindButton)btnScale).setKeyBind(Settings.getKeyScale());
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content
     * of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlSettings = new javax.swing.JPanel();
        lblAppearance = new javax.swing.JLabel();
        lblControls = new javax.swing.JLabel();
        chkUseDarkMode = new javax.swing.JCheckBox();
        chkDebugFakeColor = new javax.swing.JCheckBox();
        chkDebugFastDrag = new javax.swing.JCheckBox();
        chkUseReverseRot = new javax.swing.JCheckBox();
        chkUseWASD = new javax.swing.JCheckBox();
        lblPosition = new javax.swing.JLabel();
        lblRotation = new javax.swing.JLabel();
        lblScale = new javax.swing.JLabel();
        btnPosition = new KeybindButton();
        btnRotation = new KeybindButton();
        btnScale = new KeybindButton();
        jLabel1 = new javax.swing.JLabel();
        txtBaseGame = new javax.swing.JTextField();
        btnBrowseBaseGamePath = new javax.swing.JButton();
        chkUseBetterQuality = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(String.format("%s -- Settings", Whitehole.NAME));
        setIconImage(Whitehole.ICON);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlSettings.setLayout(new java.awt.GridBagLayout());

        lblAppearance.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblAppearance.setText("Appearance");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(lblAppearance, gridBagConstraints);

        lblControls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblControls.setText("Controls");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(lblControls, gridBagConstraints);

        chkUseDarkMode.setSelected(Settings.getUseDarkMode());
        chkUseDarkMode.setText("Use Dark Mode");
        chkUseDarkMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkUseDarkModeItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkUseDarkMode, gridBagConstraints);

        chkDebugFakeColor.setSelected(Settings.getDebugFakeColor());
        chkDebugFakeColor.setText("[Debug] Render picking colors");
        chkDebugFakeColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkDebugFakeColorItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkDebugFakeColor, gridBagConstraints);

        chkDebugFastDrag.setSelected(Settings.getDebugFastDrag());
        chkDebugFastDrag.setText("[Debug] Render wireframes when dragging");
        chkDebugFastDrag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkDebugFastDragItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkDebugFastDrag, gridBagConstraints);

        chkUseReverseRot.setSelected(Settings.getUseReverseRot());
        chkUseReverseRot.setText("Invert camera motion");
        chkUseReverseRot.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkUseReverseRotItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkUseReverseRot, gridBagConstraints);

        chkUseWASD.setSelected(Settings.getUseWASD());
        chkUseWASD.setText("Use WASD over arrow keys");
        chkUseWASD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkUseWASDItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkUseWASD, gridBagConstraints);

        lblPosition.setText("Position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(lblPosition, gridBagConstraints);

        lblRotation.setText("Rotation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(lblRotation, gridBagConstraints);

        lblScale.setText("Scale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(lblScale, gridBagConstraints);

        btnPosition.setText("[not set]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(btnPosition, gridBagConstraints);

        btnRotation.setText("[not set]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(btnRotation, gridBagConstraints);

        btnScale.setText("[not set]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(btnScale, gridBagConstraints);

        jLabel1.setText("Base Game Path (For objects only)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlSettings.add(jLabel1, gridBagConstraints);

        txtBaseGame.setText(Settings.getBaseGameDir());
        txtBaseGame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBaseGameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlSettings.add(txtBaseGame, gridBagConstraints);

        btnBrowseBaseGamePath.setText("Browse...");
        btnBrowseBaseGamePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseBaseGamePathActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlSettings.add(btnBrowseBaseGamePath, gridBagConstraints);

        chkUseBetterQuality.setSelected(Settings.getUseBetterQuality());
        chkUseBetterQuality.setText("Better Quality (Requires closing whitehole)");
        chkUseBetterQuality.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkUseBetterQualityItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnlSettings.add(chkUseBetterQuality, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkDebugFakeColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkDebugFakeColorItemStateChanged
        Settings.setDebugFakeColor(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_chkDebugFakeColorItemStateChanged

    private void chkDebugFastDragItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkDebugFastDragItemStateChanged
        Settings.setDebugFastDrag(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_chkDebugFastDragItemStateChanged

    private void chkUseReverseRotItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkUseReverseRotItemStateChanged
        Settings.setUseReverseRot(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_chkUseReverseRotItemStateChanged

    private void chkUseWASDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkUseWASDItemStateChanged
        Settings.setUseWASD(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_chkUseWASDItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Settings.setKeyPosition(((KeybindButton)btnPosition).keybind);
        Settings.setKeyRotation(((KeybindButton)btnRotation).keybind);
        Settings.setKeyScale(((KeybindButton)btnScale).keybind);
    }//GEN-LAST:event_formWindowClosing

    private void chkUseDarkModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkUseDarkModeItemStateChanged
        Settings.setUseDarkMode(evt.getStateChange() == ItemEvent.SELECTED);
        Whitehole.requestUpdateLAF();
    }//GEN-LAST:event_chkUseDarkModeItemStateChanged

    private void txtBaseGameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBaseGameKeyReleased
        String pth = txtBaseGame.getText();
        setBaseGamePath(pth);
    }//GEN-LAST:event_txtBaseGameKeyReleased

    private void chkUseBetterQualityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkUseBetterQualityItemStateChanged
        Settings.setUseBetterQuality(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_chkUseBetterQualityItemStateChanged

    private void btnBrowseBaseGamePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseBaseGamePathActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open a base SMG1/2 Directory");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        String lastGameDir = Settings.getBaseGameDir();
        if (lastGameDir != null || lastGameDir.length() > 0) {
            fc.setSelectedFile(new File(lastGameDir));
        }
        
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String pth = fc.getSelectedFile().getPath();
            txtBaseGame.setText(pth);
            setBaseGamePath(pth);
        }
    }//GEN-LAST:event_btnBrowseBaseGamePathActionPerformed
    
    private void setBaseGamePath(String pth)
    {     
        if (pth.equals(""))
        {
            //Empty the path
            Settings.setBaseGameDir("");
            System.out.println("Base path unset.");
            return;
        }
        
        File dir = new File(pth);
        if (dir.exists() && dir.isDirectory())
        {
            if (pth.endsWith("/") || pth.endsWith("\\"))
                pth = pth.substring(0, pth.length()-1);
            Settings.setBaseGameDir(pth);
            System.out.println("valid Base path has been set!");
        }
        else
            System.out.println("invalid path inserted!");
    }
    
    private static class KeybindButton extends JButton {
        boolean binding = false;
        int keybind = -1;
        
        public KeybindButton() {
            super();

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    if (!binding) {
                        return;
                    }

                    setKeyBind(evt.getKeyCode());
                }
            });

            addActionListener((ActionEvent e) -> {
                if(binding) {
                    keybind = -1;
                }

                binding = !binding;

                if(keybind == -1) {
                    setText("[not set]");
                }

                if(binding = true) {
                    setText(getText() + "...");
                }
            });
        }
        
        public void setKeyBind(int key) {
            keybind = key;
            setText(KeyEvent.getKeyText(keybind));
            binding = false;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseBaseGamePath;
    private javax.swing.JButton btnPosition;
    private javax.swing.JButton btnRotation;
    private javax.swing.JButton btnScale;
    private javax.swing.JCheckBox chkDebugFakeColor;
    private javax.swing.JCheckBox chkDebugFastDrag;
    private javax.swing.JCheckBox chkUseBetterQuality;
    private javax.swing.JCheckBox chkUseDarkMode;
    private javax.swing.JCheckBox chkUseReverseRot;
    private javax.swing.JCheckBox chkUseWASD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAppearance;
    private javax.swing.JLabel lblControls;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRotation;
    private javax.swing.JLabel lblScale;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JTextField txtBaseGame;
    // End of variables declaration//GEN-END:variables
}
