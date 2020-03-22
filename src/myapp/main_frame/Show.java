/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.main_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import javax.swing.JButton;
import myapp.MyApp;
import myapp.customdialog.Dialog;
import myapp.datepicker.DatePicker;

/**
 *
 * @author Mohammed Al 3mawy
 */
public class Show extends javax.swing.JFrame {

    /**
     * Creates new form Show
     */
    LocalDate from;
    public Show(){
         initComponents();
        rooms_table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        rooms_table.getTableHeader().setBackground(new Color(40,120,200));
        rooms_table.getTableHeader().setForeground(Color.white);
    }
    public Show(Vector data, Vector cols) {
        initComponents();
        rooms_table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        rooms_table.getTableHeader().setBackground(new Color(40,120,200));
        rooms_table.getTableHeader().setForeground(Color.white);
        DefaultTableModel m = new DefaultTableModel(data, cols);
        rooms_table.setModel(m);
    }

    public void show_transaction(){
    Connection conn = null;
        PreparedStatement get_transactions = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_hotel_id = "SELECT hotel.name as `Hotel Name`,agents.name as `Agent Name`,guests.name as `Guest Name`,booking_transaction.from,booking_transaction.to,booking_transaction.status,booking_transaction.cost\n" +
                                    " FROM hotel,guests,agents,booking_transaction\n" +
                                    " where hotel = hotel_id and guest = guest_id and agent = agent_id";
            get_transactions = conn.prepareStatement(get_hotel_id);
            rs = get_transactions.executeQuery();
            
            Vector columnNames = new Vector();
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) 
            columnNames.addElement(rs.getMetaData().getColumnName(i + 1));
            Vector data = new Vector();
            
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 0; i < columns; i++) 
                row.addElement(rs.getObject(i + 1));
                data.addElement(row);
            }
            rooms_table.setModel(new DefaultTableModel(data, columnNames));
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
}
    
    public void search_by_date(LocalDate date){
        
        
        Connection conn = null;
        PreparedStatement get_transactions = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_hotel_id = "SELECT hotel.name as `Hotel Name`,agents.name as `Agent Name`,guests.name as `Guest Name`,booking_transaction.from,booking_transaction.to,booking_transaction.status,booking_transaction.cost\n" +
                                    " FROM hotel,guests,agents,booking_transaction\n" +
                                    " where hotel = hotel_id and guest = guest_id and agent = agent_id and `from` =?";
            get_transactions = conn.prepareStatement(get_hotel_id);
            get_transactions.setDate(1, java.sql.Date.valueOf(date));
            rs = get_transactions.executeQuery();
            
            Vector columnNames = new Vector();
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) 
            columnNames.addElement(rs.getMetaData().getColumnName(i + 1));
            Vector data = new Vector();
            
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 0; i < columns; i++) 
                row.addElement(rs.getObject(i + 1));
                data.addElement(row);
            }
             rooms_table.setModel(new DefaultTableModel(data, columnNames));
            
           
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public void search_by_guest(){
        
        
        Connection conn = null;
        PreparedStatement get_transactions = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_hotel_id = "SELECT hotel.name as `Hotel Name`,agents.name as `Agent Name`,guests.name as `Guest Name`,booking_transaction.from,booking_transaction.to,booking_transaction.status,booking_transaction.cost\n" +
                                    " FROM hotel,guests,agents,booking_transaction\n" +
                                    " where hotel = hotel_id and guest = guest_id and agent = agent_id and guests.name=?";
            get_transactions = conn.prepareStatement(get_hotel_id);
            get_transactions.setString(1, search_area.getText());
            rs = get_transactions.executeQuery();
            
            Vector columnNames = new Vector();
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) 
            columnNames.addElement(rs.getMetaData().getColumnName(i + 1));
            Vector data = new Vector();
            
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 0; i < columns; i++) 
                row.addElement(rs.getObject(i + 1));
                data.addElement(row);
            }
             rooms_table.setModel(new DefaultTableModel(data, columnNames));
            
           
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public void search_by_agent(){
        
        
       Connection conn = null;
        PreparedStatement get_transactions = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_hotel_id = "SELECT hotel.name as `Hotel Name`,agents.name as `Agent Name`,guests.name as `Guest Name`,booking_transaction.from,booking_transaction.to,booking_transaction.status,booking_transaction.cost\n" +
                                    " FROM hotel,guests,agents,booking_transaction\n" +
                                    " where hotel = hotel_id and guest = guest_id and agent = agent_id and agents.name=?";
            get_transactions = conn.prepareStatement(get_hotel_id);
            get_transactions.setString(1, search_area.getText());
            rs = get_transactions.executeQuery();
            
            Vector columnNames = new Vector();
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) 
            columnNames.addElement(rs.getMetaData().getColumnName(i + 1));
            Vector data = new Vector();
            
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 0; i < columns; i++) 
                row.addElement(rs.getObject(i + 1));
                data.addElement(row);
            }
             rooms_table.setModel(new DefaultTableModel(data, columnNames));
            
           
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        close_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rooms_table = new javax.swing.JTable();
        search_btn = new javax.swing.JButton();
        by_date = new javax.swing.JRadioButton();
        by_guest = new javax.swing.JRadioButton();
        by_agent = new javax.swing.JRadioButton();
        search_area = new javax.swing.JTextField();
        all = new javax.swing.JRadioButton();
        pick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(40, 120, 200), null));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 350));

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
        jLabel1.setText("Show All transactions");

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

        rooms_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        rooms_table.setToolTipText("");
        rooms_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        rooms_table.setFocusable(false);
        rooms_table.setGridColor(new java.awt.Color(153, 153, 153));
        rooms_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        rooms_table.setMinimumSize(new java.awt.Dimension(600, 350));
        rooms_table.setPreferredSize(new java.awt.Dimension(520, 350));
        rooms_table.setRowHeight(25);
        rooms_table.setSelectionBackground(new java.awt.Color(230, 55, 95));
        rooms_table.setShowGrid(false);
        rooms_table.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(rooms_table);

        search_btn.setBackground(new java.awt.Color(40, 120, 200));
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.setBorderPainted(false);
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        by_date.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(by_date);
        by_date.setText("By Date");
        by_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                by_dateActionPerformed(evt);
            }
        });

        by_guest.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(by_guest);
        by_guest.setText("By Guest");
        by_guest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                by_guestActionPerformed(evt);
            }
        });

        by_agent.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(by_agent);
        by_agent.setText("By Agent");
        by_agent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                by_agentActionPerformed(evt);
            }
        });

        all.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(all);
        all.setText("All");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        pick.setBackground(new java.awt.Color(255, 255, 255));
        pick.setForeground(new java.awt.Color(255, 255, 255));
        pick.setBorderPainted(false);
        pick.setEnabled(false);
        pick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_area, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pick)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(all, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(by_date, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(by_guest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(by_agent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search_btn)
                        .addComponent(search_area, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pick, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(all)
                        .addComponent(by_date)
                        .addComponent(by_guest)
                        .addComponent(by_agent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_labelMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_close_labelMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
        if(all.isSelected()){show_transaction();
        } else if(by_date.isSelected()){
            search_by_date(LocalDate.parse(search_area.getText()));
        }else if(by_guest.isSelected()){
            search_by_guest();
        }else if(by_agent.isSelected()){
            search_by_agent();
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void by_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_by_dateActionPerformed
        // TODO add your handling code here:
        pick.setBackground(new java.awt.Color(40, 120, 200));
        pick.setForeground(Color.white);
        pick.setText("Pick");
        pick.setBorderPainted(false);
        pick.setEnabled(true);
    }//GEN-LAST:event_by_dateActionPerformed

    private void pickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickActionPerformed
        // TODO add your handling code here:
        search_area.setEnabled(false);
        String str_date = new DatePicker(this).setPickedDate();
        search_area.setText(str_date);
        pick.setBackground(Color.white);
        pick.setForeground(Color.white);
        pick.setText("");
        pick.setBorderPainted(false);
        pick.setEnabled(false);
    }//GEN-LAST:event_pickActionPerformed

    private void by_guestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_by_guestActionPerformed
        // TODO add your handling code here:
        pick.setBackground(Color.white);
        pick.setForeground(Color.white);
        pick.setBorderPainted(false);
        pick.setEnabled(false);
        pick.setText("");
        search_area.setEnabled(true);
    }//GEN-LAST:event_by_guestActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
        // TODO add your handling code here:
        pick.setBackground(Color.white);
        pick.setForeground(Color.white);
        pick.setBorderPainted(false);
        pick.setEnabled(false);
        pick.setText("");
        search_area.setEnabled(true);
    }//GEN-LAST:event_allActionPerformed

    private void by_agentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_by_agentActionPerformed
        // TODO add your handling code here:
        pick.setBackground(Color.white);
        pick.setForeground(Color.white);
        pick.setBorderPainted(false);
        pick.setEnabled(false);
        pick.setText("");
        search_area.setEnabled(true);
    }//GEN-LAST:event_by_agentActionPerformed

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
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton by_agent;
    private javax.swing.JRadioButton by_date;
    private javax.swing.JRadioButton by_guest;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pick;
    private javax.swing.JTable rooms_table;
    private javax.swing.JTextField search_area;
    private javax.swing.JButton search_btn;
    // End of variables declaration//GEN-END:variables
}
