/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Login;

import java.awt.Color;
import java.awt.Panel;
import myapp.encryption.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import myapp.customdialog.Dialog;
import myapp.menu.Main_Frame;
import myapp.MyApp;
import myapp.forget_password.forget_password;
import myapp.signup.SignUp_Form;
//hotel reservation system -> real time transaction processing system
// login signup forgetpassword interface for help and question
// new show edit cancel reservation

/**
 *
 * @author Mohammed Al 3mawy
 */
public class Login_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Signin_form
     */
    public Login_Frame() {
        initComponents();
    }


//    private boolean matchedPassword(char[] password, String hashedPassword) {
//        String originalPassword = new String(password);
//        boolean matched = BCrypt.checkpw(originalPassword, hashedPassword);
//        return matched;
//
//    }

    public void login() throws Exception {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String sql = "select * from agents WHERE `agents`.`name`=? and `agents`.`password`=?";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName_Txt.getText());
             preparedStatement.setString(2, password_Txt.getText());
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
                String Password = rs.getString("password");
                System.err.println(Password+password_Txt.getText());
                System.err.println(rs.getString(5)+1);
                if (password_Txt.getText().equals(Password) && rs.getString(5).equals("Admin")) {
                    Main_Frame gui = new Main_Frame();
                    gui.admin(rs.getString("name"));
                    gui.setLocationRelativeTo(null);
                    gui.setVisible(true);
                    this.dispose();
                } else if(password_Txt.getText().equals(Password) && rs.getString(5).equals("Non_Approval")){
                Main_Frame gui = new Main_Frame();
                    gui.not_approved_emp(rs.getString("name"));
                    gui.setLocationRelativeTo(null);
                    gui.setVisible(true);
                    this.dispose();
            } else if(password_Txt.getText().equals(Password) && rs.getString(5).equals("Approved")){
                Main_Frame gui = new Main_Frame();
                    gui.approved_emp(rs.getString("name"));
                    gui.setLocationRelativeTo(null);
                    gui.setVisible(true);
                    this.dispose();
            }else {
                new Dialog(this, rootPaneCheckingEnabled, "Invalid Password").setVisible(true);

                }
            } else {
                new Dialog(this, rootPaneCheckingEnabled, "Invalid username").setVisible(true);
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (rs != null) {
                rs.close();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        userName_Txt = new javax.swing.JTextField();
        password_Txt = new javax.swing.JPasswordField();
        login_Btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Signup_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        close_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        forget_password = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSep2 = new javax.swing.JSeparator();
        jSep1 = new javax.swing.JSeparator();

        jScrollPane1.setViewportView(jTextPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setUndecorated(true);
        setOpacity(0.0F);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(40, 120, 200), null));
        jPanel1.setToolTipText("");

        userName_Txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userName_Txt.setBorder(null);
        userName_Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userName_TxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userName_TxtMouseExited(evt);
            }
        });

        password_Txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password_Txt.setBorder(null);
        password_Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                password_TxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                password_TxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                password_TxtMouseExited(evt);
            }
        });

        login_Btn.setBackground(new java.awt.Color(40, 120, 200));
        login_Btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login_Btn.setForeground(new java.awt.Color(255, 255, 255));
        login_Btn.setText("Login");
        login_Btn.setToolTipText("Login");
        login_Btn.setBorder(null);
        login_Btn.setBorderPainted(false);
        login_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_BtnActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(90, 91, 97));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/User-icon.png"))); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setForeground(new java.awt.Color(90, 91, 97));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myapp/assets/Security-Password-2-icon.png"))); // NOI18N
        jLabel3.setText("Password");

        Signup_label.setForeground(new java.awt.Color(153, 153, 153));
        Signup_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Signup_label.setText("you don’t have account? Signup now");
        Signup_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signup_labelMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(40, 120, 200));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        close_label.setBackground(new java.awt.Color(40, 120, 200));
        close_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        close_label.setForeground(new java.awt.Color(255, 255, 255));
        close_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_label.setText("X");
        close_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_labelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(close_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
        );

        forget_password.setForeground(new java.awt.Color(153, 153, 153));
        forget_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forget_password.setText("I forget my password!");
        forget_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forget_passwordMouseClicked(evt);
            }
        });

        jSep2.setBackground(new java.awt.Color(204, 204, 204));
        jSep2.setForeground(new java.awt.Color(204, 204, 204));
        jSep2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSep2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSep2MouseExited(evt);
            }
        });

        jSep1.setBackground(new java.awt.Color(204, 204, 204));
        jSep1.setForeground(new java.awt.Color(204, 204, 204));
        jSep1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSep1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSep1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addContainerGap())))
            .addComponent(Signup_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(forget_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSep1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userName_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSep2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(login_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSep1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSep2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(forget_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Signup_label)
                .addGap(19, 19, 19))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0; i <= 1; i += 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch(Exception ex){
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        for (double i = 1; i <= 0; i -= 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch(Exception ex){
                new Dialog(this, rootPaneCheckingEnabled,ex.toString());
            }
        }
    }//GEN-LAST:event_formWindowClosed

    private void forget_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forget_passwordMouseClicked
        // TODO add your handling code here:
               new forget_password().setVisible(true);
    }//GEN-LAST:event_forget_passwordMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_close_labelMouseClicked

    private void Signup_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signup_labelMouseClicked
        // TODO add your handling code here:
        SignUp_Form signup = new SignUp_Form();
        signup.setLocationRelativeTo(null);
        signup.setVisible(true);
    }//GEN-LAST:event_Signup_labelMouseClicked

    private void login_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_BtnActionPerformed
        // TODO add your handling code here:
        try {
            login();
        } catch (Exception ex) {
            Dialog d = new Dialog(this, rootPaneCheckingEnabled, ex.toString());
            d.setVisible(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_login_BtnActionPerformed

    private void jSep1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSep1MouseEntered
        // TODO add your handling code here:
        jSep1.setBackground(new Color(40,120,200));
        jSep1.setForeground(new Color(40,120,200));
    }//GEN-LAST:event_jSep1MouseEntered

    private void jSep1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSep1MouseExited
        // TODO add your handling code here:
        jSep1.setBackground(new Color(204,204,204));
        jSep1.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_jSep1MouseExited

    private void jSep2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSep2MouseEntered
        // TODO add your handling code here:
         jSep2.setBackground(new Color(40,120,200));
        jSep2.setForeground(new Color(40,120,200));
    }//GEN-LAST:event_jSep2MouseEntered

    private void jSep2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSep2MouseExited
        // TODO add your handling code here:
          jSep2.setBackground(new Color(204,204,204));
        jSep2.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_jSep2MouseExited

    private void userName_TxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userName_TxtMouseEntered
        // TODO add your handling code here:
        jSep1.setBackground(new Color(40,120,200));
        jSep1.setForeground(new Color(40,120,200));
    }//GEN-LAST:event_userName_TxtMouseEntered

    private void userName_TxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userName_TxtMouseExited
        // TODO add your handling code here:
        jSep1.setBackground(new Color(204,204,204));
        jSep1.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_userName_TxtMouseExited

    private void password_TxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_TxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_password_TxtMouseClicked

    private void password_TxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_TxtMouseEntered
        // TODO add your handling code here:
         jSep2.setBackground(new Color(40,120,200));
        jSep2.setForeground(new Color(40,120,200));
    }//GEN-LAST:event_password_TxtMouseEntered

    private void password_TxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_TxtMouseExited
        // TODO add your handling code here:
        jSep2.setBackground(new Color(204,204,204));
        jSep2.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_password_TxtMouseExited

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
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Signup_label;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel forget_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSep1;
    private javax.swing.JSeparator jSep2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton login_Btn;
    private javax.swing.JPasswordField password_Txt;
    private javax.swing.JTextField userName_Txt;
    // End of variables declaration//GEN-END:variables
}
