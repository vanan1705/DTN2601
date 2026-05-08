package backend;

import entity.Position;
import enums.PositionEnum;

import java.sql.Connection;
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

    public static void printPositions(){

        List<Position> positions = getAllPosition();

        for (Position position : positions) {

            System.out.println(position.toString());
        }
    }
}
