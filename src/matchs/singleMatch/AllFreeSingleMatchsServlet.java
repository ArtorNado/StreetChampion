package matchs.singleMatch;

import dbWorker.Query;
import matchs.MatchBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AllFreeSingleMatchsServlet")
public class AllFreeSingleMatchsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllFreeSingleMatchsDAO dao = new AllFreeSingleMatchsDAO();
        ArrayList<MatchBean> freeSingleMatchs = new ArrayList();
        freeSingleMatchs = dao.getAllFreeSingleMatches(freeSingleMatchs);
        request.setAttribute("freeSingleMatchs", freeSingleMatchs);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/match/freeSingleMatchList.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
