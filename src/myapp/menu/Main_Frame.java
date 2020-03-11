/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.menu;

import approve_employee.Approve_Employee;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
import myapp.check_in.Check_In;

/**
 *
 * @author Mohammed Al 3mawy
 */
public class Main_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Main_Frame
     */
    public Main_Frame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        approve_icon = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        check_out = new javax.swing.JButton();
        new_btn = new javax.swing.JButton();
        edt_btn = new javax.swing.JButton();
        sho_btn = new javax.swing.JButton();
        can_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        close_lbl = new javax.swing.JLabel();
        appr_btn = new javax.swing.JButton();
        notice = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(40, 120, 200), null));

        approve_icon.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        approve_icon.setForeground(new java.awt.Color(40, 120, 200));
        approve_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/icons8-verified-account-48.png"))); // NOI18N
        approve_icon.setText("Hi,");

        user_name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        user_name.setForeground(new java.awt.Color(40, 120, 200));
        user_name.setText("User");

        check_out.setBackground(new java.awt.Color(255, 255, 255));
        check_out.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        check_out.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/icons8-business-report-32.png"))); // NOI18N
        check_out.setText("Check out");
        check_out.setBorderPainted(false);
        check_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                check_outMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                check_outMouseExited(evt);
            }
        });

        new_btn.setBackground(new java.awt.Color(255, 255, 255));
        new_btn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        new_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/Data-Add-Column-icon.png"))); // NOI18N
        new_btn.setText("Check in");
        new_btn.setBorderPainted(false);
        new_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                new_btnMouseExited(evt);
            }
        });
        new_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_btnActionPerformed(evt);
            }
        });

        edt_btn.setBackground(new java.awt.Color(255, 255, 255));
        edt_btn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        edt_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/Pencil-icon.png"))); // NOI18N
        edt_btn.setText("   Edit");
        edt_btn.setBorderPainted(false);
        edt_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edt_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edt_btnMouseExited(evt);
            }
        });

        sho_btn.setBackground(new java.awt.Color(255, 255, 255));
        sho_btn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        sho_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/Programming-Show-Property-icon.png"))); // NOI18N
        sho_btn.setText(" Show");
        sho_btn.setBorderPainted(false);
        sho_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sho_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sho_btnMouseExited(evt);
            }
        });

        can_btn.setBackground(new java.awt.Color(255, 255, 255));
        can_btn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        can_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/Editing-Delete-icon.png"))); // NOI18N
        can_btn.setText(" Delete");
        can_btn.setBorderPainted(false);
        can_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                can_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                can_btnMouseExited(evt);
            }
        });
        can_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                can_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reservation Main Menu");

        jPanel5.setBackground(new java.awt.Color(40, 120, 200));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        close_lbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        close_lbl.setForeground(new java.awt.Color(255, 255, 255));
        close_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_lbl.setText("X");
        close_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_lblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(close_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(close_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        appr_btn.setBackground(new java.awt.Color(255, 255, 255));
        appr_btn.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        appr_btn.setForeground(new java.awt.Color(255, 255, 255));
        appr_btn.setBorderPainted(false);
        appr_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appr_btnActionPerformed(evt);
            }
        });

        notice.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        notice.setForeground(new java.awt.Color(153, 153, 153));
        notice.setText("Notice: non-approval employee can't make any proccess ask admin to approve you");

        jSeparator1.setForeground(new java.awt.Color(40, 120, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(sho_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(edt_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(new_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(appr_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(can_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_out))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(approve_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(148, 148, 148))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(notice)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(approve_icon)
                            .addComponent(user_name)
                            .addComponent(notice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(new_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(check_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(appr_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sho_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(can_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(163, 163, 163))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void close_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseClicked
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_close_lblMouseClicked

    private void can_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_can_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_can_btnActionPerformed

    private void can_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_can_btnMouseExited
        // TODO add your handling code here:
        can_btn.setBackground(Color.white);
    }//GEN-LAST:event_can_btnMouseExited

    private void can_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_can_btnMouseEntered
        // TODO add your handling code here:
        can_btn.setBackground(new Color(40, 120, 200));
    }//GEN-LAST:event_can_btnMouseEntered

    private void sho_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sho_btnMouseExited
        // TODO add your handling code here:
        sho_btn.setBackground(Color.white);
    }//GEN-LAST:event_sho_btnMouseExited

    private void sho_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sho_btnMouseEntered
        // TODO add your handling code here:
        sho_btn.setBackground(new Color(40, 120, 200));
    }//GEN-LAST:event_sho_btnMouseEntered

    private void edt_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edt_btnMouseExited
        // TODO add your handling code here:
        edt_btn.setBackground(Color.white);
    }//GEN-LAST:event_edt_btnMouseExited

    private void edt_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edt_btnMouseEntered
        // TODO add your handling code here:
        edt_btn.setBackground(new Color(40, 120, 200));
    }//GEN-LAST:event_edt_btnMouseEntered

    private void new_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_btnActionPerformed
        // TODO add your handling code here:
        new Check_In().setVisible(true);
    }//GEN-LAST:event_new_btnActionPerformed

    private void new_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_btnMouseExited
        // TODO add your handling code here:
        new_btn.setBackground(Color.white);
    }//GEN-LAST:event_new_btnMouseExited

    private void new_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_btnMouseEntered
        // TODO add your handling code here:
        new_btn.setBackground(new Color(40, 120, 200));
    }//GEN-LAST:event_new_btnMouseEntered

    private void check_outMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_outMouseExited
        // TODO add your handling code here:
        check_out.setBackground(Color.white);
    }//GEN-LAST:event_check_outMouseExited

    private void check_outMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_outMouseEntered
        // TODO add your handling code here:
        check_out.setBackground(new Color(40, 120, 200));
    }//GEN-LAST:event_check_outMouseEntered

    private void appr_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appr_btnActionPerformed
        // TODO add your handling code here:
        new Approve_Employee().setVisible(true);
    }//GEN-LAST:event_appr_btnActionPerformed

    public void admin(String name){
    approve_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/icons8-verified-account-48.png")));
    user_name.setText(name);
    notice.setText("");
    appr_btn.setBackground(new java.awt.Color(40, 120, 200));
        appr_btn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        appr_btn.setForeground(Color.black);
        appr_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/verified-account-32.png"))); // NOI18N
        appr_btn.setText("Verify");
        appr_btn.setBorderPainted(false);
        appr_btn.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                rep_btnMouseEntered(evt);
//            }
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                rep_btnMouseExited(evt);
//            }
        });
    }
    
    public void approved_emp(String name){
    approve_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/icons8-verified-account-48.png")));
    user_name.setText(name);
    notice.setText("");
    }
    
    public void not_approved_emp(String name){
     jPanel1.setBorder(BorderFactory.createEtchedBorder(Color.red, null));
     jPanel5.setBackground(Color.red);
     jSeparator1.setBackground(Color.red);
     jSeparator1.setForeground(Color.red);
    approve_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/red-verified-account-48.png")));
    approve_icon.setForeground(Color.red);
    user_name.setText(name);
    user_name.setForeground(Color.red);
    edt_btn.setEnabled(false);
    new_btn.setEnabled(false);
    check_out.setEnabled(false);
    sho_btn.setEnabled(false);
    appr_btn.setEnabled(false);
    can_btn.setEnabled(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appr_btn;
    private javax.swing.JLabel approve_icon;
    private javax.swing.JButton can_btn;
    private javax.swing.JButton check_out;
    private javax.swing.JLabel close_lbl;
    private javax.swing.JButton edt_btn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton new_btn;
    private javax.swing.JLabel notice;
    private javax.swing.JButton sho_btn;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
