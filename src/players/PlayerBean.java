package players;

import java.io.Serializable;

public class PlayerBean implements Serializable {

    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public PlayerBean(){
        this.name = "";
    }

    public PlayerBean(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
