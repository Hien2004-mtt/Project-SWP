/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBUtils {

    public UserDTO checkLogin(String email, String password) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String LOGIN = "SELECT * FROM Users WHERE Email = ? AND PasswordHash = ?";
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();

                if (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String fullName = rs.getString("FullName");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int roleID = rs.getInt("RoleID");
                    int loyaltyPoints = rs.getInt("LoyaltyPoints");
                    boolean isActive = rs.getBoolean("IsActive");
                    loginUser = new UserDTO(userID, fullName, email, null, phone, address, roleID, loyaltyPoints, isActive);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return loginUser;
    }

    public boolean checkEmailExists(String email) throws SQLException, ClassNotFoundException {
        boolean exists = false;
        String sql = "SELECT Email FROM Users WHERE Email = ?";
        try (Connection conn = DBUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    public boolean insertUser(UserDTO user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Users (FullName, Email, PasswordHash, Phone, Address, RoleID, LoyaltyPoints, IsActive) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getRoleID());
            ps.setInt(7, user.getLoyaltyPoints());
            ps.setBoolean(8, user.isIsActive());

            return ps.executeUpdate() > 0;
        }
    }

    

  
}
