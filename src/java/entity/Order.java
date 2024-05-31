/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author nmngh
 */
public class Order {
    String OrderID, UserID, ScheduleID, OrderDate, Status, Price;

    public Order() {
    }

    public Order(String OrderID, String UserID, String ScheduleID, String OrderDate, String Status, String Price) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.ScheduleID = ScheduleID;
        this.OrderDate = OrderDate;
        this.Status = Status;
        this.Price = Price;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(String ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    
    
}
