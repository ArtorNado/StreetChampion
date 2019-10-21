package notifications;

import addOrDeleteUser.AddUserInTeam;
import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrueAnswerServlet")
public class TrueAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NotificationsQuery nQuery = new NotificationsQuery();
        Query query = new Query();
        DeleteNotifications deleteNotifications = new DeleteNotifications();
        AddUserInTeam addUserInTeam = new AddUserInTeam();
        int id = Integer.parseInt(request.getParameter("id"));
        int teamId = Integer.parseInt(request.getParameter("teamid"));
        int type = Integer.parseInt(request.getParameter("type"));
        int notId = nQuery.getNotificationId(id,type);
        addUserInTeam.addUser(id, teamId);
        deleteNotifications.deleteNotificationT1(notId);
    }
}
