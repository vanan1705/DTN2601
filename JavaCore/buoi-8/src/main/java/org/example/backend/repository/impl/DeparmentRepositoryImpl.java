package org.example.backend.repository.impl;

import org.example.backend.repository.IDeparmentRepository;
import org.example.entity.Department;
import org.example.utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean checkExistName(String name, Integer id) {
        boolean check = false;
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_name like ? ";
            if (Objects.nonNull(id)) { //id != null
                sql += " and department_id != ? ";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (Objects.nonNull(id)) { //id != null
                preparedStatement.setInt(2, id);
            }
            ResultSet rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            DBConnect.close(connection, preparedStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return check;
    }

    @Override
    public boolean createDepartments(List<Department> departments)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // b1: kết nối đến DB
            connection = DBConnect.getConnection();
            connection.setAutoCommit(false);// tắt auto commit để có lỗi thì còn rollback
            // b2: tiến hành thêm mới department
            String sql = "insert into department (department_name) values (?);";
            preparedStatement = connection.prepareStatement(sql);
            for (Department department : departments) {
                preparedStatement.setString(1, department.getDepartmentName());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();// thuc thi câu lenh xong
            connection.commit();// ko xảy ra lỗi , lưu dữ liệu vào DB
            DBConnect.close(connection, preparedStatement, null);
            return true;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            connection.rollback();// hoàn lại dữ liệu nếu gặp lỗi

            e.printStackTrace();// show ra exception
        } finally {
            DBConnect.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public List<Department> findByName(String searchName) {
        List<Department> departments = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_name like ?;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setString(1, searchName);

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
}
