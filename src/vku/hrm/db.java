/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vku.hrm;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Admin
 */
public class DB {
    Connection conn = null;
    public static Connection java_db(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\Admin\\Desktop\\QuanLyNhanSu\\QuanLyNhanSu\\data.sqlite";
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
