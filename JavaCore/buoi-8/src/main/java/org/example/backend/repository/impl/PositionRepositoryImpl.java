package org.example.backend.repository.impl;

import org.example.backend.repository.IPositonRepository;
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
import java.util.Objects;

public class PositionRepositoryImpl implements IPositonRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        String sql =
                "SELECT * FROM position ";

        try (
                Connection connection =
                        DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                Position position =
                        new Position();

                position.setPositionID(
                        resultSet.getInt(
                                "position_id"
                        )
                );

                position.setPositionName(PositionEnum.valueOf(resultSet.getString("position_name")));


                positions.add(position);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public boolean create(String newName) {
        try {

            Connection connection = DBConnect.getConnection();

            String sql = "insert into position (position_name) values (?);";
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

            String sql = "update position set position_name = ? where position_id = ?;";
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

            String sql = "delete from position where position_id =id ?;";
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
    public List<Position> findByIdAndName(int searchId, String searchName) {
        List<Position> positions = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from position where position_id = ? and position_name like ?;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setInt(1, searchId);
            prepareStatement.setString(2, searchName);

            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");

                Position position = new Position(id, PositionEnum.valueOf( name));
                positions.add(position);
            }
            DBConnect.close(connection, prepareStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public List<Position> getPositionWithMaxEmployee() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT p.position_id,\n" +
                "       p.position_name,\n" +
                "       COUNT(a.account_id) AS total_employee\n" +
                "FROM Position p\n" +
                "JOIN Account a \n" +
                "    ON p.position_id = a.position_id\n" +
                "GROUP BY p.position_id, p.position_name\n" +
                "HAVING COUNT(a.account_id) = (\n" +
                "    SELECT MAX(emp_count)\n" +
                "    FROM (\n" +
                "        SELECT COUNT(account_id) AS emp_count\n" +
                "        FROM Account\n" +
                "        GROUP BY position_id\n" +
                "    ) AS temp );";

        try (
                Connection connection =
                        DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                Position position =
                        new Position();

                position.setPositionID(
                        resultSet.getInt(
                                "position_id"
                        )
                );
                position.setPositionName(PositionEnum.valueOf(resultSet.getString("position_name")));
                positions.add(position);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Position> getPositionWithMinEmployee() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT p.position_id,\n" +
                "       p.position_name,\n" +
                "       COUNT(a.account_id) AS total_employee\n" +
                "FROM Position p\n" +
                "LEFT JOIN Account a \n" +
                "    ON p.position_id = a.position_id\n" +
                "GROUP BY p.position_id, p.position_name\n" +
                "HAVING COUNT(a.account_id) = (\n" +
                "    SELECT MIN(emp_count)\n" +
                "    FROM (\n" +
                "        SELECT COUNT(account_id) AS emp_count\n" +
                "        FROM Account\n" +
                "        LEFT JOIN Account a\n" +
                "           ON p.position_id = a.position_id\n" +
                "        GROUP BY p.position_id\n" +
                "    ) AS temp );";

        try (
                Connection connection =
                        DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                Position position =
                        new Position();

                position.setPositionID(
                        resultSet.getInt(
                                "position_id"
                        )
                );
                position.setPositionName(PositionEnum.valueOf(resultSet.getString("position_name")));
                positions.add(position);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        boolean check = false;
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from position where position_name like ? ";
            if (Objects.nonNull(id)) { //id != null
                sql += " and position_id != ? ";
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
}
