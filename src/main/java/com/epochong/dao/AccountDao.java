package com.epochong.dao;


import com.epochong.po.User;

import java.sql.*;

import static com.epochong.utils.JdbcUtils.*;

/**
 * @author epochong
 * @date 2019/8/3 10:25
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountDao {
    public User userLogin(String userName, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = getConnection();
            String sql = "select * from user where userName = ? and" + " password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUserInfo(resultSet);
            }
        } catch (Exception e) {
            System.err.println("查询数据库用户信息出错");
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return user;
    }

    public User getUserInfo(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("userId"));
        user.setPassword(resultSet.getString("password"));
        user.setUserName(resultSet.getString("username"));
        return user;
    }
}
