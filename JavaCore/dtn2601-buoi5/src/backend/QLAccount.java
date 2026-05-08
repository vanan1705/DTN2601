package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import enums.PositionEnum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    public static List<Account> getAllAccount() {
        List<Account> accounts = new ArrayList<>();
        String sql =
                "SELECT a.id, a.full_name, a.email, d.id AS department_id, d.department_name, p.id AS position_id, p.position_name " +
                        "FROM accountt a " +
                        "JOIN department d " +
                        "ON a.department_id = d.id " +
                        "JOIN positionn p " +
                        "ON a.position_id = p.id";

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

                // Tao Position object
                Position position =
                        new Position();

                position.setPositionID(
                        resultSet.getInt(
                                "position_id"
                        )
                );

                position.setPositionName(PositionEnum.valueOf(resultSet.getString("position_name")));

                // Tao Account object
                Account account =
                        new Account();

                account.setAccountID(
                        resultSet.getInt("id")
                );

                account.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );

                account.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );

                // Set object vao account
                account.setDepartment(
                        department
                );

                account.setPosition(
                        position
                );

                accounts.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static void printAccounts(){

        List<Account> accounts = getAllAccount();

        for (Account account : accounts) {

            System.out.println(account.toString());
        }
    }
}
