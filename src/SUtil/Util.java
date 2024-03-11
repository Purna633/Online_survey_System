package SUtil;

import SEncap.Encap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Util {
    Connection conn;
    Statement stmt;

    public Util() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_survey", "root", "@purnaale#1633");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }

    public void addUser(Encap ep) {
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO register (name,email,phone,gender,address,fName,mName) values(?,?,?,?,?,?,?)");
            pst.setString(1, ep.getName());
            pst.setString(2, ep.getEmail());
            pst.setString(3, ep.getPhone());
            pst.setString(4, ep.getGender());
            pst.setString(5, ep.getAddress());
            pst.setString(6, ep.getfName());
            pst.setString(7, ep.getmName());
            pst.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void update(Encap ep) {

        try {
            PreparedStatement pst1 = conn.prepareStatement("UPDATE register SET name=?, phone=?, gender=?, address=?, fName=?, mName=? WHERE email=?");
            pst1.setString(1, ep.getName());
            pst1.setString(2, ep.getPhone());
            pst1.setString(3, ep.getGender());
            pst1.setString(4, ep.getAddress());
            pst1.setString(5, ep.getfName());
            pst1.setString(6, ep.getmName());
            pst1.setString(7, ep.getEmail());




            pst1.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void delete(Encap ep) {
        try {
            PreparedStatement pst3 = conn.prepareStatement("DELETE from register  WHERE email=?");
            pst3.setString(1, ep.getEmail());
            pst3.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public ResultSet display() {
        ResultSet rs = null;
        try {
            PreparedStatement pst3 = conn.prepareStatement("SELECT * FROM register");
            rs = pst3.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}




