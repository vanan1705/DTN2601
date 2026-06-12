package org.example.backend.repository.impl;

import org.example.backend.repository.IMajorRepository;
import org.example.entity.Major;
import org.example.utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MajorRepositoryImpl implements IMajorRepository {
    @Override
    public List<Major> findAll () throws SQLException {

        List<Major> majors = new ArrayList<>();

        // câu lệnh lấy toàn bộ Major
        String sql =
                "SELECT * FROM Major";
        try (
                Connection connection = DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                Major major =
                        new Major();

                major.setMajorId(
                        resultSet.getInt(
                                "major_id"
                        )
                );

                major.setMajorName(
                        resultSet.getString(
                                "major_name"
                        )
                );



                majors.add(major);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majors;
    }

    @Override
    public boolean checkExistsId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean checkExist = false;
        try {

            // câu lệnh kiểm tra major_id có tồn tại không
            connection = DBConnect.getConnection();
            String sql = "select * from Major where major_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                checkExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(connection, statement, resultSet);
        }
        return checkExist;
    }
}
