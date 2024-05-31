/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author nmngh
 */
public class DAOOrder extends DBConnect {

    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec

    public void insert(Order obj) {

        String sql = "insert into [Order](UserID,ScheduleID,OrderDate,Status,Price) values(?,?,?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(obj.getUserID()));
            stm.setInt(2, Integer.parseInt(obj.getScheduleID()));
            stm.setString(3, obj.getOrderDate());
            stm.setString(4, obj.getStatus());
            stm.setFloat(5, Float.parseFloat(obj.getPrice()));

            stm.execute();
        } catch (Exception e) {
            System.out.println("insertOrder" + e.getMessage());
        }
    }

    public int insert2(Order obj) {
        int n = 0;
        String sql = "insert into [Order](UserID,ScheduleID,OrderDate,Status,Price) values(" + obj.getUserID() + "," + obj.getScheduleID()
                + ",'" + obj.getOrderDate() + "','" + obj.getStatus()
                + "'," + obj.getPrice() + ")";
        System.out.println(sql);
        //Statement
        Statement state;
        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("insertOrder" + ex.getMessage());
        }
        return n;
    }
    public int update2(Order obj) {
        int n = 0;
        String sql = "update [Order] set UserID=?, ScheduleID=?, OrderDate=?, Status = ?, Price=? "
                    + "where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            //  DataType is datatype of field; indexOf? start is 1

            pre.setString(1, obj.getUserID());
            pre.setString(2, obj.getScheduleID());
            pre.setString(3, obj.getOrderDate());
            pre.setString(4, obj.getStatus());
            pre.setString(5, obj.getPrice());
            pre.setString(6, obj.getOrderID());

            n = pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public ArrayList<Order> getData() {
        ArrayList<Order> list = new ArrayList<>();
        try {
            String sql = "select * from [Order]";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String oid = String.valueOf(rs.getString(1));
                String uid = String.valueOf(rs.getString(2));
                String sid = String.valueOf(rs.getString(3));
                String odate = rs.getString(4);
                String status = rs.getString(5);
                String price = rs.getString(6);

                Order u = new Order(oid, uid, sid, odate, status, price);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertOrder" + e.getMessage());
        }
        return list;
    }

    public Order getOrderById(String id) {
        try {
            String strSQL = "select * from [Order] where OrderID = ? ";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String oid = String.valueOf(rs.getString(1));
                String uid = String.valueOf(rs.getString(2));
                String sid = String.valueOf(rs.getString(3));
                String odate = rs.getString(4);
                String status = rs.getString(5);
                String price = rs.getString(6);

                Order u = new Order(oid, uid, sid, odate, status, price);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getOrders" + e.getMessage());
        }
        return null;
    }

    public void update(Order b) {
        try {
            String sql = "update [Order] set UserID=?, ScheduleID=?, OrderDate=?, Status = ?, Price=? "
                    + "where OrderID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, b.getUserID());
            stm.setString(2, b.getScheduleID());
            stm.setString(3, b.getOrderDate());
            stm.setString(4, b.getStatus());
            stm.setString(5, b.getPrice());
            stm.setString(6, b.getOrderID());

            stm.execute();

        } catch (Exception e) {
            System.out.println("updateOrder" + e.getMessage());
        }
    }

//    public void delete(String id) {
//        try {
//            String strSQL = "delete from [Order] where OrderID=?";
//            stm = conn.prepareStatement(strSQL);
//            stm.setString(1, id);
//            stm.execute();
//
//        } catch (Exception e) {
//            System.out.println("delete" + e.getMessage());
//        }
//    }
    
    public int delete(String id) {
        int n = 0;
        String sql = "delete from [Order] where OrderID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            //  DataType is datatype of field; indexOf? start is 1

            pre.setString(1, id);

            n = pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {

    }
    public String getOrderDate(String order){
        String[] arr=order.split(" ");
        String result="";
        result=arr[0];
        return result; 
    }
}
