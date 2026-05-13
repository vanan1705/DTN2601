package org.example.backend.repository.impl;

import org.example.backend.repository.IDeparmentRepository;
import org.example.entity.Department;
import org.example.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeparmentRepositoryImpl implements IDeparmentRepository {
    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        String sql =
                "SELECT * FROM deparment ";

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



                departments.add(department);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean create(String newName) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "insert into department (department_name) values (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return  (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, String updateName) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "update department set department_name = ? where department_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();
            DBConnect.close(connection, preparedStatement, null);
            return  (c > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "delete from department where department_id = ?;";
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
    public List<Department> findByIdAndName(int searchId, String searchName) {
        List<Department> departments = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_id = ? and department_name like ?;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setInt(1, searchId);
            prepareStatement.setString(2, searchName);

            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");

                Department dep = new Department(id, name);
                departments.add(dep);
            }
            DBConnect.close(connection, prepareStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> getDeparmentWithMaxEmployee() {
        List<Department> departments = new ArrayList<>();
        String sql =
                "SELECT d.department_id,\n" +
                        "       d.department_name,\n" +
                        "       COUNT(a.account_id) AS total_employee\n" +
                        "FROM Department d\n" +
                        "JOIN Account a \n" +
                        "    ON d.department_id = a.department_id\n" +
                        "GROUP BY d.department_id, d.department_name\n" +
                        "HAVING COUNT(a.account_id) = (\n" +
                        "    SELECT MAX(emp_count)\n" +
                        "    FROM (\n" +
                        "        SELECT COUNT(account_id) AS emp_count\n" +
                        "        FROM Account\n" +
                        "        GROUP BY department_id\n" +
                        "    ) AS temp );";

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



                departments.add(department);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> getDeparmentWithMinEmployee() {
        List<Department> departments = new ArrayList<>();
        String sql =
                "SELECT d.department_id,\n" +
                        "       d.department_name,\n" +
                        "       COUNT(a.account_id) AS total_employee\n" +
                        "FROM Department d\n" +
                        "LEFT JOIN Account a\n" +
                        "    ON d.department_id = a.department_id\n" +
                        "GROUP BY d.department_id, d.department_name\n" +
                        "HAVING COUNT(a.account_id) = (\n" +
                        "    SELECT MIN(emp_count)\n" +
                        "    FROM (\n" +
                        "        SELECT COUNT(a.account_id) AS emp_count\n" +
                        "        FROM Department d\n" +
                        "        LEFT JOIN Account a\n" +
                        "            ON d.department_id = a.department_id\n" +
                        "        GROUP BY d.department_id\n" +
                        "    ) AS temp);";

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



                departments.add(department);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
}
