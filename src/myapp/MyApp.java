package myapp;

import myapp.Login.Login_Frame;

/**
 *
 * @author Mohammed Al 3mawy
 */
public class MyApp {

    public static final String DB_URL = "jdbc:mysql://localhost/hotel management system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login_Frame start = new Login_Frame();
        start.setLocationRelativeTo(null);
        start.setVisible(true);
        
    }
    
}
