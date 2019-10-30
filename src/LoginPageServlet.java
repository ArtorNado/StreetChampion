import logInBean.LogInBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


@WebServlet("/loginpage")
public class LoginPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        Cookies cookies = new Cookies();
        String login = "";
        String password = "";
        Boolean haveCookey;
        haveCookey = cookies.checkCookies(request,response,login,password);
        if (haveCookey) {
            login = (String) request.getAttribute("loginCookies");
            password = (String) request.getAttribute("passwordCookies");
        }
        LogInBean logInBean = new LogInBean(login,password);
        request.setAttribute("cookies", logInBean);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                .forward(request, response);

    }
}
