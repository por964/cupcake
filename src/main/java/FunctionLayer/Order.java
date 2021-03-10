package FunctionLayer;

import java.sql.Timestamp;
import java.util.List;

public class Order {

    private int ID;
    private int customerID;
    private double price;
    private Timestamp time;
    private List<Item> items;

    public Order(int ID, int customerID, double price, Timestamp time) {
        this.ID = ID;
        this.customerID = customerID;
        this.price = price;
        this.time = time;
    }

    public Order(int customerID, double price) {
        this.customerID = customerID;
        this.price = price;
    }


    public int getID() {
        return ID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}