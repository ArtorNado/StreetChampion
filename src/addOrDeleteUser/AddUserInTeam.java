package addOrDeleteUser;

import dbWorker.Query;

public class AddUserInTeam {

    public void addUser(int id, int teamId){
        Query query = new Query();
        query.addUserInTeam(id,teamId);
    }
}
