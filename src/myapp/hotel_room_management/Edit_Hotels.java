/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.hotel_room_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myapp.MyApp;
import myapp.customdialog.Dialog;
import static myapp.hotel_room_management.Add_Hotel_Rooms.hotel_name;
import static myapp.hotel_room_management.Add_Hotel_Rooms.smoke;

/**
 *
 * @author Mohammed Al 3mawy
 */
public class Edit_Hotels extends javax.swing.JFrame {

    /**
     * Creates new form Edit_Hotel
     */
    String selected;
    public Edit_Hotels() {
        initComponents();
        get_hotels();
    }

    public void get_hotels(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String sql = "select * from hotel";

            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                hotel_combo.addItem(name);
            }

        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public int get_hotel_id(){
        int res = 0;
        Connection conn = null;
        PreparedStatement hotel_id = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_hotel_id = "select hotel_id from Hotel where name=?";
            hotel_id = conn.prepareStatement(get_hotel_id);
            hotel_id.setString(1, selected);
            rs = hotel_id.executeQuery();
            
           while (rs.next()) {                
            res = rs.getInt("hotel_id");    
                System.err.println(rs.getInt("hotel_id"));
            }
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        return res;
    }
    
    public void edit_hotel(String selected){
        Connection conn = null;
        PreparedStatement ins_hotel = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String query = "UPDATE `hotel management system`.`hotel` SET `name` = ?, `address` = ? , `Total_floors#` = ?,`Total_rooms#` = ?, `Total_smoke#` = ?  WHERE (`name` = ?)";
    
            ins_hotel = conn.prepareStatement(query);
            ins_hotel.setString(1, name.getText());
            ins_hotel.setString(2, address.getText());
            ins_hotel.setInt(3, Integer.valueOf(floor_num.getText()));
            ins_hotel.setInt(4, Integer.valueOf(rooms_num.getText()));
            ins_hotel.setInt(5, Integer.valueOf(smoke_num.getText()));
            ins_hotel.setString(6, selected);
            
            ins_hotel.executeUpdate();
            update_rooms();
            new myapp.customdialog.Dialog(this, rootPaneCheckingEnabled, "Hotel Edited!").setVisible(true);
        } catch(Exception e){
        java.awt.Dialog d = new myapp.customdialog.Dialog(this, rootPaneCheckingEnabled, e.toString());
        d.setVisible(true);
        }
        
    }
    
    public void update_rooms(){
        Connection conn = null;
        PreparedStatement del_booked_room = null;
        PreparedStatement del_room = null;
        PreparedStatement ins = null;
        PreparedStatement sel = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String del_query ="delete from booked_rooms where guest_id =1";
            del_booked_room = conn.prepareStatement(del_query);
            del_booked_room.executeUpdate();
            
            String del_query2 ="delete from Rooms where hotel =?";
            del_room = conn.prepareStatement(del_query2);
            del_room.setInt(1, get_hotel_id());
            del_room.executeUpdate();
        
            String query1 = "select * from hotel where name=?";
            sel = conn.prepareStatement(query1);
            System.err.println(selected);
            sel.setString(1, name.getText());
            rs = sel.executeQuery();
            
            while (rs.next()) {
            int floors_num = Integer.valueOf(floor_num.getText());
            int rooms_num = Integer.valueOf(this.rooms_num.getText());
            for (int i = 1; i <= floors_num; i++) {
                for (int j = 1; j <= rooms_num/floors_num; j++) {
                String query2 = "INSERT INTO `hotel management system`.`rooms` "
                        + "(`hotel`, `floor#`, `room#`, `smoke`, `capacity`)"
                        + " VALUES ("+rs.getInt("hotel_id")+","+i+","+j+","+set_smoke(j)+","+set_capacity(j)+")";
                        ins = conn.prepareStatement(query2);
                        ins.executeUpdate();
                }
            }
            }
            new myapp.customdialog.Dialog(this, rootPaneCheckingEnabled, " Hotel Rooms Updated!").setVisible(true);
        } catch(Exception e){
        java.awt.Dialog d = new myapp.customdialog.Dialog(this, rootPaneCheckingEnabled, e.toString());
        d.setVisible(true);
        }
        
    }
    
    public int set_smoke(int j){
    if(j%2 == 0) return 0;
    else return 1;
    }

    public int set_capacity(int j){
        int capacity = 0;
        for (int i = 0; i < j; i++) {
        if(j%3 == 1) return capacity = 1;
        else if(j%3 == 2) return capacity = 2;
        else return capacity = 3;
        }
        return capacity;
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
        rooms_num = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        floor_num = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        hotel_combo = new javax.swing.JComboBox<>();
        smoke_num = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Hotel");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
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

        rooms_num.setBorder(javax.swing.BorderFactory.createTitledBorder("Rooms #"));

        name.setBorder(javax.swing.BorderFactory.createTitledBorder("Hotel Name"));

        address.setBorder(javax.swing.BorderFactory.createTitledBorder("Hotel Adress"));

        floor_num.setBorder(javax.swing.BorderFactory.createTitledBorder("Floors #"));
        floor_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor_numActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(40, 120, 200));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        hotel_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotel_comboActionPerformed(evt);
            }
        });

        smoke_num.setBorder(javax.swing.BorderFactory.createTitledBorder("smoke #"));
        smoke_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smoke_numActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rooms_num, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(smoke_num, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(floor_num, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(floor_num, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rooms_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smoke_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void floor_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_floor_numActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        edit_hotel(selected);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void hotel_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotel_comboActionPerformed
        // TODO add your handling code here:
        selected = hotel_combo.getSelectedItem().toString();
    }//GEN-LAST:event_hotel_comboActionPerformed

    private void smoke_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smoke_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smoke_numActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Hotels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Hotels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Hotels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Hotels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Hotels().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField floor_num;
    private javax.swing.JComboBox<String> hotel_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField rooms_num;
    private javax.swing.JTextField smoke_num;
    // End of variables declaration//GEN-END:variables
}
