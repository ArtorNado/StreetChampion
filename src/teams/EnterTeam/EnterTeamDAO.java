package teams.EnterTeam;

import dbWorker.Query;
import dbWorker.notificationsQuery.NotificationsQuery;

public class EnterTeamDAO {

    private int userId;
    private int teamId;

    Query query = new Query();
    NotificationsQuery nQuery = new NotificationsQuery();

    public EnterTeamDAO(int userId, int teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }

    public String getTeamName(){
        String teamName = query.getTeamName(teamId);
        return teamName;
    }

    public Integer getTeamAdmin(){
        int adminId = query.getTeamAdmin(teamId);
        return adminId;
    }

    public Boolean checkTeam(){
        Boolean answer = query.checkTeam(userId);
        return answer;
    }

    public void createNotificationType1(int captainId, int user){
        nQuery.createNotificationType1(captainId,user);
    }

}
