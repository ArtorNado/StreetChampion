package tourmaments.createTourmament;

import dbWorker.Query;
import dbWorker.matchQuery.MatchQuery;
import dbWorker.tourmamentsQuery.TourmamentsQuery;

public class CreateTourmamentDAO {

    public void createTourmament(String name, int maxTeams, String description, int adminId){
        TourmamentsQuery tourmamentsQuery = new TourmamentsQuery();
        Query query = new Query();
        tourmamentsQuery.createTourmament(name, maxTeams, description,adminId);
        int tourmamentId = tourmamentsQuery.getTourmamentId(adminId);
        int teamId = query.getTeamId(adminId);
        tourmamentsQuery.addTeam(tourmamentId, teamId);
        tourmamentsQuery.subtractFreePlaces(tourmamentId);
    }
}
