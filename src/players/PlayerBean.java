package players;

import java.io.Serializable;

public class PlayerBean implements Serializable {

    private String name;
    private String firstName;
    private String secondName;
    private String teamName;
    private int id;
    private int raiting;
    private int curVoice;
    private int age;
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

    public PlayerBean(String name, String firstName, String secondName, int age, double avarageRaiting){
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.avarageRaiting = avarageRaiting;
    }

    public PlayerBean(String firstName, String secondName, int age, double avarageRaiting){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.avarageRaiting = avarageRaiting;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
