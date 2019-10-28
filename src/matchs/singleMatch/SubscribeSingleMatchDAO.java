package matchs.singleMatch;

import com.sun.org.apache.xpath.internal.operations.Bool;
import dbWorker.matchQuery.MatchQuery;

public class SubscribeSingleMatchDAO {

    public Boolean addUser(int matchId, int userId){
        MatchQuery matchQuery = new MatchQuery();
        Boolean answer = false;
        // Убрать проверку последнего матча и добавить проверку по кол-ву мест
        if(matchQuery.getFreePlaces(matchId) == 0 || !matchQuery.checkMatch(userId)){
            answer = false;
        } else {
            matchQuery.addPlayer(matchId, userId);
            matchQuery.subtractFreePlaces(matchId);
            answer = true;
        }
        System.out.println(answer);
        return answer;
    }
}
