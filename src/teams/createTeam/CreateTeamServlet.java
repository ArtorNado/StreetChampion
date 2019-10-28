package teams.createTeam;

import dbWorker.Query;
import teams.teamInfo.TeamInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateTeamServlet")
public class CreateTeamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/teams/createTeam.jsp")
                    .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("nameOfNewTeam").isEmpty()){
            System.out.println("null");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/teams/createTeam.jsp")
                    .forward(request, response);
        }
        Query query = new Query();
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");
        String nameOfNewTeam = request.getParameter("nameOfNewTeam");
        query.createNewTeam(nameOfNewTeam, userId);
        /*query.setTeamAdmin(userName, query.getTeamId(nameOfNewTeam));*/
    }
}
