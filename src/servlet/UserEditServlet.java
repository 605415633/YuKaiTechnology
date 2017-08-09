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
 * @create2017 -06 -07 -20:42
 */
public class UserEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        User user=new UserDAO().get(id);
        StringBuffer format=new StringBuffer();
        resp.setContentType("text/html;charset=UTF-8");
        format.append("<html><head><title>dsad</title></head><body>");
        format.append("<form action='updateHero' method='post'>");
        format.append("用户名：<input type='text' name='name' value='%s'><br>");
        format.append("密码：<input type='text' name=password value='%s'> <br>" );
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form></body></html>");
        String html=String.format(format.toString(),user.getUsername(),user.getPassword(),user.getId());
        resp.getWriter().write(html);
    }
}
