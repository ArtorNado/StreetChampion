package dbWorker.tourmamentsQuery;

import dbWorker.DBworker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
