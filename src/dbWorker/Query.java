package dbWorker;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import logInBean.LogInBean;
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
}
