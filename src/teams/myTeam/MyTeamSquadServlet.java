package teams.myTeam;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyTeamSquadServlet")
public class MyTeamSquadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        int teamId = Integer.parseInt(request.getParameter("id"));
        MyTeamSquadDAO dao = new MyTeamSquadDAO(teamId);
        ArrayList players = new ArrayList();
        players = dao.getAllPlayers(players);
        request.setAttribute("players", players);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/allPlayers.jsp")
                .forward(request, response);
    }
}
