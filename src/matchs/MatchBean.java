package matchs;

public class MatchBean {
    private String info;
    private int curPlayers;
    private int freePlaces;
    private int id;
    private String data;
    private int players;

    public MatchBean(){
    }

    public MatchBean(String info, int curPlayers, int freePlaces, int id, String data) {
        this.info = info;
        this.curPlayers = curPlayers;
        this.freePlaces = freePlaces;
        this.id = id;
        this.data = data;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getDataTime() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCurPlayers() {
        return curPlayers;
    }

    public void setCurPlayers(int curPlayers) {
        this.curPlayers = curPlayers;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }
}
