package teams.myTeam;

import dbWorker.Query;

public class MyTeamMenuDAO {

    private int userId;
    Query query = new Query();

    public MyTeamMenuDAO(int userId) {
        this.userId = userId;
    }

    public Integer getTeamId(){
        int teamId = query.getTeam(userId);
        return teamId;
    }

    public Boolean checkTeamAdmin(){
        Boolean answer = query.checkTeamAdmin(userId);
        return answer;
    }
}
