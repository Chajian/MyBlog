package com.yezi.image.mysql;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.yezi.image.info.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 修改用户操作
 */
public class PersonExecutorImple implements PersonExecutor {

    private Connection connection;
    private String table;

    public PersonExecutorImple(Connection connection,String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public User findUser(String account) throws SQLException {
        String url = "SELECT * FROM "+table+" WHERE account = "+account;
        PreparedStatement statement = connection.prepareStatement(url);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.first()){
            String string_account = resultSet.getString("account");
            String name = resultSet.getString("name");
            String pass = resultSet.getString("passworld");
            String info = resultSet.getString("info");
            String gender = resultSet.getString("gender");
            int photoid = resultSet.getInt("photoid");
            int age = resultSet.getInt("age");
            User user = new User();
            user.setAccount(string_account);
            user.setPass(pass);
            user.setName(name);
            user.setInfo(info);
            user.setGender(gender);
            user.setPhotoid(photoid);
            user.setAge(age);
            return user;
        }
        return null;
    }

    @Override
    public boolean checkUser(String account, String password) throws SQLException {
        String command = "SELECT * FROM "+table+" WHERE account = "+account+" and passworld = "+password;
        PreparedStatement statement = connection.prepareStatement(command);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.first())
            return true;
        return false;
    }

    @Override
    public boolean writerUser(User user) throws SQLException {
        if(findUser(user.getAccount()) == null) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + table + " (account,name,passworld,info,gender,photoid) VALUES (?,?,?,?,?,?)");
            statement.setObject(1, user.getAccount());
            statement.setObject(2,user.getName());
            statement.setObject(3,user.getPass());
            statement.setObject(4,user.getInfo());
            statement.setObject(5,user.getGender());
            statement.setObject(6,user.getPhotoid());
            statement.execute();
            statement.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String account) throws SQLException {
        if(findUser(account)!=null) {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM "+ table +" WHERE account = ?");
            statement.setObject(1,account);
            statement.execute();
            statement.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean changeUser(User user) throws SQLException {
        if(findUser(user.getAccount()) != null){
            PreparedStatement statement = connection.prepareStatement("UPDATE SET "+ table +
                    " name = ?,info = ?,passworld = ?,age = ?,photoid = ?,gender = ? WHERE account = ?");
            statement.setObject(1,user.getName());
            statement.setObject(2,user.getInfo());
            statement.setObject(3,user.getPass());
            statement.setObject(4,user.getAge());
            statement.setObject(5,user.getPhotoid());
            statement.setObject(6,user.getGender());
            statement.setObject(7,user.getAccount());
            statement.execute();
            statement.close();
        }
        return false;
    }
}
