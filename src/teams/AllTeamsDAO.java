package teams;

import dbWorker.Query;

import java.util.ArrayList;

public class AllTeamsDAO {

    Query query = new Query();

    public ArrayList getAllTeams(ArrayList list){
        list = query.getAllTeam(list);
        return list;
    }
}
