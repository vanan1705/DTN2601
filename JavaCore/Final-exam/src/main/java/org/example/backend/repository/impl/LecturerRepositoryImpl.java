package org.example.backend.repository.impl;

import org.example.backend.repository.ILecturerRepository;
import org.example.entity.Lecturer;
import org.example.entity.Major;
import org.example.entity.Student;
import org.example.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LecturerRepositoryImpl implements ILecturerRepository {
    @Override
    public Lecturer findById(int id) throws SQLException {
        Lecturer lecturer = new Lecturer();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // câu lệnh tìm kiếm Lecturer theo lecturer_id
        String sql =
                "SELECT * FROM Lecturer WHERE lecturer_id = ?";

        try {
            connection = DBConnect.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {


                lecturer.setLecturerId(
                        resultSet.getInt(
                                "lecturer_id"
                        )
                );

                lecturer.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );

                lecturer.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );

                lecturer.setDepartment(
                        resultSet.getString(
                                "department"
                        )
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBConnect.close(connection, statement, resultSet);
        }
        return lecturer;
    }
}
