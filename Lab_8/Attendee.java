
package com.mycompany.attendee;

import java.sql.*;
public class Attendee {
    public static void addAttendee(String fullName, String email, String contactNumber, String country) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO attendees (full_name, email, contact_number, country) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stat = conn.prepareStatement(sql)) {
                stat.setString(1, fullName);
                stat.setString(2, email);
                stat.setString(3, contactNumber);
                stat.setString(4, country);
                stat.executeUpdate();
                System.out.println("Attendee added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Edit Attendee by ID
    public static void editAttendee(int id, String newEmail, String newContactNumber) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE attendees SET email = ?, contact_number = ? WHERE id = ?";
            try (PreparedStatement stat = connection.prepareStatement(sql)) {
                stat.setString(1, newEmail);
                stat.setString(2, newContactNumber);
                stat.setInt(3, id);
                stat.executeUpdate();
                System.out.println("Attendee updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Attendee by ID
    public static void deleteAttendee(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM attendees WHERE id = ?";
            try (PreparedStatement stat = connection.prepareStatement(sql)) {
                stat.setInt(1, id);
                stat.executeUpdate();
                System.out.println("Attendee deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Attendee by ID, Name, or Country
    public static void searchAttendee(String searchQuery) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM attendees WHERE full_name LIKE ? OR country LIKE ?";
            try (PreparedStatement stat = connection.prepareStatement(sql)) {
                stat.setString(1, "%" + searchQuery + "%");
                stat.setString(2, "%" + searchQuery + "%");
                ResultSet resultSet = stat.executeQuery();
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("full_name") +
                            ", Email: " + resultSet.getString("email") + ", Contact: " + resultSet.getString("contact_number") +
                            ", Country: " + resultSet.getString("country"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Generate Attendee Statistics by Country
    public static void generateStatistics() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // CallableStatement to execute the stored procedure
            String sql = "{CALL get_attendee_statistics()}";
            try (CallableStatement callableStatement = connection.prepareCall(sql)) {
                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("Country: " + resultSet.getString("country") + ", Attendees: " + resultSet.getInt("number_of_attendees"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        
    }
    
}
