
package com.mycompany.attendee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    

    public static Connection getConnection() throws SQLException {
        
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //conn.DriverManager.getConnection("jdbc:mysql://localhost:3307/attendee","root","");
        String URL = "jdbc:mysql://localhost:3307/attendee";
        String USER = "root";
        String PASSWORD = "";
        return DriverManager.getConnection(URL, USER, PASSWORD);   
    }
    public static void main(String args) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
          // handle the error
        }
    }
}
