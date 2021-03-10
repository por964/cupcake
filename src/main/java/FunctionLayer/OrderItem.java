package FunctionLayer;

public class OrderItem {
    private int itemID;
    private int topID;
    private int bottomID;
    private int quantity;
    private double price;

    public OrderItem(int itemID, int topID, int bottomID, int quantity, double price) {
        this.itemID = itemID;
        this.topID = topID;
        this.bottomID = bottomID;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public int getTopID() {
        return topID;
    }

    public int getBottomID() {
        return bottomID;
    }

    public void setBottomID(int bottomID) {
        this.bottomID = bottomID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}