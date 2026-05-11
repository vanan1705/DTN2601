package backend;

import java.sql.DriverManager;

public class DBConnect {
    public class Connection {

        private static final String URL =
                "jdbc:mysql://localhost:3306/dtn2601";

        private static final String USER = "root";

        private static final String PASSWORD = "root";

        public static java.sql.Connection getConnection() {

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
    }

}
