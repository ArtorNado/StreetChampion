package players;

import dbWorker.Query;

public class PlayerInfoDAO {

    Query query = new Query();

    public Integer getAge(String login){
        int age = query.getUserAge(login);
        return age;
    }

    public String getFirstName(String login){
        String firstName = query.getUserFirstName(login);
        return firstName;
    }

    public String getSecondName(String login){
        String secondName = query.getUserSecondName(login);
        return secondName;
    }

    public Double getAvarageRaiting(String login){
        double avarageRaiting = query.getUserAvarageRaiting(login);
        return avarageRaiting;
    }
}
