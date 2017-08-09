package dao;

import bean.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author home-pc
 * @create2017 -06 -10 -21:34
 */
public class OderItemDAO {

    public void insert(OrderItem orderItem){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart" +
                    "?characterEncoding=UTF-8&useSSL=false",
                    "root","admin");
            String sql="insert into orderitem values(null,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderItem.getProduct().getId());
            preparedStatement.setInt(2,orderItem.getNum());
            preparedStatement.setInt(3,orderItem.getOrder().getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
