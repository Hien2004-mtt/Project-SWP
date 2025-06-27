/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package dto;

public class AddProductDTO {
    private int productID;
    private String productName;
    private String description;
    private int categoryID;
    private double price;
    private int discountPercent;
    private int stockQuantity;
    private String imageUrl;
    private String origin;
    
    public AddProductDTO(int productID1, String productName1, String description1, int categoryID1, double price1, int discountPercent1, int stockQuantity1, String imageUrl1, String origin1) {
    }
    
    public AddProductDTO(int producID, String productName, String description, int categoryID, int discountPercent, int stockQuantity, String imageUrl, String origin) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.categoryID = categoryID;
        this.price = price;
        this.discountPercent = discountPercent;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.origin = origin;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescroption(String descroption) {
        this.description = descroption;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    }
            

