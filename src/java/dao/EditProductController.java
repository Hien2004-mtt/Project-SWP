/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ProductDAO;
import dto.AddProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author Admin
 */
@WebServlet(name="EditProductController", urlPatterns={"/EditProductController"})
public class EditProductController extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try{
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        double price = Double.parseDouble(request.getParameter("price"));
        int discountPercent = Integer.parseInt(request.getParameter("discountPercent"));
        int stockQuantity = Integer.parseInt(request.getParameter("stockQ;uantity"));
        String imageUrl = request.getParameter("imageUrl");
        String origin = request.getParameter("origin");
        ProductDAO dao = new ProductDAO();
        AddProductDTO product = new AddProductDTO(productID,productName, description, categoryID,price, discountPercent, stockQuantity, imageUrl, origin);
        dao.updateProduct(product);
        boolean isSuccess = dao.updateProduct(product);
        
        if(isSuccess) {
            request.getRequestDispatcher(origin).forward(request, response);
        } else{
                    request.setAttribute("errorMessage", "Error adding product. Please try again");
                    request.getRequestDispatcher("add-product.jsp").forward(request, response);
                    }
        
    }catch(Exception e){
                e.printStackTrace();
                }
}
}
   
    