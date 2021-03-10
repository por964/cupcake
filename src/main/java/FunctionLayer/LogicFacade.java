package FunctionLayer;

import DBAccess.CupcakeMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createCustomer(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer", 0.00);
        UserMapper.createUser(user);
        return user;
    }

    public static User createEmp(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "employee");
        UserMapper.createUser(user);
        return user;
    }

    public static void updateBalance(int userID, double beloebTilIndsaettelse) {
        UserMapper.updateBalance(userID, beloebTilIndsaettelse);
    }

    public static ArrayList<Order> showAllOrders() throws LoginSampleException, ClassNotFoundException {
        return OrderMapper.showAllOrders();
    }

    public static ArrayList<Topping> getTops() throws ClassNotFoundException, LoginSampleException {
        return CupcakeMapper.getTops();
    }

    public static ArrayList<Bottom> getBottoms() throws LoginSampleException {
        return CupcakeMapper.getBottoms();
    }

    public static ArrayList<User> showAllCustomers() throws LoginSampleException {
        return UserMapper.showAllCustomers();

    }

    public static ArrayList<OrderItem> customersOrder(int userID) throws SQLException, LoginSampleException {
        return OrderMapper.customersOrder(userID);
    }
}