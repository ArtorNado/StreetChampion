package tourmaments.tourmamentProcessing;

import teams.teamInfo.TeamInfoBean;

import java.util.Comparator;

public class SortingTeams implements Comparator<TeamInfoBean> {
    @Override
    public int compare(TeamInfoBean o1, TeamInfoBean o2) {
        return Double.valueOf(o1.getRaiting()).compareTo(o2.getRaiting());
    }
}
