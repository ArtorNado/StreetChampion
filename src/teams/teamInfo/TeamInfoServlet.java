package teams.teamInfo;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeamInfoServlet")
public class TeamInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameOfTeam = request.getParameter("name");
        TeamInfoDAO dao = new TeamInfoDAO(nameOfTeam);
        int id = dao.getTeamId();
        TeamInfoBean teamInfoBean = new TeamInfoBean(nameOfTeam,id);
        request.setAttribute("team", teamInfoBean);
        getServletContext()
                .getRequestDispatcher("/teamInfo.jsp")
                .forward(request, response);
    }
}
