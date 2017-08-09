package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据查询
 *
 * @author home-pc
 * @create2017 -06 -05 -21:05
 */
public class UserDAO {

    public UserDAO(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public User getUser(String name,String password){
        User user = null;
        List<User> users=new ArrayList<>();
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                    "characterEncoding=UTF-8","root","admin");
            String sql="select * from user where name = ? and password = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                user =new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(name);
                user.setPassword(password);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> list(){
        return list(0,Short.MAX_VALUE);
    }
    public List<User> list(int start,int count){
        List<User> users=new ArrayList<>();

        String sql="select * from user ORDER by id desc limit ?,? ";
        try(
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                    "characterEncoding=UTF-8","root","admin");
            PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,count);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String password=resultSet.getString(3);
                user.setId(id);
                user.setUsername(name);
                user.setPassword(password);
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public int getTotal(){
        int total=0;

        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                "characterEncoding=UTF-8","root","admin");
        Statement statement=connection.createStatement();){
            String sql="select count(*) from user";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                total=resultSet.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public void insert(User user){
        try{Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                "characterEncoding=UTF-8","root","baobao19950802");
        String sql="insert into user values ( ?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,getTotal()+1);
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void add(User user){
        try{Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                "characterEncoding=UTF-8","root","baobao19950802");
            String sql="insert into USER values(null,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.username);
            preparedStatement.setString(2,user.password);
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int id=resultSet.getInt(1);
                user.id=id;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(User user){

        try{Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                "characterEncoding=UTF-8","root","baobao19950802");
            String sql="update USER set name= ?,password= ?, where id= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.username);
            preparedStatement.setString(2,user.password);
            preparedStatement.setInt(3,user.id);
            preparedStatement.execute();
            }catch (SQLException e){
            e.printStackTrace();
        }

        }

        public void delete(int id){
            try{Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                    "characterEncoding=UTF-8","root","baobao19950802");
                Statement statement=connection.createStatement();
                String sql="delete from user where id ="+id;
                statement.execute(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        public User get(int id){
        User user=null;
            try{Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?" +
                    "characterEncoding=UTF-8","root","baobao19950802");
                Statement statement=connection.createStatement();
                String sql="SELECT * from user where id = "+id;
                ResultSet resultSet=statement.executeQuery(sql);

                if(resultSet.next()){
                    user=new User();
                    String name=resultSet.getString(2);
                    String password=resultSet.getString(3);
                    user.username=name;
                    user.password=password;
                    user.id=id;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return user;
        }
    }

