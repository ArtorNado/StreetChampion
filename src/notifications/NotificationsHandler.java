package notifications;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;
import dbWorker.notificationsQuery.Notificaton;



public class NotificationsHandler {
    NotificationsQuery nQuery = new NotificationsQuery();
    Query query = new Query();

    public Boolean haveNotifications(int userId) {
        if (nQuery.getNotificationsId(userId) != null) return true;
        else return false;
    }

    public Notificaton getNotificationsType1(Notificaton notification, int notificationId, int userId) {
        String sender = query.getUserName(userId);
        notification.setId(notificationId);
        notification.setText("Запрос на вступление в комнаду от игрока"+sender);
        return notification;
    }
}
