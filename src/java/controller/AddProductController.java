/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.AddProductDTO;
import dto.CategoryDTO;
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
 * @author Admin
 */
@WebServlet(name="AddProductController", urlPatterns={"/AddProductController"})
public class AddProductController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            double price = Double.parseDouble(request.getParameter("price"));
            int discountPercent = Integer.parseInt(request.getParameter("discountPercent"));
            int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
            String imageUrl = request.getParameter("imageUrl");
            String origin = request.getParameter("origin");
            
            ProductDAO dao = new ProductDAO();
            AddProductDTO product = new AddProductDTO(0,productName,description, categoryID, price, discountPercent, stockQuantity, imageUrl, origin);
            
            boolean isSuccess = dao.addProduct(product);
            
            if (isSuccess){
                request.getRequestDispatcher("").forward(request,response);
                
            }else {
                request.setAttribute("errorMessage", "Error adding product.Please try again.");
                request.getRequestDispatcher("add-product.jsp").forward(request, response);
            }            
            
       
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
