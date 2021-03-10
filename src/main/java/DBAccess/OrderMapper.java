package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderItem;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {


    public static ArrayList<Order> showAllOrders() throws LoginSampleException, ClassNotFoundException {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                int id = rs.getInt("orderID");
                int uid = rs.getInt("userID");
                double px = rs.getDouble("price");
                Timestamp time = rs.getTimestamp("timest");
                order = new Order(id, uid, px, time);
                orderList.add(order);
            }

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderList;
    }

    public static int lastOrderID() throws LoginSampleException {
        int orderID = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT MAX(orderID) as id FROM cupcake.orders";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                orderID = rs.getInt("id");
            }
            return orderID;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createOrder(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO cupcake.orders (userID, price) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getCustomerID());
            ps.setDouble(2, order.getPrice());

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void insertItems(int odaID, int top, int bottom, int qty) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO cupcake.items (orderID,topID, bottomID,quantity) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, odaID);
            ps.setInt(2, top);
            ps.setInt(3, bottom);
            ps.setInt(4, qty);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<OrderItem> customersOrder(int userID) throws LoginSampleException {
        //viser en bestemt kundes ordrer
        ArrayList<OrderItem> customersOrderList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "select items.itemID, items.topID, items.bottomID, " +
                    "items.quantity, orders.price from cupcake.orders inner join " +
                    "cupcake.items on orders.orderID=items.orderID where userID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "" + userID);
            ResultSet rs = ps.executeQuery();
            OrderItem oi = null;
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                int topID = rs.getInt("topID");
                int bottomID = rs.getInt("bottomID");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                oi = new OrderItem(itemID, topID, bottomID, quantity, price);
                customersOrderList.add(oi);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return customersOrderList;
    }


}
