package dao;

import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**展示所有商品
 * @author home-pc
 * @create2017 -06 -10 -19:47
 */
public class ProductDAO {


    public Product getProduct(int id){
        Product product=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "cart?characterEncoding=UTF-8&useSSL=false",
                    "root","admin");
            String sql="select * from prodect where id= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                product=new Product();
                product.setId(id);
                String name=resultSet.getString(2);
                float price=resultSet.getFloat(3);
                product.setPrice(price);
                product.setName(name);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }



    public List<Product> listProduct(){

        List<Product> products=new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306" +
                    "/cart?characterEncoding=UTF-8&useSSL=false",
                    "root","admin");
            String sql="SELECT * FROM  prodect ORDER BY id DESC ";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                Product product=new Product();
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                float price=resultSet.getFloat(3);
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);//当在其他的Module存在相同的bean的时候，就会出现黄色的波浪线。
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
}
