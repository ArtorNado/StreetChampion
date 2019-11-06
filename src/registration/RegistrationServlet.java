package registration;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/registration/registration.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationDAO dao = new RegistrationDAO();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        if (login.isEmpty() || password.isEmpty() || dao.searchUser(login)  || firstName.isEmpty() || secondName.isEmpty() || request.getParameter("age") == null) {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/registration/registration.jsp")
                    .forward(request, response);
        } else {
            int age = Integer.parseInt(request.getParameter("age"));
            dao.createNewUser(login, password, firstName, secondName, age);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
    }
}
