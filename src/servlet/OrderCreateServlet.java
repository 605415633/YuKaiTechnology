package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OderItemDAO;
import dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author home-pc
 * @create2017 -06 -10 -21:42
 */
public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User) req.getSession().getAttribute("user");
        if(user==null){
            resp.sendRedirect("login.jsp");
            return;
        }
        Order order=new Order();
        order.setUser(user);
        new OrderDAO().insert(order);
        List<OrderItem> orderItemList=(List<OrderItem>) req.getSession().getAttribute("orderItemList");

        for(OrderItem orderItem:orderItemList){
            orderItem.setOrder(order);
            new OderItemDAO().insert(orderItem);
        }
        orderItemList.clear();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("订单创建成功！");
    }
}
