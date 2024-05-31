/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Review;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nmngh
 */
public class DAOReview extends DBConnect {

    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec

    public void insert(Review obj) {

        String sql = "insert into Review( UserID,Rating, Comment) values( ?,?,?)";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, obj.getUserID());
            stm.setString(2, obj.getRating());
            stm.setString(3, obj.getComment());
            stm.execute();
        } catch (Exception e) {
            System.out.println("insertReview" + e.getMessage());
        }
    }

    public ArrayList<Review> getData() {
        ArrayList<Review> list = new ArrayList<>();
        try {
            String sql = "select * from Review";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String user = rs.getString(2);
                String rating = rs.getString(3);
                String comment = rs.getString(4);

                Review u = new Review(id, user, rating, comment);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("insertReview" + e.getMessage());
        }
        return list;
    }

    public void update(Review b) {
        try {
            String sql = "update  Review set UserID =?,Rating=?,Comment=?"
                    + "where ReviewID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, b.getUserID());
            stm.setString(2, b.getRating());
            stm.setString(3, b.getComment());
            stm.setString(4, b.getReviewID());

            stm.execute();

        } catch (Exception e) {
            System.out.println("updateReview" + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            String strSQL = "delete from Review where ReviewID=?";
            stm = conn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();

        } catch (Exception e) {
            System.out.println("delete" + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
