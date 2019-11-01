package dbWorker.tourmamentsQuery;

import dbWorker.DBworker;
import teams.teamInfo.TeamInfoBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TourmamentsQuery {
    DBworker worker = new DBworker();

    public void createTourmament(String name,int maxTeams, String description, int adminId){
        String query = "INSERT INTO tourmament(name, maxTeams, freePlaces, description, adminId) VALUES('"+name+"','"+maxTeams+"', '"+maxTeams+"','"+description+"','"+adminId+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeam(int idTourmament, int idTeam){
        String query = "INSERT INTO tourmaments_squads(idTourmament, teamId) VALUES ('"+idTourmament+"','"+idTeam+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void subtractFreePlaces(int idTourmament){
        String query = "UPDATE tourmament SET freePlaces = freePlaces-'1' WHERE  idTourmament='"+idTourmament+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getTourmamentId(int adminId){
        String query = "select idTourmament from tourmament WHERE adminId = '"+adminId+"'";
        int tourmamentId = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tourmamentId = resultSet.getInt("idTourmament");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tourmamentId;
    }

    public ArrayList<TeamInfoBean> getAllTeams(int idTourmament){
        String queryId = "select teamId from tourmaments_squads WHERE idTourmament = '"+idTourmament+"'";
        ArrayList<TeamInfoBean> mbArray = new ArrayList<>();
        try {
            Statement statementId = worker.getConnection().createStatement();
            ResultSet resultSetId = statementId.executeQuery(queryId);
            while (resultSetId.next()){
                TeamInfoBean teamInfoBean = new TeamInfoBean();
                teamInfoBean.setId(resultSetId.getInt("teamId"));
                /*matchBean.setData(resultSetData.getDate("data").toString());*/
                mbArray.add(teamInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mbArray;
    }

    public Double getRaitingTeam(int teamId){
        String query = " SELECT raiting FROM teams WHERE teamId = '"+teamId+"'";
        double raiting = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                raiting = resultSet.getDouble("raiting");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return raiting;
    }

    public void createMatch(int idTourmament, int round, int numberMatch, int firstTeamId, int secondTeamId){
        String query = "INSERT INTO tourmaments_matchs(idTourmament, round, numberMatch, firstTeamdId, secondteamId) " +
                "VALUES ('"+idTourmament+"','"+round+"','"+numberMatch+"','"+firstTeamId+"', '"+secondTeamId+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setWinTeam(int idTourmament, int idTeam, int numberMatch){
        String query = "UPDATE tourmaments_matchs SET winnerId = '"+idTeam+"' WHERE idTourmament = '"+idTourmament+"'" +
                "AND numberMatch = '"+numberMatch+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getWinTeamId(int numberMatch, int idTourmament){
        String query = " SELECT winnerId FROM tourmaments_matchs WHERE idTourmament = '"+idTourmament+"'" +
                "AND numberMatch = '"+numberMatch+"'";
        int teamId = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                teamId = resultSet.getInt("winnerId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamId;
    }

    public Boolean checkMatch(int idTourmament, int matchNumber) {
        String query = "select numberMatch from tourmaments_matchs where idTourmament ='" + idTourmament + "' AND " +
                "numberMatch = '"+matchNumber+"'";
        boolean answer = false;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                answer = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public void updateMatchFirstTeam(int idTourmament, int numberMatch, int firstTeamId){
        String query = "UPDATE tourmaments_matchs SET firstTeamdId = '"+firstTeamId+"' WHERE idTourmament = '"+idTourmament+"' " +
                "AND numberMatch = '"+numberMatch+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMatchSecondTeam(int idTourmament, int numberMatch, int secondTeamId){
        String query = "UPDATE tourmaments_matchs SET secondteamId = '"+secondTeamId+"' WHERE idTourmament = '"+idTourmament+"' " +
                "AND numberMatch = '"+numberMatch+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
