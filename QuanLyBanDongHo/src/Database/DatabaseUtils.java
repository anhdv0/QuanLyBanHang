/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class DatabaseUtils {
    public static Connection getDBConnect() throws SQLException {
	try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quanlybanhang?useSSL=false";
            String user = "root";
            String password = "anhdv0";
            con = (Connection) DriverManager.getConnection(url, user, password);
            return con;
	} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Error!!!!1");
            e.printStackTrace();
	} 
        return null;
    }
}
