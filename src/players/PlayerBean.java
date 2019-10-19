package players;

import java.io.Serializable;

public class PlayerBean implements Serializable {

    private String name;
    private int id;
    private int raiting;
    private int curVoice;
    private double avarageRaiting;

    public PlayerBean(){

    }

    public PlayerBean(String name){
        this.name = name;
    }

    public PlayerBean(String name, int raiting, int curVoice, double avarageRaiting){
        this.name = name;
        this.raiting = raiting;
        this.curVoice = curVoice;
        this.avarageRaiting = avarageRaiting;
    }

    public double getAvarageRaiting() {
        return avarageRaiting;
    }

    public void setAvarageRaiting(double avarageRaiting) {
        this.avarageRaiting = avarageRaiting;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getCurVoice() {
        return curVoice;
    }

    public void setCurVoice(int curVoice) {
        this.curVoice = curVoice;
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
