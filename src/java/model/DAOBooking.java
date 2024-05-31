/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.CartController;
import entity.Booking;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nmngh
 */
public class DAOBooking extends DBConnect {

    //DAO Database Access Object
    //Service: insert, update, delete, select
    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec

    public void insert(Booking obj) {

        String sql = "insert into Booking( UserID,ScheduleID,BookingDate,Pickupdate,Returndate) values(?,?,?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(obj.getUserID()));
            stm.setInt(2, Integer.parseInt(obj.getScheduleID()));
            stm.setString(3, obj.getBookingDate());
            stm.setString(4, obj.getPickupDate());
            stm.setString(5, obj.getReturnDate());

            stm.execute();
        } catch (Exception e) {
            System.out.println("insertBooking" + e.getMessage());
        }
    }

    public ArrayList<Booking> getData(String sql) {
        ArrayList<Booking> list = new ArrayList<>();
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String bookingid = String.valueOf(rs.getString(1));
                String userid = String.valueOf(rs.getString(2));
                String schedule = String.valueOf(rs.getString(3));
                String bookingdate = rs.getString(4);
                String pickupdate = rs.getString(5);
                String returndate = rs.getString(6);

                Booking u = new Booking(bookingdate, pickupdate, returndate, bookingid, userid, schedule);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertBooking" + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Booking> getDataByUserID(String userID) {
    ArrayList<Booking> list = new ArrayList<>();
    try {
        // Tạo câu truy vấn SQL để lấy dữ liệu chỉ từ UserID đó
        String sql = "SELECT * FROM Booking WHERE UserID = ?";
        
        // Chuẩn bị câu truy vấn SQL
        stm = conn.prepareStatement(sql);
        stm.setString(1, userID); // Thiết lập giá trị cho tham số UserID
        
        // Thực thi truy vấn SQL
        rs = stm.executeQuery();
        
        // Duyệt qua kết quả trả về
        while (rs.next()) {
            String bookingid = String.valueOf(rs.getString(1));
            String userid = String.valueOf(rs.getString(2));
            String schedule = String.valueOf(rs.getString(3));
            String bookingdate = rs.getString(4);
            String pickupdate = rs.getString(5);
            String returndate = rs.getString(6);

            // Tạo đối tượng Booking và thêm vào danh sách
            Booking u = new Booking(bookingdate, pickupdate, returndate, bookingid, userid, schedule);
            list.add(u);
        }
    } catch (Exception e) {
        System.out.println("getDataByUserID: " + e.getMessage());
    }
    return list;
}


    public ArrayList<Booking> getDataByUserId(String id) {
        ArrayList<Booking> list = new ArrayList<>();
        try {
//            String sql = "SELECT b.*\n"
//                    + "FROM Booking b\n"
//                    + "JOIN [Order] o ON b.ScheduleID = o.ScheduleID\n"
//                    + "WHERE o.[Status] <> 'Paid'and b.UserID =?";
            String sql = "select * from Booking where UserID=?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(id));
            rs = stm.executeQuery();
            while (rs.next()) {
                String bookingid = String.valueOf(rs.getString(1));
                String userid = String.valueOf(rs.getString(2));
                String schedule = String.valueOf(rs.getString(3));
                String bookingdate = rs.getString(4);
                String pickupdate = rs.getString(5);
                String returndate = rs.getString(6);

                Booking u = new Booking(bookingdate, pickupdate, returndate, bookingid, userid, schedule);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertBooking" + e.getMessage());
        }
        return list;
    }

    public Booking getBookingById(String id) {
        try {
            String strSQL = "select * from Booking where BookingID = ? ";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String bookingid = rs.getString(1);
                String userid = rs.getString(2);
                String schedule = rs.getString(3);
                String bookingdate = rs.getString(4);
                String pickup = rs.getString(5);
                String returndate = rs.getString(6);

                Booking u = new Booking(bookingdate, pickup, returndate, bookingid, userid, schedule);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getUsers" + e.getMessage());
        }
        return null;
    }

    public void update(Booking b) {
        try {
            String sql = "update Booking set UserID = ?,ScheduleID =?,BookingDate=?,PickupDate=?,ReturnDate=? "
                    + "where BookingID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, b.getUserID());
            stm.setString(2, b.getScheduleID());
            stm.setString(3, b.getBookingDate());
            stm.setString(4, b.getPickupDate());
            stm.setString(5, b.getReturnDate());
            stm.setString(6, b.getBookingID());

            stm.execute();

        } catch (Exception e) {
            System.out.println("updateBooking" + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            String strSQL = "delete from Booking where BookingID=?";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();

        } catch (Exception e) {
            System.out.println("delete" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DAOBooking boo = new DAOBooking();
        ArrayList<Booking> list = boo.getDataByUserID("2");
        for (Booking booking : list) {
            System.out.println(booking.getBookingID());
        }
    }
}
