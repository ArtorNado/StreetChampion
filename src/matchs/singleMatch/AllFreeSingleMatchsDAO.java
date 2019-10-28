package matchs.singleMatch;

import dbWorker.Query;
import dbWorker.matchQuery.MatchQuery;
import matchs.MatchBean;

import java.util.ArrayList;

public class AllFreeSingleMatchsDAO {
    public ArrayList<MatchBean> getAllFreeSingleMatches(ArrayList<MatchBean> freeSingleMatchs){
        /*MatchQuery matchQuery = new MatchQuery();
        freeSingleMatchs = matchQuery.getFreeSingleMatchs(freeSingleMatchs);*/
        MatchQuery matchQuery = new MatchQuery();
        freeSingleMatchs = matchQuery.getFreeSingleMatchs();
        return freeSingleMatchs;
    }
}
