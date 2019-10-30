package teams.createTeam;

import dbWorker.Query;

public class CreateTeamDAO {
    public void createTeam(int userId, String nameOfNewTeam){
        Query query = new Query();
        query.createNewTeam(nameOfNewTeam, userId);
        int teamId = query.getTeamId(nameOfNewTeam);
        query.addUserInTeam(userId, teamId);
    }
}
