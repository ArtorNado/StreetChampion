package dbWorker.notificationsQuery;

public class Notificaton {
    private String text;
    private int id;

    public Notificaton() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
