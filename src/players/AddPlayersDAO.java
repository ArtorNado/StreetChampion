package players;

import dbWorker.Query;

import java.util.ArrayList;

public class AddPlayersDAO {

    Query query = new Query();

    public ArrayList getAllPlayers(ArrayList list, int id){
        list = query.getAllPlayers(list, id);
        return list;
    }
}
