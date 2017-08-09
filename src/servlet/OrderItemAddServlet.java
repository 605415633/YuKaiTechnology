package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author home-pc
 * @create2017 -06 -10 -20:56
 */
public class OrderItemAddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num=Integer.parseInt(req.getParameter("num"));
        int pid=Integer.parseInt(req.getParameter("pid"));
        Product product=new ProductDAO().getProduct(pid);

        OrderItem orderItem=new OrderItem();
        orderItem.setProduct(product);
        orderItem.setNum(num);

        List<OrderItem> orderItemList=(List<OrderItem>) req.getSession().getAttribute("orderItemList");

        if(orderItemList==null){
            orderItemList=new ArrayList<>();
            req.getSession().setAttribute("orderItemList",orderItemList);
        }
        boolean found=false;
        for(OrderItem orderItem1:orderItemList){
            if(orderItem.getProduct().getId()==orderItem1.getProduct().getId()){
                orderItem1.setNum(orderItem.getNum()+orderItem1.getNum());
                found=true;
                break;
            }
        }
        if(!found)
            orderItemList.add(orderItem);
        resp.sendRedirect("/listOrderItem");
    }
}
