package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users{

    private Connection connection;
    private Config config = new Config();

    public MySQLUsersDao(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

//    public static void main(String[] args) {
//        User user = mySQLUsersDao.findUsername("Shaz");
//    }

    @Override
    public User findByUsername(String username) {

        try {

            String query = "SELECT * FROM users WHERE username = (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                return extractUser(rs);
            } else {
                return null;
            }

        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }

    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    @Override
    public Long insert(User user) {

        try {

            String query = "INSERT INTO users(username, email, password) VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(1, user.getPassword());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            rs.next();

            return rs.getLong(1);

        } catch (SQLException sqle) {
            throw new RuntimeException("error", sqle);
        }

    }
}
