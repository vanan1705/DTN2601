package backend;

import entity.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public static List<Department> getAllDeparment() {
        List<Department> departments = new ArrayList<>();
        String sql =
                "SELECT * FROM deparment ";

        try (
                Connection connection =
                        DBConnect.Connection.getConnection();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public static void printDepartments(){

        List<Department> departments = getAllDeparment();

        for (Department department : departments) {

            System.out.println(department.toString());
        }
    }
}
