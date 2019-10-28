package matchs.singleMatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SubscribeSingleMatchServlet")
public class SubscribeSingleMatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubscribeSingleMatchDAO dao = new SubscribeSingleMatchDAO();
        HttpSession session = request.getSession();
        int matchId = Integer.parseInt(request.getParameter("id"));
        int userId = (Integer) session.getAttribute("userId");
        Boolean answer = dao.addUser(matchId, userId);
        if (answer){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/mainMenu/mainMenu.jsp")
                    .forward(request, response);
        } else{
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/match/freeSingleMatchList.jsp")
                    .forward(request, response);
        }
    }
}
