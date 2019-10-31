package matchs.finishMatch;

import dbWorker.matchQuery.MatchQuery;
import matchs.MatchBean;

import java.util.ArrayList;

public class FinishMatchDAO {

    MatchQuery matchQuery = new MatchQuery();

    public boolean checkCreatedMatch(int userId){
        Boolean answer = false;
        answer = matchQuery.checkCreratedMatch(userId);
        return answer;
    }

    public ArrayList<MatchBean> getAllCreatedMatch(ArrayList<MatchBean> allCreatedMatch, int userId){
        allCreatedMatch = matchQuery.getAllCreatedMatch(userId);
        return allCreatedMatch;
    }

    public void finishMatch(int matchId){
        matchQuery.finishMatch(matchId);
    }
}
