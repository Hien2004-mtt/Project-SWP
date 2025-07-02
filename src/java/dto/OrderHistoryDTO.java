/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package dto;

import java.util.Date;
import java.util.List;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;

public class OrderHistoryDTO{

private int orderID;
private Date orDate;
private String address;
private String phone;
private String fullName;
private int paymentMethodID;
private String status;
private String statusOrder;
private String shipCode;
private double totalAmountt;
private List<ProductOrderDTO> product;

public OrderHistoryDTO(){
}
 public OrderHistoryDTO   (int orderID, Date orderDate, String address, String phone, String fullName, int paymentMethodID, String status, String statusOrder, String shipCode, double totalAmount, List<ProductOrderDTO> product){
     
     this.orderID=orderID;
}

    public OrderHistoryDTO(Date orDate, String address, String phone, String fullName, int paymentMethodID, String status, String statusOrder, String shipCode, double totalAmountt, List<ProductOrderDTO> product) {
        this.orDate = orDate;
        this.address = address;
        this.phone = phone;
        this.fullName = fullName;
        this.paymentMethodID = paymentMethodID;
        this.status = status;
        this.statusOrder = statusOrder;
        this.shipCode = shipCode;
        this.totalAmountt = totalAmountt;
        this.product = product;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrDate() {
        return orDate;
    }

    public void setOrDate(Date orDate) {
        this.orDate = orDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public double getTotalAmountt() {
        return totalAmountt;
    }

    public void setTotalAmountt(double totalAmountt) {
        this.totalAmountt = totalAmountt;
    }

    public List<ProductOrderDTO> getProduct() {
        return product;
    }

    public void setProduct(List<ProductOrderDTO> product) {
        this.product = product;
    }
   }
