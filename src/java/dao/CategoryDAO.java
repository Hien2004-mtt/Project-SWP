/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

/**
 *
 * @author athuu
 */
public class CategoryDAO {

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> list = new ArrayList<>();
        String sql = "SELECT CategoryID, CategoryName FROM Categories";
        try (Connection conn = DBUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new CategoryDTO(rs.getInt("CategoryID"), rs.getString("CategoryName")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}