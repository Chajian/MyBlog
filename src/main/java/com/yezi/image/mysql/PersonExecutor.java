package com.yezi.image.mysql;

import com.yezi.image.info.User;

import java.sql.SQLException;

//处理玩家
public interface PersonExecutor {

    User findUser(String account)throws SQLException;

    boolean checkUser(String account,String password)throws SQLException;

    boolean writerUser(User user)throws SQLException;

    boolean deleteUser(String account)throws SQLException;

    boolean changeUser(User user)throws SQLException;
}
