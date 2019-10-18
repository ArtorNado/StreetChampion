package dbWorker;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBworker {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost/streetchampions?serverTimezone=Europe/Moscow&useSSL=false";
    private final String username = "root";
    private final String password = "roott";


    public Connection getConnection() {
        return connection;
    }

    public DBworker(){
        try{
            /*Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();*/
                connection = DriverManager.getConnection(url, username, password);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
