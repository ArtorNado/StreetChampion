package matchs.singleMatch;

import dbWorker.matchQuery.MatchQuery;
import matchs.MatchBean;
import players.PlayerBean;

import java.util.ArrayList;

public class PlayerListDAO {
    public ArrayList<PlayerBean> getAllPlayers(ArrayList<PlayerBean> playerList, int matchId){
        MatchQuery matchQuery = new MatchQuery();
        playerList = matchQuery.getPlayerList(matchId);
        return playerList;
    }
}
