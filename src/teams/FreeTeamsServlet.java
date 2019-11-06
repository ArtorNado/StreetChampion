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
import java.util.List;

@WebServlet(name = "FreeTeamsServlet")
public class FreeTeamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Query query = new Query();
        ArrayList freeTeams = new ArrayList();
        freeTeams = query.getFreeTeam(freeTeams);
        request.setAttribute("freeTeams", freeTeams);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/teams/freeTeams.jsp")
                .forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
