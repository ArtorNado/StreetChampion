package teams;

import dbWorker.DBworker;
import logInBean.LogInBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateFreeTeamsTable {

    DBworker worker = new DBworker();

    public void generateFreeTeams(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String query = "select * from teams where freePlaces='1'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            out.println("<table>");
            out.println("<tbody>");
            while (resultSet.next()){
                LogInBean logInBean = new LogInBean();
                logInBean.setName(resultSet.getString(2));
                System.out.println(logInBean.getName().toString());
                out.println("<tr>");
                out.println("<td>");
                out.println("<a href=\"/teaminfo?name="+logInBean.getName()+"\">" + logInBean.getName() + "</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
