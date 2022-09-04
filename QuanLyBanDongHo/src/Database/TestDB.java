/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class TestDB {
    public static void main(String[] args) throws SQLException {
        Connection con = DatabaseUtils.getDBConnect();
        if(con != null)
            System.out.println("Thanh Cong");
        else
            System.out.println("That Bai");
    }
}
