package dao;

import bean.Order;

import java.sql.*;

/**
 * @author home-pc
 * @create2017 -06 -10 -21:28
 */
public class OrderDAO {

    public void insert(Order order){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "cart?characterEncoding=UTF-8&useSSL=false",
                    "root","admin");
            String sql="insert into order_ values(null,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,order.getUser().getId());
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int id=resultSet.getInt(1);
                order.setId(id);//这个一会需要改一下
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
