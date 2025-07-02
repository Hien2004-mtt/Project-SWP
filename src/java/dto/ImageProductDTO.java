/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Asus
 */
public class ImageProductDTO {
    private int imageID;
    private int productID;
    private String imageURL;

    public ImageProductDTO() {
    }

    public ImageProductDTO(int imageID, int productID, String imageURL) {
        this.imageID = imageID;
        this.productID = productID;
        this.imageURL = imageURL;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "ImageProductDTO{" + "imageID=" + imageID + ", productID=" + productID + ", imageURL=" + imageURL + '}';
    }
    
}
