package com.yezi.image.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImple implements MysqlConnection {
    private String url = "jdbc:mysql://localhost:3306/mytest";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String name = "root";
    private String pass = "123456";
    private Connection connection;
    public static ConnectionImple connectionImple;

    private ConnectionImple(){
        try {
            Connection();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection Connection() throws SQLException,ClassNotFoundException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url,name,pass);
        return connection;
    }

    public static ConnectionImple getConnectionImple() {
        if(connectionImple == null)
            connectionImple = new ConnectionImple();
        return connectionImple;
    }

    public Connection getConnection() {
        return connection;
    }
}
