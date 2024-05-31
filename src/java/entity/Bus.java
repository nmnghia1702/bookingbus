/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nmngh
 */
public class Bus {

    String BusNumber, Type, Driver,BusID, Capacity, ImageUrl, Price, PriceCart;

    public Bus() {
    }

    public Bus(String BusNumber, String Type, String Driver, String BusID, String Capacity, String ImageUrl, String Price, String PriceCart) {
        this.BusNumber = BusNumber;
        this.Type = Type;
        this.Driver = Driver;
        this.BusID = BusID;
        this.Capacity = Capacity;
        this.ImageUrl = ImageUrl;
        this.Price = Price;
        this.PriceCart = PriceCart;
    }

    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String BusNumber) {
        this.BusNumber = BusNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String BusID) {
        this.BusID = BusID;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getPriceCart() {
        return PriceCart;
    }

    public void setPriceCart(String PriceCart) {
        this.PriceCart = PriceCart;
    }

    
    
}
