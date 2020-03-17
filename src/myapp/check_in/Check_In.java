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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JFrame;
import myapp.Login.Login_Frame;
import myapp.customdialog.Dialog;
import myapp.main_frame.Main_Frame;
import java.text.SimpleDateFormat;  
import java.time.LocalDate;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import myapp.Global_Var;
/**
 *
 * @author Mohammed Al 3mawy
 */
public class Check_In extends javax.swing.JFrame {
    String selected_hotel;
    String Selected_guest;
    static LocalDate from_date;
    static LocalDate to_date;
    
    /**
     * Creates new form Check_In
     */
    public Check_In() {
        initComponents();
        get_hotels();
        get_guests();
    }
    
    public void make_booking() throws Exception {

        Connection conn = null;
        PreparedStatement make_booking;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String make_booking_query = "INSERT INTO `hotel management system`.`booking_transaction` (`hotel`, `guest`, `agent`, `bookedroom`, `from`, `to`, `status`) VALUES ( ? , ? , ? , ? , ? , ? , ?)";
            make_booking = conn.prepareStatement(make_booking_query);
            make_booking.setInt(1, get_hotel_id());
            make_booking.setInt(2, get_guest_id());
            make_booking.setInt(3, get_agent_id());
            make_booking.setInt(4, get_bookedroom_id());
            make_booking.setDate(5, java.sql.Date.valueOf(from_date));
            make_booking.setDate(6, java.sql.Date.valueOf(to_date));
            make_booking.setInt(7, 1);
            make_booking.executeUpdate();
            
            test();
            
            new Dialog(this, rootPaneCheckingEnabled, "Check in Done!").setVisible(true);
        } catch(SQLException e){
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        
    }
    
    public void test(){
        System.err.println(
             get_hotel_id()+" guest: "
            +get_guest_id()+" agent: "
            +get_agent_id()+" bookedroom: "
            +get_bookedroom_id());
    }
    
