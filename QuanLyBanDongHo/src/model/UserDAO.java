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
                user.setRole(rs.getBoolean("role"));
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
    
    public void XoaUser(String userName){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from users where username = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, userName);
            sttm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
    public void CapNhatUser(User user){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update users set password = ?, role = ? where username =" + "\"" + user.getUsername() + "\"" ;
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, user.getPassword());
            sttm.setBoolean(2, user.isRole());
            sttm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void CapNhatRole(boolean role , String username){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update users set role = ? where username = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setBoolean(1, role);
            sttm.setString(2, username);
            sttm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
    
    public boolean checkLogin(String username, String password){
        User user = getUserByUsername(username);
        if(user != null){
            if(user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public void ThemUser(User us){
                Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into users(username, password, role)"
                    + "value(?,?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, us.getUsername());
            sttm.setString(2, us.getPassword());
            sttm.setBoolean(3, us.isRole());
            sttm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
    
}
