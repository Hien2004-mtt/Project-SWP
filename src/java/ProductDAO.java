/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;



/**
 *
 * @author athuu
 */
public class ProductDAO {
    public List<ProductDTO> getFilteredProducts(String name, String category, String sort, int page, int pageSize){
        List<ProductDTO> list = new ArrayList<>();
        
        String sql = "SELECT * FROM Products WHERE isDelete = 0";
        
        if(name!= null && !name.isEmpty()){
            sql += " AND ProductName LIKE ?";
        }if(category!=null && !category.isEmpty()){
            sql += " AND CategoryId = ?";
        }if("asc".equalsIgnoreCase(sort)){
            sql += " ORDER BY Price asc";
        }else if("desc".equalsIgnoreCase(sort)){
            sql += " ORDER BY Price desc";
        }else {
            sql += " ORDER BY ProductId desc";
        }
        sql += " OFFSET ? ROWS FETCH NEXT ? ROW ONLY";
        
        try(Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            
            
            int index = 1;
            
            if(name!=null && !name.isEmpty()){
                ps.setString(index++, "%" + name + "%");
            }if(category!=null && !category.isEmpty()){
                ps.setString(index++, category);
            }
            ps.setInt(index++, (page - 1) * pageSize);
            ps.setInt(index++, pageSize);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ProductDTO(
                rs.getInt("ProductId"),
                rs.getString("ProductName"),
                rs.getString("Origin"),
                rs.getString("ImageUrl"),
                rs.getDouble("DiscountPercent"),
                rs.getDouble("Price"),
                rs.getDouble("DiscountPrice"),
                rs.getInt("Sold"),
                rs.getDouble("Rating"),
                rs.getInt("ReviewCount")
                        
                ));
            }  
            }catch(Exception e){
                    e.printStackTrace();
            }
        return list;
        }
    
    public int getTotalFilteredCount(String name, String category){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Products WHERE isDelete = 0";
        if(name != null && !name.isEmpty()){
            sql += " AND ProductName LIKE ?";
        }if(category != null && !category.isEmpty()){
            sql += " AND CategoryID = ?";
        }
        
        try(Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql))          
            {
            int index = 1;
            if(name!=null && !name.isEmpty()){
                ps.setString(index++, "%" + name + "%");
            }if(category!=null && !category.isEmpty()){
                ps.setString(index++, category);
            }
                  
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
        
                
                
 
       
   
    

