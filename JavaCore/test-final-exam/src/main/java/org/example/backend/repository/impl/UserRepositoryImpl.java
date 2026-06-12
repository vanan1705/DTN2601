package org.example.backend.repository.impl;

import org.example.backend.repository.IUserRepository;
import org.example.entity.User;
import org.example.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql =
                "SELECT * FROM users ";

        try (
                Connection connection =
                        DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFullName( resultSet.getString("full_name"));
                user.setPassword( resultSet.getString("password"));
                user.setExpInYear( resultSet.getFloat("exp_in_year"));
                user.setProSkill( resultSet.getString("pro_skill"));
                users.add(user);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findById(int id) {
        List<User> users = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from users where id = ?;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setInt(1, id);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {// lặp qua qua từng dòng của rs
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFullName( resultSet.getString("full_name"));
                user.setEmail( resultSet.getString("email"));
                user.setExpInYear( resultSet.getFloat("exp_in_year"));
                user.setProSkill( resultSet.getString("pro_skill"));
                users.add(user);
            }
            DBConnect.close(connection, prepareStatement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "delete from users where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return  (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean create(String fullName, String email) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "insert into users (full_name, email) values (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return  (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExitFullNameOrEmail(String fullName, String email) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "SELECT COUNT(*)\n" +
                    "            FROM users\n" +
                    "            WHERE (full_name = ? AND ? IS NOT NULL)\n" +
                    "               OR (email = ? AND ? IS NOT NULL)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, email);


            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return  (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
