package matchs.createMatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateMatchServlet")
public class CreateMatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/createMatch.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateMatchDAO createMatchDAO = new CreateMatchDAO();
        HttpSession session = request.getSession();
        String description = request.getParameter("description");
        int curPlayers = Integer.parseInt(request.getParameter("curPlayers"));
        int createrId =(Integer) session.getAttribute("userId");
        createMatchDAO.createMatch(curPlayers,description,createrId);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/matchMenu.jsp")
                .forward(request, response);
    }
}
