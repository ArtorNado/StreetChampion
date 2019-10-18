import dbWorker.DBworker;
import dbWorker.Query;
import logInBean.LogInBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Query query = new Query();
        if((request.getParameter("login").isEmpty())) {
            System.out.println("null");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        LogInBean logInBean = new LogInBean(request.getParameter("login"), request.getParameter("password"));
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        int userId = query.getUserId(logInBean.getName());
        session.setAttribute("userId", userId);
        session.setAttribute("userName", logInBean.getName());
        if((logInBean.getName() != null) && (query.searchUser(logInBean.getName()))) {
            request.setAttribute("userr", logInBean);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/profilePage/profile.jsp")
                    .forward(request, response);
        } else{
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
