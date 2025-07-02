/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.CategoryDTO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author AD
 */
@WebServlet (name="ProductManagementController", urlPatterns={"/ProductManagementController"})
public class ProductManagementController extends HttpServlet {
    
     private static final int PAGE_SIZE = 10;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null && !pageStr.isEmpty()) {
            page = Integer.parseInt(pageStr);
        }
        CategoryDAO dao = new CategoryDAO();
         List<CategoryDTO> categories = dao.getAllCategories();
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ProductDAO daoProduct = new ProductDAO();
        List<ProductDTO> products = daoProduct.getFilteredProducts("", "", "", page, PAGE_SIZE);           
        int total = daoProduct.getTotalFilteredCount("", "");
        int totalPages = (int) Math.ceil(total * 1.0 / PAGE_SIZE);       
        request.setAttribute("productList", products);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("categories", categories);     
        request.getRequestDispatcher("product-admin.jsp").forward(request, response);
    } 

}
