package teams.myTeam;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyTeamSquadServlet")
public class myTeamSquadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teamId = Integer.parseInt(request.getParameter("id"));
        System.out.println("teamIdd - "+ teamId);
        Query query = new Query();
        ArrayList players = new ArrayList();
        players = query.getAllPlayers(players, teamId);
        request.setAttribute("players", players);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/allPlayers.jsp")
                .forward(request, response);
    }
}
