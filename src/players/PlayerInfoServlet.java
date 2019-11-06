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
        String login = request.getParameter("name");
        PlayerInfoDAO dao = new PlayerInfoDAO();
        int age = dao.getAge(login);
        String firstName = dao.getFirstName(login);
        String secondName = dao.getSecondName(login);
        double avarageRaiting = dao.getAvarageRaiting(login);
        PlayerBean playerBean = new PlayerBean(login, firstName, secondName, age, avarageRaiting);
        request.setAttribute("playerBean", playerBean);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/playerInfo.jsp")
                .forward(request, response);
    }
}
