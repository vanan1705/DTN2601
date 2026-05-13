package org.example.utils;

import java.sql.*;

public class DBConnect {
    public static Connection getConnection () {

        String URL = "jdbc:mysql://localhost:3306/dtn2601";

        String USER = "root";

        String PASSWORD = "root";


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                return DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
}
