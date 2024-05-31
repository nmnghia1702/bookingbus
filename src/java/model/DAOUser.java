/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.User;
import jakarta.servlet.http.HttpSession;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nmngh
 */
public class DAOUser extends DBConnect {

    //DAO Database Access Object
    //Service: insert, update, delete, select
    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec

    public void insert(User obj) {

        String sql = "insert into Users(Username,Password,Role,LocationID,PhoneNumber) values(?,?,?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, obj.getUsername());
            stm.setString(2, obj.getPassword());
            stm.setString(3, obj.getRole());
            stm.setInt(4, Integer.parseInt(obj.getLocationID()));
            stm.setString(5, obj.getPhoneNumber());

            stm.execute();
        } catch (Exception e) {
            System.out.println("insertUser" + e.getMessage());
        }
    }

    public ArrayList<User> getData() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select * from Users";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getString(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String role = rs.getString(4);
                String phone = rs.getString(5);
                String locationid = String.valueOf(rs.getString(6));

                User u = new User(username, role, password, phone, id, locationid);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertUser" + e.getMessage());
        }
        return list;
    }

    public int update2(User obj) {
        int n = 0;
        String sql = "update  Users set Username =?,Password=?,Role=?,LocationID=?,PhoneNumber = ? "
                + "where UserID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            //  DataType is datatype of field; indexOf? start is 1

            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getRole());
            pre.setString(4, obj.getLocationID());
            pre.setString(5, obj.getPhoneNumber());
            pre.setString(6, obj.getUserID());

            n = pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public User getUserById(String id1) {
        try {
            String strSQL = "select * from Users where UserID = ? ";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id1);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String role = rs.getString(4);
                String phonenumber = rs.getString(5);
                String locationid = rs.getString(6);

                User u = new User(name, role, pass, phonenumber, id, locationid);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getUsers" + e.getMessage());
        }
        return null;
    }

    public void update(User b) {
        try {
            String sql = "update  Users set Username =?,Password=?,Role=?,LocationID=?,PhoneNumber = ? "
                    + "where UserID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, b.getUsername());
            stm.setString(2, b.getPassword());
            stm.setString(3, b.getRole());
            stm.setString(4, b.getLocationID());
            stm.setString(5, b.getPhoneNumber());
            stm.setString(6, b.getUserID());

            stm.execute();

        } catch (Exception e) {
            System.out.println("updateUser" + e.getMessage());
        }
    }

    public int delete(String id) {
        int n = 0;
        String sql = "delete from Users where UserID=?";
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

    public User check(String username, String password) {
        String strSQL = "select * from Users where Username=? and Password=?";
        try {
            stm = conn.prepareStatement(strSQL);
            //Xử lý thông tin
            stm.setString(1, username);
            stm.setString(2, password);

            rs = stm.executeQuery();
            if (rs.next()) {
                String id = String.valueOf(rs.getString(1));
                String us = String.valueOf(rs.getString(2));
                String ps = String.valueOf(rs.getString(3));
                String role = rs.getString(4);
                String locationid = String.valueOf(rs.getString(5));
                String phone = rs.getString(6);

                User u = new User(us, role, ps, phone, id, locationid);
                return u;
            }

        } catch (Exception e) {
            System.out.println("checkUser" + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        DAOUser dao = new DAOUser();
        User u = dao.check("user1", "password1");
        System.out.println(u.getUsername());
    }

}
