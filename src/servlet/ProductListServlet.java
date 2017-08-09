package servlet;

import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author home-pc
 * @create2017 -06 -10 -19:58
 */
public class ProductListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products= new ProductDAO().listProduct();
        req.setAttribute("products",products);
        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}
