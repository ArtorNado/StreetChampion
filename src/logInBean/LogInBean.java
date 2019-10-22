package logInBean;

import java.io.Serializable;

public class LogInBean implements Serializable {

    private String name;
    private String password;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public LogInBean(){
        this.name = "";
        this.password = "";
    }

    public LogInBean(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
