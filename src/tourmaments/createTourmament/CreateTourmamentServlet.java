package tourmaments.createTourmament;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateTourmamentServlet")
public class CreateTourmamentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/tourmaments/createTourmament.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        CreateTourmamentDAO dao = new CreateTourmamentDAO();
        String description = request.getParameter("description");
        String name = request.getParameter("name");
        int maxTeams = Integer.parseInt(request.getParameter("maxTeams"));
        int adminId =(Integer) session.getAttribute("userId");
        dao.createTourmament(name, maxTeams, description, adminId);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/tourmaments/tourmamentsMenu.jsp")
                .forward(request, response);
    }
}
