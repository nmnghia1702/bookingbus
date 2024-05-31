/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nmngh
 */
public class User {

    public String Username, Role, Password, PhoneNumber,UserID, LocationID; 

    public User() {
    }

    
    public User(String Username, String Role, String Password, String PhoneNumber, String UserID, String LocationID) {
        this.Username = Username;
        this.Role = Role;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
        this.UserID = UserID;
        this.LocationID = LocationID;
    }
    @Override
    public String toString(){
        return "User{"+"Userid" + UserID + ", username" + Username  + ", password" + Password+ ", locationID" + LocationID+ ", role" + Role+ ", phoneNumber" + PhoneNumber+'}';
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    
   
    
}
