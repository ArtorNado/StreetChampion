package players;

import dbWorker.Query;

public class UpdateRaiting {

    public void updateRaiting(String name, int raiting) {
        Query query = new Query();
        int curVoice = query.getUserCurVoice(name) +1;
        int oldRaiting = query.getUserRaiting(name);
        int newRaiting = oldRaiting+raiting;
        double avarageRaiting = (double) (oldRaiting+raiting)/curVoice;
        query.setAvarageRaiting(name, avarageRaiting);
        query.setRaiting(name, newRaiting);
        query.setCurVoice(name, curVoice);
    }
}
