package backend;

import entity.Position;
import enums.PositionEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLPositon {

    public static List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT * FROM position";

        try (
                Connection connection =
                        DBConnect.Connection.getConnection();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    public static void printPositions( List<Position> positions){

        for (Position position : positions) {

            System.out.println(position.toString());
        }
    }

    public static List<Position> findByPositionIdAndName(int searchId, String searchName) {
        List<Position> positions = new ArrayList<>();

        try {
            // b1: kết nối đến DB
            Connection connection = DBConnect.Connection.getConnection();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    public static boolean insertPosition(String newName) {
        try {

            Connection connection = DBConnect.Connection.getConnection();

            String sql = "insert into position (position_name) values (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deletePosition(String deleteName) {
        try {

            Connection connection = DBConnect.Connection.getConnection();

            String sql = "delete from position where position_name like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deleteName);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePosition(int id, String updateName) {
        try {

            Connection connection = DBConnect.Connection.getConnection();

            String sql = "update position set position_name = ? where position_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void getPositionWithMaxEmmployee() {
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
                        DBConnect.Connection.getConnection();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        printPositions(positions);
    }

    public static void getPositionWithMinEmmployee() {
        List<Position> positions = new ArrayList<>();
        String sql = "SELECT p.position_id,\n" +
                "       p.position_name,\n" +
                "       COUNT(a.account_id) AS total_employee\n" +
                "FROM Position p\n" +
                "JOIN Account a \n" +
                "    ON p.position_id = a.position_id\n" +
                "GROUP BY p.position_id, p.position_name\n" +
                "HAVING COUNT(a.account_id) = (\n" +
                "    SELECT MIN(emp_count)\n" +
                "    FROM (\n" +
                "        SELECT COUNT(account_id) AS emp_count\n" +
                "        FROM Account\n" +
                "        GROUP BY position_id\n" +
                "    ) AS temp );";

        try (
                Connection connection =
                        DBConnect.Connection.getConnection();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        printPositions(positions);
    }
}
