/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Bus;
import entity.BusSchedule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nmngh
 */
public class DAOBusSchedule extends DBConnect {

    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec

    public void insert(BusSchedule obj) {

        String sql = "insert into BusSchedule(BusID,DepartureTime,ArrivalTime,DepartureLocation,ArrivalLocation) values(?,?,?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(obj.getBusID()));
            stm.setString(2, obj.getDepartureTime());
            stm.setString(3, obj.getArrivalTime());
            stm.setString(4, obj.getDepartureLocation());
            stm.setString(5, obj.getArrivalLocation());
            stm.execute();
        } catch (Exception e) {
            System.out.println("insertBusSchedule" + e.getMessage());
        }
    }

    public int insert2(BusSchedule obj) {
        String sql = "INSERT INTO BusSchedule(BusID, DepartureTime, ArrivalTime, DepartureLocation, ArrivalLocation) VALUES (?, ?, ?, ?, ?)";
        int scheduleID = -1; // Giá trị mặc định trả về nếu không thể lấy được ScheduleID

        try {
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, Integer.parseInt(obj.getBusID()));
            stm.setString(2, obj.getDepartureTime());
            stm.setString(3, obj.getArrivalTime());
            stm.setString(4, obj.getDepartureLocation());
            stm.setString(5, obj.getArrivalLocation());

            // Thực thi câu lệnh và lấy kết quả trả về
            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stm.getGeneratedKeys();
                if (generatedKeys.next()) {
                    scheduleID = generatedKeys.getInt(1); // Lấy ScheduleID từ kết quả trả về
                }
            }
        } catch (Exception e) {
            System.out.println("insertBusSchedule: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception ex) {
                System.out.println("insertBusSchedule: " + ex.getMessage());
            }
        }

        return scheduleID; // Trả về ScheduleID
    }

    public ArrayList<BusSchedule> getData() {
        ArrayList<BusSchedule> list = new ArrayList<>();
        try {
            String sql = "select * from BusSchedule";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getString(1));
                String busid = String.valueOf(rs.getString(2));
                String departuretime = rs.getString(3);
                String arrivaltime = rs.getString(4);
                String departurelocation = rs.getString(5);
                String arrivallocation = rs.getString(6);

                BusSchedule u = new BusSchedule(id, busid, departuretime, arrivaltime, departurelocation, arrivallocation);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertBusSchedule" + e.getMessage());
        }
        return list;
    }
    
    public BusSchedule getBusScheduleById(String id1) {
        try {
            String strSQL = "select * from [BusSchedule] where BusID = ? ";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id1);
            rs = stm.executeQuery();
            if (rs.next()) {
                String id = String.valueOf(rs.getString(1));
                String busid = String.valueOf(rs.getString(2));
                String departuretime = rs.getString(3);
                String arrivaltime = rs.getString(4);
                String departurelocation = rs.getString(5);
                String arrivallocation = rs.getString(6);

                BusSchedule u = new BusSchedule(id, busid, departuretime, arrivaltime, departurelocation, arrivallocation);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getBus" + e.getMessage());
        }
        return null;
    }

    public void update(BusSchedule b) {
        try {
            String sql = "update BusSchedule set BusID=? ,DepartureTime=?,ArrivalTime=?,DepartureLocation=?,ArrivalLocation=? "
                    + "where BusScheduleID = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(b.getBusID()));
            stm.setString(2, b.getDepartureTime());
            stm.setString(3, b.getArrivalTime());
            stm.setString(4, b.getDepartureLocation());
            stm.setString(5, b.getArrivalLocation());
            stm.setInt(6, Integer.parseInt(b.getScheduleID()));

            stm.execute();

        } catch (Exception e) {
            System.out.println("updateBusSchedule" + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            String strSQL = "delete from BusSchedule where ScheduleID=?";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();

        } catch (Exception e) {
            System.out.println("delete" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DAOBusSchedule dao = new DAOBusSchedule();
        BusSchedule b = dao.getBusScheduleById("1");
        System.out.println(b.getBusID());
    }

}
