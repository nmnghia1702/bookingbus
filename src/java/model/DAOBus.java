/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Bus;
import entity.Bus;
import entity.Bus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nmngh
 */
public class DAOBus extends DBConnect {

    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ select

    public void insert(Bus obj) {

        String sql = "insert into Bus(BusNumber,Capacity,Type,Driver,ImageUrl, Price,PriceCart) values(?,?,?,?,?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, obj.getBusNumber());
            stm.setInt(2, Integer.parseInt(obj.getCapacity()));
            stm.setString(3, obj.getType());
            stm.setString(4, obj.getDriver());
            stm.setString(5, obj.getImageUrl());
            stm.setFloat(6, Float.parseFloat(obj.getPrice()));
            stm.setFloat(7, Float.parseFloat(obj.getPriceCart()));
            stm.execute();
        } catch (Exception e) {
            System.out.println("insertBus" + e.getMessage());
        }
    }

    public int insert2(Bus obj) {
        String sql = "INSERT INTO Bus(BusNumber, Capacity, [Type], Driver, ImageUrl, Price,PriceCart) VALUES (?, ?, ?, ?, ?, ?,?)";
        int scheduleID = -1; // Giá trị mặc định trả về nếu không thể lấy được ScheduleID

        try {
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, obj.getBusNumber());
            stm.setInt(2, Integer.parseInt(obj.getCapacity()));
            stm.setString(3, obj.getType());
            stm.setString(4, obj.getDriver());
            stm.setString(5, obj.getImageUrl());
            stm.setFloat(6, Float.parseFloat(obj.getPrice()));
            stm.setFloat(7, Float.parseFloat(obj.getPriceCart()));

            // Thực thi câu lệnh và lấy kết quả trả về
            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stm.getGeneratedKeys();
                if (generatedKeys.next()) {
                    scheduleID = generatedKeys.getInt(1); // Lấy ScheduleID từ kết quả trả về
                }
            }
        } catch (Exception e) {
            System.out.println("insertBus: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception ex) {
                System.out.println("insertBus: " + ex.getMessage());
            }
        }

        return scheduleID; // Trả về ScheduleID
    }

    public int update2(Bus obj) {
        int n = 0;
        String sql = "UPDATE [dbo].[Bus]\n"
                    + "   SET [BusNumber] = ?\n"
                    + "      ,[Capacity] = ?\n"
                    + "      ,[Type] = ?\n"
                    + "      ,[Driver] = ?\n"
                    + "      ,[ImageUrl] = ?\n"
                    + "      ,[Price] = ?\n"
                    + "      ,[PriceCart] = ?\n"
                    + " WHERE BusID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            //  DataType is datatype of field; indexOf? start is 1

            pre.setString(1, obj.getBusNumber());
            pre.setString(2, obj.getCapacity());
            pre.setString(3, obj.getType());
            pre.setString(4, obj.getDriver());
            pre.setString(5, obj.getImageUrl());
            pre.setString(6, obj.getPrice());
            pre.setString(7, obj.getPriceCart());
            pre.setString(8, obj.getBusID());

            n = pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Bus getBusById(String id) {
        try {
            String strSQL = "select * from [Bus] where BusID = ? ";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String busid = String.valueOf(rs.getString(1));
                String busnumber = String.valueOf(rs.getString(2));
                String capacity = String.valueOf(rs.getString(3));
                String type = rs.getString(4);
                String driver = rs.getString(5);
                String imageurl = rs.getString(6);
                String price = rs.getString(7);
                String priceCart = rs.getString(8);
                Bus u = new Bus(busnumber, type, driver, busid, capacity, imageurl, price,priceCart);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getBus" + e.getMessage());
        }
        return null;
    }

    public ArrayList<Bus> getData(String sql) {
        ArrayList<Bus> list = new ArrayList<>();
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getString(1));
                String busnumber = rs.getString(2);
                String capacity = String.valueOf(rs.getString(3));
                String type = rs.getString(4);
                String driver = rs.getString(5);
                String imageUrl = rs.getString(6);
                String price = rs.getString(7);
                String priceCart = rs.getString(8);

                Bus u = new Bus(busnumber, type, driver, id, capacity, imageUrl, price,priceCart);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertBus" + e.getMessage());
        }
        return list;
    }

    public void update(Bus b) {
        try {
            String sql = "UPDATE [dbo].[Bus]\n"
                    + "   SET [BusNumber] = ?\n"
                    + "      ,[Capacity] = ?\n"
                    + "      ,[Type] = ?\n"
                    + "      ,[Driver] = ?\n"
                    + "      ,[ImageUrl] = ?\n"
                    + "      ,[Price] = ?\n"
                    + "      ,[PriceCart] = ?\n"
                    + " WHERE BusID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, b.getBusNumber());
            stm.setInt(2, Integer.parseInt(b.getCapacity()));
            stm.setString(3, b.getType());
            stm.setString(4, b.getDriver());
            stm.setString(5, b.getImageUrl());
            stm.setFloat(6, Float.parseFloat(b.getPrice()));
            stm.setFloat(7, Integer.parseInt(b.getPriceCart()));
            stm.setInt(8, Integer.parseInt(b.getBusID()));
            
            stm.execute();

        } catch (Exception e) {
            System.out.println("updateBus" + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            String strSQL = "delete from Bus where BusID=?";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();

        } catch (Exception e) {
            System.out.println("delete" + e.getMessage());
        }
    }

    public int delete1(String id) {
        int n = 0;
        String sql = "delete from [Bus] where BusID=?";
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
        DAOBus dao = new DAOBus();
//        ArrayList<Bus> list = dao.getData("select * from Bus where [Type] = 'Standard'");
//        for (Bus bus : list) {
//            float f = Float.parseFloat(bus.getPrice())+20;
//            System.out.println(f);
//        }
//Bus n1 = new Bus("BUS001", "Standard", "a", "1", "55", "/images/CarImages/bus001.png", "40");
//        int n = dao.update2(n1);
//        if (n != 0) {
//            System.out.println("ss");
//        }
//String = "2024-02-18 08:00:00.000";
//        System.out.println("");
    }

}
