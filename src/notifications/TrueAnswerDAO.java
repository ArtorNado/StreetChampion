package notifications;

import dbWorker.notificationsQuery.NotificationsQuery;

public class TrueAnswerDAO {

    NotificationsQuery nQuery = new NotificationsQuery();

    public Integer getNotifId(int id, int type){
        int notId = nQuery.getNotificationId(id,type);
        return notId;
    }
}
