package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * UserListServlet
 *
 * @author home-pc
 * @create2017 -06 -07 -20:34
 */
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;character=UTF-8");

        List<User> users=new UserDAO().list();
        StringBuffer sb=new StringBuffer();
        sb.append("<html><head><title>sas</title></head><body><h1 align='center'></h1>" +
                "<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>password</td><td>edit</td><td>delete</td></tr>\r\n");
        String trFormat="<tr><td>%d</td><td>%s</td><td>%s</td><td><a href='editUser?id=%d'>edit</a></td><td><a href='deleteUser?id=%d'>delete</a></td></tr>\r\n";
        for(User user:users){
            String tr=String.format(trFormat,user.getId(),user.getUsername(),user.getPassword(),user.getId(),user.getId());
            sb.append(tr);
        }
        sb.append("</table></body></html>");
        resp.getWriter().write(sb.toString());
    }
}
