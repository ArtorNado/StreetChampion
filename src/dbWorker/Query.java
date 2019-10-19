package dbWorker;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import logInBean.LogInBean;
import players.PlayerBean;
import teams.teamInfo.TeamInfoBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Query {

    DBworker worker = new DBworker();

    public void firstQuery() {
        String query = "select * from users";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                LogInBean logInBean = new LogInBean();
                logInBean.setName(resultSet.getString(2));
                logInBean.setName(resultSet.getString(2));
                System.out.println(logInBean.getName().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean searchUser(String visitorName){
        String answer = "";
        String query = "select * from users where name='"+visitorName+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                LogInBean logInBean = new LogInBean();
                logInBean.setName(resultSet.getString(2));
                answer = logInBean.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(answer.equals(visitorName)) {
            return true;
        } else
        return false;
    }

    public Integer getTeamId(String name){
        String query = "select teamId from teams where title ='"+ name +"'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                teamInfoBean.setId( resultSet.getInt(1));
                System.out.println(teamInfoBean.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = teamInfoBean.getId();
        return id;
    }

    public ArrayList getAllTeam(ArrayList team){
        String query = "select title from teams";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
               teamInfoBean.setName(resultSet.getString("title"));
               System.out.println(teamInfoBean.getName());
               team.add(teamInfoBean.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    public ArrayList getAllPlayers(ArrayList players, int teamId){
        String query = "select name from users where teamId='"+teamId+"'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                teamInfoBean.setName(resultSet.getString("name"));
                System.out.println(teamInfoBean.getName());
                players.add(teamInfoBean.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public Integer getUserId(String name){
        String query = "select id from users where name ='"+ name +"'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                teamInfoBean.setId( resultSet.getInt(1));
                System.out.println(teamInfoBean.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = teamInfoBean.getId();
        return id;
    }

    public void createNewTeam(String name, int userId){
        String query = "INSERT INTO teams(title, freePlaces, captainId) VALUES('"+name+"',0, '"+userId+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTeamAdmin(String name, int teamId){
        String query = "UPDATE users SET myTeamId = '"+teamId+"' WHERE name ='"+name+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setRaiting(String name, int raiting){
        String query = "UPDATE users SET raiting = '"+raiting+"' WHERE name ='"+name+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCurVoice(String name, int curVoice){
        String query = "UPDATE users SET curVoice = '"+curVoice+"' WHERE name ='"+name+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAvarageRaiting(String name, double avarageRaiting){
        String query = "UPDATE users SET avarageRaiting = '"+avarageRaiting+"' WHERE name ='"+name+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getUserRaiting(String name){
        String query = "select raiting from users where name ='"+ name +"'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                playerBean.setRaiting( resultSet.getInt("raiting"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int raiting = playerBean.getRaiting();
        return raiting;
    }

    public Double getUserAvarageRaiting(String name){
        String query = "select avarageRaiting from users where name ='"+ name +"'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                playerBean.setAvarageRaiting(resultSet.getDouble("avarageRaiting"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double avarageRaiting = playerBean.getAvarageRaiting();
        return avarageRaiting;
    }

    public Integer getUserCurVoice(String name){
        String query = "select curVoice from users where name ='"+ name +"'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                playerBean.setCurVoice( resultSet.getInt("curVoice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int curVoice = playerBean.getCurVoice();
        return curVoice;
    }

}
