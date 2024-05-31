/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Locations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nmngh
 */
public class DAOLocation extends DBConnect{
    
    PreparedStatement stm;
    ResultSet rs; //Lưu trữ và xử lý dữ liệu đc lấy về từ selec
    
    public void insert(Locations obj) {
        
            String sql = "insert into Locations(LocationName,Address) values(?,?)";
            
           try{
               stm = conn.prepareStatement(sql);
               stm.setString(1, obj.getLocationName());
               stm.setString(2, obj.getAddress());
               stm.execute();
           }catch (Exception e){
                System.out.println("insertLocations" + e.getMessage());
           }
        }
   public ArrayList<Locations> getData(){
       ArrayList<Locations> list = new ArrayList<>();
       PreparedStatement st;
       try{
           String sql = "select * from Locations";
           stm = conn.prepareStatement(sql);
           rs = stm.executeQuery();
           while(rs.next()){
               String id = rs.getString(1);
               String name= rs.getString(2);
               String address = rs.getString(3);
            
               
              Locations u = new Locations(id, name, address);
               list.add(u);
           }
       }catch (Exception e){
            System.out.println("insertLocations" + e.getMessage());
       }
       return list;
   }
    
    public void update( Locations b){
        try{
        String sql = "update  Locations set LocationName =?,Address=?"
                    +"where LocationID = ?";
                stm = conn.prepareStatement(sql);
              stm.setString(1, b.getLocationName());
              stm.setString(2, b.getAddress());
              stm.setString(3, b.getLocationID());
              
              stm.execute();
              
        }catch (Exception e){
             System.out.println("updateLocations" + e.getMessage());
        }
    }
    public void delete(String id) {
        try {
            String strSQL = "delete from Locations where LocationID=?";
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
