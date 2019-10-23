import dbWorker.DBworker;
import dbWorker.Query;
import logInBean.LogInBean;
import players.PlayerBean;

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
        Cookies cookies = new Cookies();
        if ((request.getParameter("login").isEmpty()) || (request.getParameter("password")).isEmpty()) {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        String userPassword = query.getPassword(login);
        int userId = query.getUserId(login);
        String[] value = request.getParameterValues("checkBox");
        if (value != null) {
            if (value[0].equals("on")) {
                cookies.createCookies(request, response, login, password);

            }
        }
        LogInBean logInBean = new LogInBean(login, password);
        int age = query.getUserAge(login);
        String firstName = query.getUserFirstName(login);
        String secondName = query.getUserSecondName(login);
        double avarageRaiting = query.getUserAvarageRaiting(login);
        String teamName = query.getTeam(userId);
        PlayerBean playerBean = new PlayerBean(firstName, secondName, age, avarageRaiting, teamName);
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("userName", login);
        if ((login != null) && (query.searchUser(login)) && ((password.equals(userPassword)))) {
            request.setAttribute("teamName", teamName);
            request.setAttribute("userr", logInBean);
            request.setAttribute("userData", playerBean);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/profilePage/profile.jsp")
                    .forward(request, response);
        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
