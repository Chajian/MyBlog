package com.yezi.image.mysql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接接口
 */
public interface MysqlConnection {

    public Connection Connection() throws SQLException,ClassNotFoundException;

}
