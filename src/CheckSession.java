
import dbWorker.Query;

import javax.servlet.http.HttpSession;

public class CheckSession {

    public boolean checkSession(String login, String password){
        Query query = new Query();
        if(query.searchUser(login)) {
            return true;
        } else return false;
    }
}
