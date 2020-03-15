/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.check_in;

import myapp.datepicker.DatePicker;
import java.awt.Color;
import myapp.MyApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import javax.swing.JFrame;
import myapp.Login.Login_Frame;
import myapp.customdialog.Dialog;
import myapp.main_frame.Main_Frame;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mohammed Al 3mawy
 */
public class Check_In extends javax.swing.JFrame {
    String selected_hotel;
    static String from_date;
    static String to_date;
    int hotel_id;
    int agent_id;
    int guest_id;
    /**
     * Creates new form Check_In
     */
    public Check_In() {
        initComponents();
        get_hotels();
    }
    
    
    public void make_booking() throws Exception {

        Connection conn = null;
        PreparedStatement make_booking;
        try {
            insert_geust();
            get_hotel_id();
            get_guest_id();
            get_agent_id();
            
            String make_booking_query = "INSERT INTO Booking_Transaction(`hotel`, `guest`,`agent`,`bookedroom`, `from`,`to`,`status`) values(?,?,?,?,?,?,?)";
            make_booking = conn.prepareStatement(make_booking_query);
            make_booking.setInt(1, hotel_id);
            make_booking.setInt(2, guest_id);
            make_booking.setInt(3, agent_id);
            make_booking.setInt(4, /*?????*/agent_id);
            make_booking.setString(5, from_date);
            make_booking.setString(6, to_date);
            make_booking.setInt(7, 1);
            
        } catch(Exception e){
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        
    }
    
    public void test(){
            get_hotel_id();
            get_guest_id();
            get_agent_id();
            
            System.err.println(hotel_id+"  "+guest_id+"  "+ agent_id);
    
    }
    
    public void insert_geust(){
        Connection conn = null;
        PreparedStatement new_guest_query = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String insert_guest = "INSERT INTO Guests(name,address,phone) values(?,?,?)";
            
            new_guest_query = conn.prepareStatement(insert_guest);
            new_guest_query.setString(1, gu_name.getText());
            new_guest_query.setString(2, gu_address.getText());
            new_guest_query.setString(3, gu_phone.getText());
            new_guest_query.executeUpdate();
            
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public void get_guest_id(){
        Connection conn = null;
       PreparedStatement get_guest_id = null;
        ResultSet guest_id = null;
        try {
            String get_geust_id_query = "select agent_id from Agents where name=?";
            get_guest_id = conn.prepareStatement(get_geust_id_query);
            get_guest_id.setString(1,gu_name.getText());
            guest_id = get_guest_id.executeQuery();
            System.err.println(this.guest_id);
            this.guest_id = guest_id.getInt("guest_id");
            
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public void get_agent_id(){
        Connection conn = null;
       PreparedStatement get_agent_id_query = null;
        ResultSet agent_id = null;
        try {
            String get_agent_id = "select agent_id from Agents where name=?";
            get_agent_id_query = conn.prepareStatement(get_agent_id);
            System.err.println(Login_Frame.agent_name);
            get_agent_id_query.setString(1,Login_Frame.agent_name);
            agent_id = get_agent_id_query.executeQuery();
            
            this.agent_id = agent_id.getInt("agent_id");
            System.err.println(this.agent_id);
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
            
    public void get_hotel_id(){
        Connection conn = null;
        PreparedStatement hotel_id_query = null;
        ResultSet hotel_id = null;
        try {
            String get_hotel_id = "select hotel_id from Hotel where name=?";
            hotel_id_query = conn.prepareStatement(get_hotel_id);
            hotel_id_query.setString(1, selected_hotel);
            hotel_id = hotel_id_query.executeQuery();
            
            this.hotel_id = hotel_id.getInt("hotel_id");
            System.err.println(this.hotel_id);
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
         public void get_hotels() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String select = "select * from hotel";

            preparedStatement = conn.prepareStatement(select);

            rs = preparedStatement.executeQuery();

           
            while (rs.next()) {
                String name = rs.getString("name");
                hotel_combo.addItem(name);
            }
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
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gu_name = new javax.swing.JTextField();
        gu_address = new javax.swing.JTextField();
        hotel_combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gu_phone = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pick_from = new javax.swing.JButton();
        pick_to = new javax.swing.JButton();
        to = new javax.swing.JLabel();
        from = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(40, 120, 200), null));

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

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Check IN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        gu_name.setBorder(javax.swing.BorderFactory.createTitledBorder("Guest Name"));

        gu_address.setBorder(javax.swing.BorderFactory.createTitledBorder("Guest Address"));
        gu_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gu_addressActionPerformed(evt);
            }
        });

        hotel_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hotel" }));
        hotel_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotel_comboActionPerformed(evt);
            }
        });

        jLabel1.setText("Guest Info");

        jLabel6.setText("Hotel And Rooms info");

        gu_phone.setBorder(javax.swing.BorderFactory.createTitledBorder("Guest Phone"));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Reservation info");

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder("No. of persons"));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Smoke Room");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("No. of Rooms"));

        jButton1.setBackground(new java.awt.Color(40, 120, 200));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book Now");
        jButton1.setBorderPainted(false);

        pick_from.setBackground(new java.awt.Color(40, 120, 200));
        pick_from.setForeground(new java.awt.Color(255, 255, 255));
        pick_from.setText("Pick");
        pick_from.setBorderPainted(false);
        pick_from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pick_fromActionPerformed(evt);
            }
        });

        pick_to.setBackground(new java.awt.Color(40, 120, 200));
        pick_to.setForeground(new java.awt.Color(255, 255, 255));
        pick_to.setText("Pick");
        pick_to.setBorderPainted(false);
        pick_to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pick_toActionPerformed(evt);
            }
        });

        to.setText("To  Date:");

        from.setText("From Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(gu_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gu_address, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gu_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pick_from)
                            .addComponent(pick_to)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(gu_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gu_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gu_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pick_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pick_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void hotel_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotel_comboActionPerformed
        // TODO add your handling code here:
         selected_hotel = hotel_combo.getSelectedItem().toString();
    }//GEN-LAST:event_hotel_comboActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void gu_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gu_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gu_addressActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void pick_fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pick_fromActionPerformed
        // TODO add your handling code here:
        
       
        test();
        String date = new DatePicker(this).setPickedDate();
        from_date = date;
        from.setText("From Date: "+from_date);
    }//GEN-LAST:event_pick_fromActionPerformed

    private void pick_toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pick_toActionPerformed
        // TODO add your handling code here:
         to_date = new DatePicker(this).setPickedDate();
         to.setText("To Date: "+to_date);
    }//GEN-LAST:event_pick_toActionPerformed

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
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Check_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Check_In().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel from;
    private javax.swing.JTextField gu_address;
    private javax.swing.JTextField gu_name;
    private javax.swing.JTextField gu_phone;
    private javax.swing.JComboBox<String> hotel_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton pick_from;
    private javax.swing.JButton pick_to;
    private javax.swing.JLabel to;
    // End of variables declaration//GEN-END:variables
}
