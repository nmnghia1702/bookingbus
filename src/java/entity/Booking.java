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
public class Booking {
  
    String BookingDate, PickupDate,ReturnDate,BookingID,UserID,ScheduleID;

    public Booking() {
    }

    public Booking(String BookingDate, String PickupDate, String ReturnDate, String BookingID, String UserID, String ScheduleID) {
        this.BookingDate = BookingDate;
        this.PickupDate = PickupDate;
        this.ReturnDate = ReturnDate;
        this.BookingID = BookingID;
        this.UserID = UserID;
        this.ScheduleID = ScheduleID;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    public String getPickupDate() {
        return PickupDate;
    }

    public void setPickupDate(String PickupDate) {
        this.PickupDate = PickupDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
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

   
    
    
}
