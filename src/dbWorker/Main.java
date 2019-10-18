package dbWorker;

import dbWorker.DBworker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        /*DBworker worker = new DBworker();
        String query = "select * from users";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                logInBean.LogInBean logInBean = new logInBean.LogInBean();
                logInBean.setName(resultSet.getString(1));
                System.out.println(logInBean.getName().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Query query = new Query();
       System.out.println(query.searchUser("Artem"));
    }
}
