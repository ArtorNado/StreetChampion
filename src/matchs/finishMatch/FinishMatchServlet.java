package matchs.finishMatch;

import matchs.MatchBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FinishMatchServlet")
public class FinishMatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/finishedMyMatch.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        int matchId = Integer.parseInt(request.getParameter("id"));
        FinishMatchDAO dao = new FinishMatchDAO();
        dao.finishMatch(matchId);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/matchMenu.jsp")
                .forward(request, response);
    }
}
