package dbWorker.matchQuery;

import dbWorker.DBworker;
import matchs.MatchBean;
import players.PlayerBean;
import teams.teamInfo.TeamInfoBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatchQuery {

    DBworker worker = new DBworker();

    public ArrayList<MatchBean> getFreeSingleMatchs(){
        String queryId = "select id_fr_match_single from friendly_match_single WHERE freePlaces > '0'";
        String queryCurP = "select curPlayers from friendly_match_single WHERE freePlaces > '0'";
        String queryFreeP = "select freePlaces from friendly_match_single WHERE freePlaces > '0'";
        String queryInfo = "select info from friendly_match_single WHERE freePlaces > '0'";
        String queryData = "select data from friendly_match_single WHERE freePlaces > '0'";
        ArrayList<MatchBean> mbArray = new ArrayList<>();
        try {
            Statement statementId = worker.getConnection().createStatement();
            Statement statementCurP = worker.getConnection().createStatement();
            Statement statementFreeP = worker.getConnection().createStatement();
            Statement statementInfo = worker.getConnection().createStatement();
            Statement statementData = worker.getConnection().createStatement();
            ResultSet resultSetId = statementId.executeQuery(queryId);
            ResultSet resultSetCurP = statementCurP.executeQuery(queryCurP);
            ResultSet resultSetFreeP = statementFreeP.executeQuery(queryFreeP);
            ResultSet resultSetInfo = statementInfo.executeQuery(queryInfo);
            ResultSet resultSetData = statementData.executeQuery(queryData);
            while (resultSetId.next() && resultSetCurP.next() && resultSetFreeP.next() && resultSetInfo.next() && resultSetData.next()){
                MatchBean matchBean = new MatchBean();
                matchBean.setCurPlayers(resultSetCurP.getInt("curPlayers"));
                matchBean.setFreePlaces(resultSetFreeP.getInt("freePlaces"));
                matchBean.setPlayers(resultSetCurP.getInt("curPlayers")-resultSetFreeP.getInt("freePlaces"));
                matchBean.setId(resultSetId.getInt("id_fr_match_single"));
                matchBean.setInfo(resultSetInfo.getString("info"));
                /*matchBean.setData(resultSetData.getDate("data").toString());*/
                mbArray.add(matchBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mbArray;
    }

    public ArrayList<PlayerBean> getPlayerList(int matchId){
        String queryId = "SELECT name FROM matchsquad LEFT JOIN users USING(id) WHERE id_fr_match_single = '"+matchId+"'";
        ArrayList<PlayerBean> pbArray = new ArrayList<>();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryId);
            while (resultSet.next()){
                PlayerBean playerBean = new PlayerBean();
                playerBean.setName(resultSet.getString("name"));
                pbArray.add(playerBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pbArray;
    }



    public Integer getFreePlaces(int idMatch){
        String query = "select freePlaces from friendly_match_single WHERE id_fr_match_single = '"+ idMatch+"'";
        int freePlaces = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                freePlaces = resultSet.getInt("freePlaces");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return freePlaces;
    }

    public Integer getcurPlayers(int idMatch){
        String query = "select id from matchsquad WHERE id_fr_match_single '"+idMatch+"'";
        int curPlayers = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                curPlayers++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curPlayers;
    }

    public Integer getMatchId(int createrId){
        String query = "select id_fr_match_single from friendly_match_single WHERE createrId = '"+createrId+"'";
        int matchId = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                matchId = resultSet.getInt("id_fr_match_single");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchId;
    }

    public void addPlayer(int idMatch, int idPlayer){
        String query = "INSERT INTO matchsquad(id_fr_match_single,id) VALUES ('"+idMatch+"','"+idPlayer+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void subtractFreePlaces(int idMatch){
        String query = "UPDATE friendly_match_single SET freePlaces = freePlaces-'1' WHERE  id_fr_match_single='"+idMatch+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMatch(int curPlayers, String info, int createrId){
        String query = "INSERT INTO friendly_match_single(curPlayers,freePlaces, info, createrId) VALUES ('"+curPlayers+"', '"+curPlayers+"','"+info+"','"+createrId+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public Boolean checkMatch(int userId){
        String query = "select id_fr_match_single from matchsquad where id ='"+ userId +"'";
        boolean answer = true;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                answer = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("answer + " + answer);
        return answer;
    }

    public Boolean checkCreratedMatch(int userId){
        String query = "select id_fr_match_single from friendly_match_single where createrId ='"+ userId +"'";
        boolean answer = false;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                answer = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
    public ArrayList<MatchBean> getAllCreatedMatch(int createrId){
        String queryId = "select id_fr_match_single from friendly_match_single WHERE createrId = '"+createrId+"'";
        String queryCurP = "select curPlayers from friendly_match_single WHERE createrId = '"+createrId+"'";
        String queryFreeP = "select freePlaces from friendly_match_single WHERE createrId = '"+createrId+"'";
        String queryInfo = "select info from friendly_match_single WHERE createrId = '"+createrId+"'";
        String queryData = "select data from friendly_match_single WHERE createrId = '"+createrId+"'";
        ArrayList<MatchBean> mbArray = new ArrayList<>();
        try {
            Statement statementId = worker.getConnection().createStatement();
            Statement statementCurP = worker.getConnection().createStatement();
            Statement statementFreeP = worker.getConnection().createStatement();
            Statement statementInfo = worker.getConnection().createStatement();
            Statement statementData = worker.getConnection().createStatement();
            ResultSet resultSetId = statementId.executeQuery(queryId);
            ResultSet resultSetCurP = statementCurP.executeQuery(queryCurP);
            ResultSet resultSetFreeP = statementFreeP.executeQuery(queryFreeP);
            ResultSet resultSetInfo = statementInfo.executeQuery(queryInfo);
            ResultSet resultSetData = statementData.executeQuery(queryData);
            while (resultSetId.next() && resultSetCurP.next() && resultSetFreeP.next() && resultSetInfo.next() && resultSetData.next()){
                MatchBean matchBean = new MatchBean();
                matchBean.setCurPlayers(resultSetCurP.getInt("curPlayers"));
                matchBean.setFreePlaces(resultSetFreeP.getInt("freePlaces"));
                matchBean.setPlayers(resultSetCurP.getInt("curPlayers")-resultSetFreeP.getInt("freePlaces"));
                matchBean.setId(resultSetId.getInt("id_fr_match_single"));
                matchBean.setInfo(resultSetInfo.getString("info"));
                /*matchBean.setData(resultSetData.getDate("data").toString());*/
                mbArray.add(matchBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mbArray;
    }

    public void finishMatch(int matchId){
        String query = "DELETE FROM friendly_match_single WHERE id_fr_match_single = '"+matchId+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
