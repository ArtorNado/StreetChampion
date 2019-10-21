package dbWorker.notificationsQuery;

import dbWorker.DBworker;
import players.PlayerBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NotificationsQuery {

    DBworker worker = new DBworker();

    public ArrayList getNotificationsId(int recipient){
        String query = "select id from notifications where idRecipient ='"+ recipient +"'";
        NotificationBean notificationBean = new NotificationBean();
        ArrayList idList = new ArrayList();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                idList.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    public Integer getNotificationId(int sender, int type){
        String query = "select id from notifications where idSender = '"+sender+"' AND type = '"+type+"'";
        NotificationBean notificationBean = new NotificationBean();
        ArrayList idList = new ArrayList();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationBean.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationBean.getId();
    }

    public Integer getRecipientId(int notificationId){
        String query = "select idRecipient from notifications where id ='"+ notificationId +"'";
        NotificationBean notificationBean = new NotificationBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationBean.setIdRecipient( resultSet.getInt("idRecipient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationBean.getIdRecipient();
    }

    public Integer getSendertId(int notificationId){
        String query = "select idSender from notifications where id ='"+ notificationId +"'";
        NotificationBean notificationBean = new NotificationBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationBean.setIdSender( resultSet.getInt("idSender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationBean.getIdSender();
    }



    public Integer getTypeNotification(int notificationId){
        String query = "select type from notifications where id ='"+ notificationId +"'";
        NotificationBean notificationBean = new NotificationBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationBean.setType( resultSet.getInt("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationBean.getType();
    }

    public ArrayList getIdNotificationType1(int idRecipient){
        ArrayList<Integer> idList = new ArrayList();
        String query = "select id from notifications where idRecipient ='"+ idRecipient +"'";
        NotificationBean notificationBean = new NotificationBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                idList.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    public void deleteNotification(int notId){
        String query = "DELETE FROM notifications WHERE id = '"+ notId+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
