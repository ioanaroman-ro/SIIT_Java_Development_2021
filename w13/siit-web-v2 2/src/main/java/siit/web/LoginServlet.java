package siit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private int value = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(true).getAttribute("logged_user") == null) {
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/customers");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        if (user.equals(password)) {
            req.getSession(true).setAttribute("logged_user", user);
            resp.sendRedirect("/customers");
            Cookie ck = new Cookie("name", user);
            resp.addCookie(ck);
        } else {
            String error = "User and password do not match!";
            req.setAttribute("error", error);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);

        }

    }
}
