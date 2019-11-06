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


    public Boolean searchUser(String login) {
        String answer = "";
        String query = "select * from users where name='" + login + "'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                LogInBean logInBean = new LogInBean();
                logInBean.setName(resultSet.getString(2));
                answer = logInBean.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (answer.equals(login)) {
            return true;
        } else
            return false;
    }

    public String getPassword(String name) {
        String query = "select password from users where name='" + name + "'";
        String password = "";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    public void addUserInTeam(int userId, int teamId) {
        String query = "INSERT INTO squads (teamId, id) VALUES ('"+teamId+"','"+userId+"')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getTeamId(String name) {
        String query = "select teamId from teams where title ='" + name + "'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                teamInfoBean.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = teamInfoBean.getId();
        return id;
    }

    public Integer getTeamId(int captainId) {
        String query = "select teamId from teams where captainId ='" + captainId + "'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                teamInfoBean.setId(resultSet.getInt(1));
                System.out.println(teamInfoBean.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = teamInfoBean.getId();
        return id;
    }

    public ArrayList getAllTeam(ArrayList team) {
        String query = "select title from teams";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                teamInfoBean.setName(resultSet.getString("title"));
                System.out.println(teamInfoBean.getName());
                team.add(teamInfoBean.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    public ArrayList getFreeTeam(ArrayList team) {
        String query = "select title from teams WHERE freePlaces ='1'";
        TeamInfoBean teamInfoBean = new TeamInfoBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                teamInfoBean.setName(resultSet.getString("title"));
                System.out.println(teamInfoBean.getName());
                team.add(teamInfoBean.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    public ArrayList getAllPlayers(ArrayList players, int teamId) {
        /*String query = "select name from users where teamId='"+teamId+"'";*/
        String query = "SELECT name FROM squads LEFT JOIN users USING(id) WHERE teamId = '" + teamId + "'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                players.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public Integer getUserId(String name) {
        String query = "select id from users where name ='" + name + "'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playerBean.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playerBean.getId();
    }

    public String getUserName(int userId) {
        String query = "select name from users where id ='" + userId + "'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playerBean.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerBean.getName();
    }

    public String getTeamName(int teamId) {
        String query = "select title from teams where teamId ='" + teamId + "'";
        String name = "";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public Integer getTeam(int userId) {
        String query = "select teamId from squads where id ='" + userId + "'";
        int id = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt("teamId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void createNewTeam(String name, int userId) {
        String query = "INSERT INTO teams(title, freePlaces, captainId) VALUES('" + name + "',0, '" + userId + "')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewUser(String name, String password, String firstName, String secondName, int age) {
        String query = "INSERT INTO users(name,password, firstName, secondName, age) VALUES('" + name + "', '" + password + "','" + firstName + "','" + secondName + "','" + age + "')";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void setTeamAdmin(String name, int teamId){
        String query = "UPDATE users SET myTeamId = '"+teamId+"' WHERE name ='"+name+"'";
        String query2 = "UPDATE users SET teamId = '"+teamId+"' WHERE name ='"+name+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.addBatch(query2);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public Boolean checkTeamAdmin(int userId) {
        String query = "select teamId from teams where captainId ='" + userId + "'";
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


    public Integer getTeamAdmin(int teamId) {
        String query = "select captainId from teams where teamId ='" + teamId + "'";
        int id = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt("captainId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Boolean checkTeam(int userId) {
        String query = "select teamId from squads where id ='" + userId + "'";
        boolean answer = false;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getInt("teamId") != 0)
                    answer = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public void setRaiting(String name, int raiting) {
        String query = "UPDATE users SET raiting = '" + raiting + "' WHERE name ='" + name + "'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCurVoice(String name, int curVoice) {
        String query = "UPDATE users SET curVoice = '" + curVoice + "' WHERE name ='" + name + "'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAvarageRaiting(String name, double avarageRaiting) {
        String query = "UPDATE users SET avarageRaiting = '" + avarageRaiting + "' WHERE name ='" + name + "'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getUserRaiting(String name) {
        String query = "select raiting from users where name ='" + name + "'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playerBean.setRaiting(resultSet.getInt("raiting"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int raiting = playerBean.getRaiting();
        return raiting;
    }

    public Double getUserAvarageRaiting(String name) {
        String query = "select avarageRaiting from users where name ='" + name + "'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playerBean.setAvarageRaiting(resultSet.getDouble("avarageRaiting"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double avarageRaiting = playerBean.getAvarageRaiting();
        return avarageRaiting;
    }

    public Integer getUserCurVoice(String name) {
        String query = "select curVoice from users where name ='" + name + "'";
        PlayerBean playerBean = new PlayerBean();
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playerBean.setCurVoice(resultSet.getInt("curVoice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int curVoice = playerBean.getCurVoice();
        return curVoice;
    }

    public String getUserFirstName(String login) {
        String query = "select firstName from users where name ='" + login + "'";
        String firstName = "";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                firstName = resultSet.getString("firstName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public String getUserSecondName(String login) {
        String query = "select secondName from users where name ='" + login + "'";
        String secondName = "";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                secondName = resultSet.getString("secondName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secondName;
    }

    public Integer getUserAge(String login) {
        String query = "select age from users where name ='" + login + "'";
        int age = 0;
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                age = resultSet.getInt("age");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return age;
    }

    public void editData(String firstName, String secondName, int age){
        String query = "UPDATE users SET firstName = '"+firstName+"'";
        String query1 = "UPDATE users SET secondName = '"+secondName+"'";
        String query2 = "UPDATE users SET age = '"+age+"'";
        try {
            Statement statement = worker.getConnection().createStatement();
            statement.addBatch(query);
            statement.executeBatch();
            statement.close();
            Statement statement1 = worker.getConnection().createStatement();
            statement1.addBatch(query1);
            statement1.executeBatch();
            statement1.close();
            Statement statement2 = worker.getConnection().createStatement();
            statement2.addBatch(query2);
            statement2.executeBatch();
            statement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
