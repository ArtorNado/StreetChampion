package dbWorker.notificationsQuery;

import java.util.ArrayList;

public class NotificationBean {

    private int id;
    private int type;
    private int idRecipient;
    private int idSender;

    public NotificationBean() {
    }

    public NotificationBean(int id, int type, int idRecipient, int idSender) {
        this.id = id;
        this.type = type;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }
}
