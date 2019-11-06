package players;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AllPlayersServlet")
public class AllPlayersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddPlayersDAO dao = new AddPlayersDAO();
        int id = Integer.parseInt(request.getParameter("name"));
        ArrayList players = new ArrayList();
        players = dao.getAllPlayers(players, id);
        request.setAttribute("players", players);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/allPlayers.jsp")
                .forward(request, response);
    }
}
