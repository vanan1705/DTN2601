package org.example.backend.repository.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;
import org.example.enums.PositionEnum;
import org.example.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {
    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql =
                "SELECT a.account_id, a.full_name, a.email, d.department_id , d.department_name, p.position_id , p.position_name " +
                        "FROM accountt a " +
                        "JOIN department d " +
                        "ON a.department_id = d.department_id " +
                        "JOIN positionn p " +
                        "ON a.position_id = p.position_id";

        try (
                Connection connection =
                        DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {
            while (resultSet.next()) {

                Department department =
                        new Department();
                department.setDepartmentID(
                        resultSet.getInt(
                                "department_id"
                        )
                );
                department.setDepartmentName(
                        resultSet.getString(
                                "department_name"
                        )
                );
                // Tao Position object
                Position position =
                        new Position();

                position.setPositionID(
                        resultSet.getInt(
                                "position_id"
                        )
                );
                position.setPositionName(PositionEnum.valueOf(resultSet.getString("position_name")));
                // Tao Account object
                Account account =
                        new Account();
                account.setAccountID(
                        resultSet.getInt("account_id")
                );
                account.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );
                account.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );
                // Set object vao account
                account.setDepartment(
                        department
                );
                account.setPosition(
                        position
                );
                accounts.add(account);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "insert into account (email, user_name, full_name, department_id, position_id) values (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, newUserName);
            preparedStatement.setString(3, newFullName);
            preparedStatement.setInt(4, newDepartmentId);
            preparedStatement.setInt(5, newPositionId);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "update account " +
                    "set email = ?, full_name = ?,user_name = ?, department_id = ?, position_id = ?" +
                    "where position_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateEmail);
            preparedStatement.setString(2, updateFullName);
            preparedStatement.setString(3, updateUserName);
            preparedStatement.setInt(4, updateDepartmentId);
            preparedStatement.setInt(5, updatePositionId);
            preparedStatement.setInt(6, id);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "delete from account where account_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> findByIdAndName(int searchId, String searchUserName) {
        List<Account> accounts = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "SELECT a.account_id, a.full_name, a.email, d.department_id , d.department_name, p.position_id , p.position_name "+
                    "FROM account a "+
                    "JOIN department d ON a.department_id = d.department_id "+
                    "JOIN position p ON a.position_id = p.position_id "+
                    "WHERE account_id =? AND user_name =? ";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setInt(1, searchId);
            prepareStatement.setString(2, searchUserName);

            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {// lặp qua qua từng dòng của rs
                Department department =
                        new Department();

                department.setDepartmentID(
                        rs.getInt(
                                "department_id"
                        )
                );

                department.setDepartmentName(
                        rs.getString(
                                "department_name"
                        )
                );

                // Tao Position object
                Position position =
                        new Position();

                position.setPositionID(
                        rs.getInt(
                                "position_id"
                        )
                );

                position.setPositionName(PositionEnum.valueOf(rs.getString("position_name")));

                // Tao Account object
                Account account =
                        new Account();

                account.setAccountID(
                        rs.getInt("account_id")
                );

                account.setFullName(
                        rs.getString(
                                "full_name"
                        )
                );

                account.setEmail(
                        rs.getString(
                                "email"
                        )
                );

                // Set object vao account
                account.setDepartment(
                        department
                );

                account.setPosition(
                        position
                );

                accounts.add(account);
            }
            DBConnect.close(connection, prepareStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
