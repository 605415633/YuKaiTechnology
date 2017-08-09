package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 *
 * @author home-pc
 * @create2017 -06 -06 -8:57
 */
public class UserRegisterServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        new UserDAO().insert(user);
        resp.sendRedirect("homePage.jsp");
    }
}
