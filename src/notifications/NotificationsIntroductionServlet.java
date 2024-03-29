package notifications;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;
import dbWorker.notificationsQuery.Notificaton;

import javax.management.Notification;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NotificationsIntroductionServlet")
public class NotificationsIntroductionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NotificationsQuery nQuery = new NotificationsQuery();
        Query query = new Query();
        ArrayList idList = new ArrayList();
        int captainId = (Integer) session.getAttribute("userId");
        int teamId = query.getTeamId(captainId);
        idList = nQuery.getIdNotificationType1((Integer)session.getAttribute("userId"));
        ArrayList<String> message = new ArrayList();
        for (int i = 0; i < idList.size(); i++) {
            message.add((nQuery.getSendertId((Integer)idList.get(i))).toString());
        }
        request.setAttribute("notificationsId", idList);
        request.setAttribute("message", message);
        request.setAttribute("teamId", teamId);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/notifications/notificationsIntroduction.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
