/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.approve_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myapp.MyApp;
import myapp.customdialog.Dialog;

/**
 *
 * @author Mohammed Al 3mawy
 */
public class Approve_Employee extends javax.swing.JFrame {

    /**
     * Creates new form Approve_Employee
     */
    String appr_selected;
    String disapp_selected;

    public Approve_Employee() {
        initComponents();
        init_appr_view();
        init_disap_view();
    }

    public void init_appr_view() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String sql = "select name from agents WHERE type='Non_Approval'";

            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                appr_combo.addItem(name);
            }

        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
       
    }
    
    
    public void init_disap_view(){
         Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
    try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String sql = "select name from agents WHERE type='Aproval'";

            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                disap_combo.addItem(name);
            }

        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }

    public void approve(String selected) {
        Connection conn = null;
        PreparedStatement ins_appr = null;
        PreparedStatement sel_name = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String update_query = "UPDATE `hotel management system`.`agents` SET `type` = 3 WHERE (`name` = ?);";
            String sel = "select name from agents WHERE type='Non_Approval'";

            
            sel_name = conn.prepareStatement(sel);
            rs = sel_name.executeQuery();
         
            while (rs.next()) {                
               
                if(rs.getString("name").equals(selected)){
                    ins_appr = conn.prepareStatement(update_query);
                    ins_appr.setString(1,rs.getString("name"));
                    ins_appr.executeUpdate();
            
                }
            }
            
            new Dialog(this, rootPaneCheckingEnabled, "Done!").setVisible(true);
            
            disap_combo.addItem(appr_selected);
            appr_combo.removeItem(appr_selected);
            appr_combo.updateUI();
            
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }

    }
    
    
    public void disapprove(String selected) {
        Connection conn = null;
        PreparedStatement ins_appr = null;
        PreparedStatement sel_name = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String update_query = "UPDATE `hotel management system`.`agents` SET `type` = 2 WHERE (`name` = ?);";
            String sel = "select name from agents WHERE type='Aproval'";

            
            sel_name = conn.prepareStatement(sel);
            rs = sel_name.executeQuery();
         
            while (rs.next()) {                
               
                if(rs.getString("name").equals(selected)){
                    ins_appr = conn.prepareStatement(update_query);
                    ins_appr.setString(1,rs.getString("name"));
                    ins_appr.executeUpdate();
                }
            }
            
            appr_combo.addItem(disapp_selected);
            disap_combo.removeItem(disapp_selected);
            disap_combo.updateUI();
            
            new Dialog(this, rootPaneCheckingEnabled, "Done!").setVisible(true);
           
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        appr_combo = new javax.swing.JComboBox<>();
        disap_combo = new javax.swing.JComboBox<>();
        Approve_btn = new javax.swing.JButton();
        Disapprove_btn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(40, 120, 200), null));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Approve:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Disapprove:");

        appr_combo.setBorder(null);
        appr_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appr_comboActionPerformed(evt);
            }
        });

        disap_combo.setSelectedIndex(-1);
        disap_combo.setBorder(null);
        disap_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disap_comboActionPerformed(evt);
            }
        });

        Approve_btn.setBackground(new java.awt.Color(40, 120, 200));
        Approve_btn.setForeground(new java.awt.Color(255, 255, 255));
        Approve_btn.setText("Approve");
        Approve_btn.setBorderPainted(false);
        Approve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Approve_btnActionPerformed(evt);
            }
        });

        Disapprove_btn.setBackground(new java.awt.Color(40, 120, 200));
        Disapprove_btn.setForeground(new java.awt.Color(255, 255, 255));
        Disapprove_btn.setText("Disapprove");
        Disapprove_btn.setBorderPainted(false);
        Disapprove_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disapprove_btnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(40, 120, 200));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Approval menu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(63, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Disapprove_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(appr_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(disap_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Approve_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appr_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(Approve_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(disap_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Disapprove_btn)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Approve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Approve_btnActionPerformed
        // TODO add your handling code here: 
        System.err.println(appr_selected);
        approve(appr_selected);
    }//GEN-LAST:event_Approve_btnActionPerformed

    private void Disapprove_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disapprove_btnActionPerformed
        // TODO add your handling code here:
        System.err.println(disapp_selected);
        disapprove(disapp_selected);
    }//GEN-LAST:event_Disapprove_btnActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void disap_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disap_comboActionPerformed
        // TODO add your handling code here:
        disapp_selected = disap_combo.getSelectedItem().toString();
    }//GEN-LAST:event_disap_comboActionPerformed

    private void appr_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appr_comboActionPerformed
        // TODO add your handling code here:
        appr_selected = appr_combo.getSelectedItem().toString();
    }//GEN-LAST:event_appr_comboActionPerformed

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
            java.util.logging.Logger.getLogger(Approve_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Approve_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Approve_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Approve_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Approve_Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Approve_btn;
    private javax.swing.JButton Disapprove_btn;
    private javax.swing.JComboBox<String> appr_combo;
    private javax.swing.JComboBox<String> disap_combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
