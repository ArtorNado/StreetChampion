package teams;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AllTeamsServlet")
public class AllTeamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllTeamsDAO dao = new AllTeamsDAO();
        ArrayList teams = new ArrayList();
        teams = dao.getAllTeams(teams);
        request.setAttribute("teams", teams);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/teams/allTeams.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
