package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomersOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, LoginSampleException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        LogicFacade.customersOrder(userID);
        HttpSession session = request.getSession();
        ArrayList<OrderItem> customersOrderList = null;
        customersOrderList = LogicFacade.customersOrder(userID);
        request.setAttribute("meddelelse", "Kunden med id: " + userID + " har følgende ordrer: ");
        request.setAttribute("customersOrderList", customersOrderList);
        return "customersOrder";
    }
}