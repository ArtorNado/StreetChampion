package teams.myTeam;

import dbWorker.Query;

import java.util.ArrayList;

public class MyTeamSquadDAO {

    private int teamId;
    Query query = new Query();

    public MyTeamSquadDAO(int teamId) {
        this.teamId = teamId;
    }

    public ArrayList getAllPlayers(ArrayList list){
        list = query.getAllPlayers(list, teamId);
        return list;
    }
}
