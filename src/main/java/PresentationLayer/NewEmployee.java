
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * Denne klasse henter værdier/parametre fra index.jsp og opretter derefter en ny bruger v.hj.af metoden createEmp fra
 * usermapper via LogicFacade
 * @since 2020-03-13
 */

public class NewEmployee extends Command {
    /**
     * @param request  værdier fra servlet
     * @param response værdier til session
     * @return customerpage ller employeepage afhængigt af brugertype
     * @throws LoginSampleException
     */

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createEmp(email, password1);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }
}