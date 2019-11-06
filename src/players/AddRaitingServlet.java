package players;

import dbWorker.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddRaitingServlet")
public class AddRaitingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddRaitingDAO dao = new AddRaitingDAO();
        String name = request.getParameter("name");
        int rait = Integer.parseInt(request.getParameter("raitingValue"));
        UpdateRaiting updateRaiting = new UpdateRaiting();
        updateRaiting.updateRaiting(name, rait);
        int raiting = dao.getuserRaiting(name);
        int curVoice = dao.getCurVoice(name);
        double avarageRaiting = dao.getAvarageRaiting(name);
        PlayerBean playerBean = new PlayerBean(name, raiting, curVoice, avarageRaiting);
        request.setAttribute("playerBean", playerBean);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/players/playerInfo.jsp")
                .forward(request, response);
    }
}