    public void insert_geust(){
        Connection conn = null;
        PreparedStatement new_guest_query = null;

        try {
            Global_Var.guest_name = gu_name.getText();
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String insert_guest = "INSERT INTO Guests(name,address,phone) values(?,?,?)";
            
            new_guest_query = conn.prepareStatement(insert_guest);
            new_guest_query.setString(1, Global_Var.agent_name);
            new_guest_query.setString(2, gu_address.getText());
            new_guest_query.setString(3, gu_phone.getText());
            new_guest_query.executeUpdate();
            
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    }
    
    public int get_guest_id(){
        int res = 0;
        Connection conn = null;
        PreparedStatement get_guest_id = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_geust_id_query = "select guest_id from guests where `name`=?";
            get_guest_id = conn.prepareStatement(get_geust_id_query);
            get_guest_id.setString(1, Selected_guest);
            rs = get_guest_id.executeQuery();
             while (rs.next()) {                
            res = rs.getInt("guest_id");    
                System.err.println(rs.getInt("guest_id"));
            }
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        return res;
    }
    
    public int get_agent_id(){
        int res = 0;
        Connection conn = null;
       PreparedStatement query = null;
        ResultSet agent_id = null;
        try {
             conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_agent_id = "SELECT agent_id FROM agents WHERE (name=?)";
            
            query = conn.prepareStatement(get_agent_id);
            
            query.setString(1, Global_Var.agent_name);
            agent_id = query.executeQuery();
            while (agent_id.next()) {                
            res = agent_id.getInt("agent_id");    
                System.err.println(agent_id.getInt("agent_id"));
            }
        } catch (Exception e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        return res;
    }
    
    public int get_bookedroom_id(){
        int res = 0;
        Connection conn = null;
       PreparedStatement query = null;
        ResultSet agent_id = null;
        try {
             conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String get_agent_id = "SELECT bookedroom_id FROM booked_rooms WHERE (guest_id=?)";
            
            query = conn.prepareStatement(get_agent_id);
            
            query.setInt(1, get_guest_id());
            agent_id = query.executeQuery();
            while (agent_id.next()) {                
            res = agent_id.getInt("bookedroom_id");
            }
        } catch (SQLException e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
        return res;
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
            hotel_id.setString(1, selected_hotel);
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
    
    public void reserve_availible_rooms(){
        Connection conn = null;
        PreparedStatement rooms_book = null;
        ResultSet rs = null;
        int capacity = 0;
        boolean smoking = false;
        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String select = "select * from Rooms where hotel=? and capacity=? and smoke=? and status=1";
            
            capacity = Integer.valueOf(this.capacity.getText());
            smoking = this.smoking.isSelected();
            
            rooms_book = conn.prepareStatement(select);
            rooms_book.setInt(1, get_hotel_id());
            rooms_book.setInt(2, capacity);
            rooms_book.setInt(3, set_smoking());
            
            rs = rooms_book.executeQuery();
            
            Vector columnNames = new Vector();
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 0; i < columns; i++) 
            columnNames.addElement(rs.getMetaData().getColumnName(i + 1));
            Vector data = new Vector();
            
            Stack<Integer> rooms_id = new Stack<>();
            while (rs.next()) {
                Vector row = new Vector(columns);
                rooms_id.push(rs.getInt(1));
                for (int i = 0; i < columns; i++) 
                row.addElement(rs.getObject(i + 1));
                data.addElement(row);
            }
            Available_Rooms ResultFrame = new Available_Rooms(data, columnNames);
            ResultFrame.setVisible(true);
            
            int room_num = Integer.valueOf(rooms.getText());
            while(room_num !=0){
                room_num--;
                
                int chosen_room = rooms_id.pop();
        PreparedStatement insert_booked_rooms = null;

        PreparedStatement update_state = null;

        try {
            
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String insert_guest = "INSERT INTO `hotel management system`.`booked_rooms` (`guest_id`, `room_id`) VALUES (?, ?)";
            
            insert_booked_rooms = conn.prepareStatement(insert_guest);
            insert_booked_rooms.setInt(1, get_guest_id());
            insert_booked_rooms.setInt(2, chosen_room);
            insert_booked_rooms.executeUpdate();
            
            String update_sroom_status = "UPDATE `hotel management system`.`rooms` SET `status` = '2' WHERE (`room_id` = ?)";
            update_state = conn.prepareStatement(update_sroom_status);
            update_state.setInt(1, chosen_room);
            update_state.executeUpdate();
           
            
        } catch (SQLException e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
            }
            
            
            
            
        } catch (NumberFormatException | SQLException e) {
            new Dialog(this, rootPaneCheckingEnabled, e.toString()).setVisible(true);
        }
    
    }
    
    public int set_smoking(){
    if(this.smoking.isSelected())return 1;
    else return 0;
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
    
         public void get_guests() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MyApp.DB_URL, MyApp.USER, MyApp.PASS);
            String select = "select * from guests";

            preparedStatement = conn.prepareStatement(select);

            rs = preparedStatement.executeQuery();

           
            while (rs.next()) {
                String name = rs.getString("name");
                guest_combo.addItem(name);
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
        guest_combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gu_phone = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        capacity = new javax.swing.JTextField();
        smoking = new javax.swing.JCheckBox();
        rooms = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pick_from = new javax.swing.JButton();
        pick_to = new javax.swing.JButton();
        to = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        reserve_room = new javax.swing.JButton();
        add_guest = new javax.swing.JButton();
        hotel_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        guest_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guest" }));
        guest_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guest_comboActionPerformed(evt);
            }
        });

        jLabel1.setText("Guest Info");

        jLabel6.setText("Hotel And Rooms info");

        gu_phone.setBorder(javax.swing.BorderFactory.createTitledBorder("Guest Phone"));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status", "Confirmed", "Cancled" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Reservation info");

