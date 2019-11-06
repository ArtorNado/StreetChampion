package teams;

import dbWorker.Query;

import java.util.ArrayList;

public class FreeTeamsDAO {

    Query query = new Query();

    public ArrayList getAllFreeTeams(ArrayList list){
        list = query.getFreeTeam(list);
        return list;
    }
}
