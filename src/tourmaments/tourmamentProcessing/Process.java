package tourmaments.tourmamentProcessing;

import com.sun.org.apache.xpath.internal.operations.Bool;
import dbWorker.tourmamentsQuery.TourmamentsQuery;
import teams.teamInfo.TeamInfoBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Process {

    TourmamentsQuery tquery = new TourmamentsQuery();

    public Process() {

    }

    public void sort(ArrayList<TeamInfoBean> teamsList) {
        teamsList.sort(new Comparator<TeamInfoBean>() {
            @Override
            public int compare(TeamInfoBean o1, TeamInfoBean o2) {
                if (o1.getId() == o2.getId()) return 0;
                else if (o1.getId() > o2.getId()) return 1;
                else return -1;
            }
        });
    }

    public void startTourmament(int idTourmament, int maxTeams, ArrayList<TeamInfoBean> teamsList) {
        switch (maxTeams) {
            case 4:
                startTourmamentFor4(idTourmament, teamsList);
                break;
        }
    }

    public void startTourmamentFor4(int idTourmament, ArrayList<TeamInfoBean> teamsList) {
        for (int i = 0; i < 2; i++) {
            int firstTeam = 1;
            if (i == 1) firstTeam = 0;
            tquery.createMatch(idTourmament, 1, i + 1, teamsList.get(firstTeam).getId(), teamsList.get(firstTeam + 2).getId());
        }
    }

    public void registrationMatch(int idTourmament, int previousRound, int prevMatchNumber, int winTeamId, int maxTeams) {
        TourmamentsQuery tquery = new TourmamentsQuery();
        int curMatchinPrevRound = (maxTeams / 2) / previousRound;
        switch (curMatchinPrevRound) {
            case 4:
                register4prevMatch(idTourmament, previousRound, prevMatchNumber, winTeamId, maxTeams);
                break;
            case 2:
                register2prevMatch(idTourmament, previousRound, prevMatchNumber, winTeamId, maxTeams);
                break;
        }
    }

    public void register2prevMatch(int idTourmament, int previousRound, int prevMatchNumber, int winTeamId, int maxTeams) {
        int nextMatchNumber;
        switch (prevMatchNumber) {
            case (1):
                nextMatchNumber = prevMatchNumber + maxTeams / 2;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, winTeamId, 0);
                break;
            case (2):
                nextMatchNumber = prevMatchNumber + maxTeams / 2 / previousRound - 1;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, 0, winTeamId);
                break;
        }
    }

    public void register4prevMatch(int idTourmament, int previousRound, int prevMatchNumber, int winTeamId, int maxTeams) {
        int nextMatchNumber;
        switch (prevMatchNumber) {
            case (1):
                nextMatchNumber = prevMatchNumber + maxTeams / 2 / previousRound;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, winTeamId, 0);
                break;
            case (2):
                nextMatchNumber = prevMatchNumber + maxTeams / 2 / previousRound - 1;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, 0, winTeamId);
                break;
            case (3):
                nextMatchNumber = prevMatchNumber + maxTeams / 2 / previousRound - 1;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, winTeamId, 0);
                break;
            case (4):
                nextMatchNumber = prevMatchNumber + maxTeams / 2 / previousRound - 2;
                createMatch(idTourmament, previousRound + 1, nextMatchNumber, 0, winTeamId);
                break;
        }
    }

    public void createMatch(int idTourmament, int round, int matchNumber, int firstTeamId, int secondTeamId) {
        Boolean answer = tquery.checkMatch(idTourmament,matchNumber);
        if(answer){
            if(firstTeamId == 0) tquery.updateMatchSecondTeam(idTourmament,matchNumber,secondTeamId);
            else tquery.updateMatchFirstTeam(idTourmament,matchNumber,firstTeamId);
        } else {
            tquery.createMatch(idTourmament, round, matchNumber, firstTeamId, secondTeamId);
        }
    }
}
