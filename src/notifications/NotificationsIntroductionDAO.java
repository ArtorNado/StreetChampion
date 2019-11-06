package notifications;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;

import java.util.ArrayList;

public class NotificationsIntroductionDAO {

    Query query = new Query();
    NotificationsQuery nQuery = new NotificationsQuery();

    public Integer getTeamId(int captainId) {
        int teamId = query.getTeamId(captainId);
        return teamId;
    }

    public ArrayList getNotificType1(ArrayList list, int id){
        list = nQuery.getIdNotificationType1(id);
        return list;
    }

    public Integer getSenderId(int notificationId){
        int id = nQuery.getSendertId(notificationId);
        return id;
    }
}