        capacity.setBorder(javax.swing.BorderFactory.createTitledBorder("Guests No."));

        smoking.setBackground(new java.awt.Color(255, 255, 255));
        smoking.setText("Smoke Room");
        smoking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokingActionPerformed(evt);
            }
        });

        rooms.setBorder(javax.swing.BorderFactory.createTitledBorder("Rooms No."));

        jButton1.setBackground(new java.awt.Color(40, 120, 200));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book Now");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        reserve_room.setBackground(new java.awt.Color(40, 120, 200));
        reserve_room.setForeground(new java.awt.Color(255, 255, 255));
        reserve_room.setText("reserve room");
        reserve_room.setBorderPainted(false);
        reserve_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserve_roomActionPerformed(evt);
            }
        });

        add_guest.setBackground(new java.awt.Color(40, 120, 200));
        add_guest.setForeground(new java.awt.Color(255, 255, 255));
        add_guest.setText("Add Guest");
        add_guest.setBorderPainted(false);
        add_guest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_guestActionPerformed(evt);
            }
        });

        hotel_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hotel" }));
        hotel_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotel_comboActionPerformed(evt);
            }
        });

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
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gu_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gu_address, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gu_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(guest_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(smoking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reserve_room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pick_from)
                                    .addComponent(pick_to)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(add_guest)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(gu_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gu_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gu_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_guest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guest_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(hotel_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(smoking, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(reserve_room)
                .addGap(16, 16, 16)
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
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void guest_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guest_comboActionPerformed
        // TODO add your handling code here:
        Selected_guest = guest_combo.getSelectedItem().toString();
    }//GEN-LAST:event_guest_comboActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void gu_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gu_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gu_addressActionPerformed

    private void smokingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smokingActionPerformed

    private void pick_fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pick_fromActionPerformed
        // TODO add your handling code here:
//        test();
      
        String str_date = new DatePicker(this).setPickedDate();
        LocalDate date = LocalDate.parse(str_date);
        from_date = date;
        from.setText("From Date: "+from_date);
    }//GEN-LAST:event_pick_fromActionPerformed

    private void pick_toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pick_toActionPerformed
        // TODO add your handling code here:
        
        String str_date = new DatePicker(this).setPickedDate();
        LocalDate date = LocalDate.parse(str_date);
        to_date = date;
        to.setText("To Date: "+to_date);
    }//GEN-LAST:event_pick_toActionPerformed

    private void reserve_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserve_roomActionPerformed
        // TODO add your handling code here:
//        test();
        reserve_availible_rooms();
    }//GEN-LAST:event_reserve_roomActionPerformed

    private void add_guestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_guestActionPerformed
        // TODO add your handling code here:
//        test();
        insert_geust();
    }//GEN-LAST:event_add_guestActionPerformed

    private void hotel_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotel_comboActionPerformed
        // TODO add your handling code here:
        selected_hotel = hotel_combo.getSelectedItem().toString();
    }//GEN-LAST:event_hotel_comboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        test();
        try {
            make_booking();
        } catch (Exception ex) {
           new Dialog(this, rootPaneCheckingEnabled, ex.toString()).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
          for (double i = 0; i <= 1; i += 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(70);
            } catch(Exception ex){
            }
        }
    }//GEN-LAST:event_formWindowOpened
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
    private javax.swing.JButton add_guest;
    private javax.swing.JTextField capacity;
    private javax.swing.JLabel from;
    private javax.swing.JTextField gu_address;
    private javax.swing.JTextField gu_name;
    private javax.swing.JTextField gu_phone;
    private javax.swing.JComboBox<String> guest_combo;
    private javax.swing.JComboBox<String> hotel_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton pick_from;
    private javax.swing.JButton pick_to;
    private javax.swing.JButton reserve_room;
    private javax.swing.JTextField rooms;
    private javax.swing.JCheckBox smoking;
    private javax.swing.JLabel to;
    // End of variables declaration//GEN-END:variables
}
