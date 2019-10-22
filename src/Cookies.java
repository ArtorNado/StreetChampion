import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class Cookies {

    public boolean checkCookies(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String login, String password){
        HttpSession session = request.getSession(true);
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login"))
                    login = cookie.getValue();
                if (cookie.getName().equals("password"))
                    password = cookie.getValue();
            }
            request.setAttribute("loginCookies", login);
            request.setAttribute("passwordCookies", password);
        }
        return (cookies.length>0);
    }

    public  void createCookies(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String login, String password){
        Cookie cookieLogin = new Cookie("login", login);
        cookieLogin.setMaxAge(24 * 60 * 60 * 30);
        Cookie cookiePassword = new Cookie("password", password);
        cookiePassword.setMaxAge(24 * 60 * 60 * 30);
        response.addCookie(cookieLogin);
        response.addCookie(cookiePassword);
    }

}
