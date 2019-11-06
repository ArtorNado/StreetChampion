package players;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PlayerInfoServlet")
public class PlayerInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Query query = new Query();
        String login = request.getParameter("name");
        int age = query.getUserAge(login);
        String firstName = query.getUserFirstName(login);
        String secondName = query.getUserSecondName(login);
        double avarageRaiting = query.getUserAvarageRaiting(login);
        PlayerBean playerBean = new PlayerBean(login, firstName, secondName, age, avarageRaiting);
        request.setAttribute("playerBean", playerBean);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/playerInfo.jsp")
                .forward(request, response);
    }
}
