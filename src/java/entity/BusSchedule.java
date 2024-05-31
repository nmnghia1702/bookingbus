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
public class BusSchedule {
    String ScheduleID, BusID;
    String DepartureTime, ArrivalTime;
    String DepartureLocation, ArrivalLocation;

    public BusSchedule() {
    }

    public BusSchedule(String ScheduleID, String BusID, String DepartureTime, String ArrivalTime, String DepartureLocation, String ArrivalLocation) {
        this.ScheduleID = ScheduleID;
        this.BusID = BusID;
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.DepartureLocation = DepartureLocation;
        this.ArrivalLocation = ArrivalLocation;
    }

    public String getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(String ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String BusID) {
        this.BusID = BusID;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public String getDepartureLocation() {
        return DepartureLocation;
    }

    public void setDepartureLocation(String DepartureLocation) {
        this.DepartureLocation = DepartureLocation;
    }

    public String getArrivalLocation() {
        return ArrivalLocation;
    }

    public void setArrivalLocation(String ArrivalLocation) {
        this.ArrivalLocation = ArrivalLocation;
    }

     

   
    
}
