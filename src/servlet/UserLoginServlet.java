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
 * @author home-pc
 * @create2017 -06 -05 -21:21
 */
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name =req.getParameter("name");
        String password=req.getParameter("password");
        List<User> users=new UserDAO().list();
        int i=new UserDAO().getTotal();
        for(User u : users){
            if(u.getUsername().equals(name)&&u.getPassword().equals(password)){
                req.getSession().setAttribute("user",u);
                resp.sendRedirect("homePage.jsp");
                break;
            }
            i--;
            if(i==0){
                resp.setContentType(req.getCharacterEncoding());
                resp.getWriter().print("<font color='red'>账户密码不匹配</font>");
                resp.sendRedirect("login.jsp");
 }

        }


    }
}
