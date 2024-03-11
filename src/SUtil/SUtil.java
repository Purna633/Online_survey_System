package SUtil;

import SEncap.SEncap;

import java.sql.*;

public class SUtil {
    Connection conn;
    Statement stmt;

    public SUtil() {
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

    public void addSurvey(SEncap ep) {
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO survey (q1,q2,q3,q4,rating,des,email) values(?,?,?,?,?,?,?)");
            pst.setString(1, ep.getQ1());
            pst.setString(2, ep.getQ2());
            pst.setString(3, ep.getQ3());
            pst.setString(4, ep.getQ4());
            pst.setString(5, ep.getRating());
            pst.setString(6, ep.getDes());
            pst.setString(7,ep.getEmail());

            pst.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void updateSurvey(SEncap ep) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE survey SET q1=?, q2=?,q3=?, q4=?, rating=?, des=? WHERE email=?");
            pst.setString(1, ep.getQ1());
            pst.setString(2, ep.getQ2());
            pst.setString(3, ep.getQ3());
            pst.setString(4, ep.getQ4());
            pst.setString(5, ep.getRating());
            pst.setString(6, ep.getDes());
            pst.setString(7,ep.getEmail());

            pst.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }
    public void deleteSurvey(SEncap ep) {

        try {
            PreparedStatement pst3 = conn.prepareStatement("DELETE from survey  WHERE email=?");
            pst3.setString(1, ep.getEmail());
            pst3.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public ResultSet display1() {
        ResultSet rs = null;
        try {
            PreparedStatement pst3 = conn.prepareStatement("SELECT * FROM survey");
            rs = pst3.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}

