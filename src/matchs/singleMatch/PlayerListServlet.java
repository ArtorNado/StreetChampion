package matchs.singleMatch;

import matchs.MatchBean;
import players.PlayerBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PlayerListServlet")
public class PlayerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matchId = Integer.parseInt(request.getParameter("id"));
        PlayerListDAO playerListDAO = new PlayerListDAO();
        ArrayList<PlayerBean> pbArray = new ArrayList<>();
        pbArray = playerListDAO.getAllPlayers(pbArray, matchId);
        request.setAttribute("pbArray", pbArray);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/playersList.jsp")
                .forward(request, response);
    }
}
