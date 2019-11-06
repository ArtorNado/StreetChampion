import players.PlayerBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditDataServlet")
public class EditDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProfileDAO dao = new ProfileDAO((String)session.getAttribute("userName"), (Integer)session.getAttribute("userId"));
        int age = dao.getUserAge();
        String firstName = dao.getFirstName();
        String secondName = dao.getSecondName();
        PlayerBean playerBean = new PlayerBean(firstName, secondName, age);
        request.setAttribute("playerBean", playerBean);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/profilePage/editData.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null){
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/LoginPage/login.jsp")
                    .forward(request, response);
        }
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        int age = Integer.parseInt(request.getParameter("age"));
        ProfileDAO dao = new ProfileDAO();
        dao.editData(firstName,secondName,age);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/mainMenu/mainMenu.jsp")
                .forward(request, response);
    }
}
