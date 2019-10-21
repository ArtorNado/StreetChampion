package notifications;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;

public class DeleteNotifications {

    public void deleteNotificationT1(int notId){
        NotificationsQuery nQuery = new NotificationsQuery();
        nQuery.deleteNotification(notId);
    }
}
