import com.sun.org.apache.xpath.internal.operations.Bool;
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
        HttpSession session = request.getSession();
        Query query = new Query();
        System.out.println(session.getAttribute("userId") + " id");
        if(session.getAttribute("userId") != null){
            LogInBean logInBean = new LogInBean((String) session.getAttribute("userName"), (String) session.getAttribute("userPassword"));
            ProfileDAO dao = new ProfileDAO((String) session.getAttribute("userName"), (Integer) session.getAttribute("userId"));
            int age = dao.getUserAge();
            String firstName = dao.getFirstName();
            String secondName = dao.getSecondName();
            double avarageRaiting = dao.getAvarageRaiting();
            int teamId = dao.getTeamId();
            PlayerBean playerBean = new PlayerBean(firstName, secondName, age, avarageRaiting);
            int check = 1;
            if( query.checkTeam((Integer)session.getAttribute("userId")) == null) {
                check = -1;
            }
            request.setAttribute("teamId", teamId);
            request.setAttribute("check", check);
            request.setAttribute("userr", logInBean);
            request.setAttribute("userData", playerBean);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/profilePage/profile.jsp")
                    .forward(request, response);
        }
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
        ProfileDAO dao = new ProfileDAO(login, userId);
        int age = dao.getUserAge();
        String firstName = dao.getFirstName();
        String secondName = dao.getSecondName();
        double avarageRaiting = dao.getAvarageRaiting();
        int teamId = dao.getTeamId();
        PlayerBean playerBean = new PlayerBean(firstName, secondName, age, avarageRaiting);
        int check = 1;
        if( query.checkTeam(userId) == null) {
             check = -1;
        }
        session.setAttribute("userId", userId);
        session.setAttribute("userPassword", userPassword);
        session.setAttribute("userName", login);
        if ((login != null) && (query.searchUser(login)) && ((password.equals(userPassword)))) {
            request.setAttribute("teamId", teamId);
            request.setAttribute("check", check);
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
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
    }
}
