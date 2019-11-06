package teams.teamInfo;

import dbWorker.Query;

public class TeamInfoDAO {

    private String teamName;
    Query query = new Query();

    public TeamInfoDAO(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamId(){
        int teamId = query.getTeamId(teamName);
        return teamId;
    }
}
