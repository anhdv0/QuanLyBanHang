/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Database.DatabaseUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class UserDAO {
  
    public User getUserByUsername(String username){
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        User user = new User();
        try {
            String sSQL = "select * from users where username = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, username);
            rs = sttm.executeQuery();
            while(rs.next()){
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setUsername(rs.getString("username"));
                return user;
            }
            
        } catch (Exception e) {
            System.out.println("Error!");
        }
        finally{
            try {
                con.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    
    
    public boolean checkLogin(String username, String password){
        User user = getUserByUsername(username);
        if(user != null){
            if(user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    
}
