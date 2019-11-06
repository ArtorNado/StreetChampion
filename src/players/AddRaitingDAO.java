package players;

import dbWorker.Query;

public class AddRaitingDAO {

    Query query = new Query();

    public Integer getuserRaiting(String name){
        int raiting = query.getUserRaiting(name);
        return raiting;
    }

    public Integer getCurVoice(String name){
        int curVoice = query.getUserCurVoice(name);
        return curVoice;
    }

    public Double getAvarageRaiting(String name){
        double avarage = query.getUserAvarageRaiting(name);
        return avarage;
    }
}
