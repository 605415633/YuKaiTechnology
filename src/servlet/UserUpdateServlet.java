package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author home-pc
 * @create2017 -06 -07 -20:46
 */
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user=new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUsername(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));

        new UserDAO().update(user);
        resp.sendRedirect("/listHero");
    }
}
