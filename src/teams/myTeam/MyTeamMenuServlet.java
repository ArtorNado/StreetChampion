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

@WebServlet(name = "MyTeamMenuServlet")
public class MyTeamMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("userId");
        MyTeamMenuDAO dao = new MyTeamMenuDAO(id);
        int teamId = dao.getTeamId();
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        teamInfoBean.setId(teamId);
        request.setAttribute("teamInfoBean", teamInfoBean);
        request.setAttribute("teamId", teamId);
        if (dao.checkTeamAdmin()) {
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
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
    }
}
