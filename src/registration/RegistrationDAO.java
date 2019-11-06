package registration;

import dbWorker.Query;

public class RegistrationDAO {

    Query query = new Query();

    public void createNewUser(String login, String password, String firstName, String secondName, int age){
        query.createNewUser(login, password, firstName, secondName, age);
    }

    public Boolean searchUser(String login){
        Boolean answer = query.searchUser(login);
        return answer;
    }
}
