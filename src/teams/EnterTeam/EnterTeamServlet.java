package teams.EnterTeam;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;
import teams.teamInfo.TeamInfoBean;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.SAAJResult;
import java.io.IOException;

@WebServlet(name = "EnterTeamServlet")
public class EnterTeamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        int userId = (Integer) session.getAttribute("userId");
        int teamId = Integer.parseInt(request.getParameter("name"));
        EnterTeamDAO dao = new EnterTeamDAO(userId, teamId);
        int captainId = dao.getTeamAdmin();
        String teamName = dao.getTeamName();
        TeamInfoBean teamInfoBean = new TeamInfoBean(teamName,teamId);
        request.setAttribute("team", teamInfoBean);
        if(dao.checkTeam()){
            getServletContext()
                    .getRequestDispatcher("/teamInfo.jsp")
                    .forward(request, response);
        } else{
            dao.createNotificationType1(captainId, userId);
        }
    }
}
