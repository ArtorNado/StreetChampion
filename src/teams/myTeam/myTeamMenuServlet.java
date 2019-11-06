package teams.myTeam;

import dbWorker.Query;
import teams.teamInfo.TeamInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myTeamMenuServlet")
public class myTeamMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Query query = new Query();
        int id = (Integer) session.getAttribute("userId");
        int teamId = query.getTeam(id);
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        teamInfoBean.setId(teamId);
        request.setAttribute("teamInfoBean", teamInfoBean);
        request.setAttribute("teamId", teamId);
        if (query.checkTeamAdmin(id)) {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/teams/myTeamMenu/myTeamMenuAdmin.jsp")
                    .forward(request, response);
        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/teams/myTeamMenu/myTeamMenu.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
