package matchs.createMatch;

import dbWorker.matchQuery.MatchQuery;
import matchs.MatchBean;

import java.util.ArrayList;

public class CreateMatchDAO {
    public void createMatch(int curPlayers, String description, int createrId){
        MatchQuery matchQuery = new MatchQuery();
        matchQuery.createMatch(curPlayers, description, createrId);
        int matchId = matchQuery.getMatchId(createrId);
        matchQuery.addPlayer(matchId, createrId);
        matchQuery.subtractFreePlaces(matchId);
    }
}
