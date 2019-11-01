package teams.teamInfo;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamInfoBean implements Serializable {

    private String name;
    private int id;
    private double raiting;

    public TeamInfoBean(){
        this.name = "";
        this.id = 0;
    }

    public TeamInfoBean(String name, int id){
        this.name = name;
        this.id = id;
    }
    public TeamInfoBean(String name, int id, double raiting){
        this.name = name;
        this.id = id;
        this.raiting = raiting;
    }

    public double getRaiting() {
        return raiting;
    }

    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
