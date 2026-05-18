package org.example.frontend;


import org.example.backend.controller.AccountController;
import org.example.backend.controller.DeparmentController;
import org.example.backend.controller.PositionController;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AccountFunction {
    AccountController accountController = new AccountController();
    DeparmentController departmentController = new DeparmentController();
    PositionController positionController = new PositionController();
    private static Scanner sc = new Scanner(System.in);

    public  void run() {
        List<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Xóa account theo tên");
            System.out.println("4. Update account theo ID");
            System.out.println("5. Tìm kiếm account họ tên");
            System.out.println("6. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    accounts = accountController.findAll();
                    showAccount(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    deleteAccount();
                    break;
                case "4":
                    updateAccount();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public  void findByIdAndName() {
        System.out.println("Nhập tên ID account cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập user name account cần tìm: ");
        String name = sc.nextLine();

        List<Account> accounts = accountController.findByIdAndName(id, name);
        showAccount(accounts);
    }


    public  void showAccount(List<Account> accounts) {
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", "ID", "FullName", "Email", "Username", "Tên", "Tên chức vụ");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for (Account account : accounts) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", account.getAccountID(), account.getFullName(), account.getEmail(), account.getUserName(), account.getDepartment().getDepartmentName(), account.getPosition().getPositionName());
        }
        if (accounts.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
    }

    public  void insertAccount() {
        String email;
        while (true) {
            boolean check = true;
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            System.out.println("Nhập email: ");
            email = sc.nextLine();
            // kiem tra tinh dung dan cua email
            if (Objects.isNull(email)
                    || email.trim().isEmpty()
                    || !email.matches(regex)) {

                System.out.println("Email không hợp lệ");
                check = false;
            }
            if (accountController.checkExistEmail(email, null)) {// kiem tra email da ton tai chua
                System.out.println("Email này đã tồn tại. Nhập lại email khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        String userName;
        while (true) {
            boolean check = true;
            System.out.println("Nhập username: ");
            userName = sc.nextLine();
            // kiem tra tinh dung dan cua user name
            if (Objects.isNull(userName) || email.trim().isEmpty()) {
                System.out.println("User Name không hợp lệ");
                check = false;
            }
            if (accountController.checkExistUserName(userName, null)) {// kiem tra user name da ton tai chua
                System.out.println("User Name này đã tồn tại. Nhập lại User Name khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        System.out.println("Nhập fullName: ");
        String fullName = sc.nextLine();
        System.out.println("Chọn ID department: ");
        List<Department> departments = departmentController.findAll();
        String depID;
        while (true) {
            for (Department department : departments) {
                System.out.println("ID: " + department.getDepartmentID() + ", DepartmentName: " + department.getDepartmentName());
            }
            depID = sc.nextLine();
            boolean checkExists = checkExistDepartment(departments, depID);
            if (!checkExists) {
                System.out.println("Chọn sai, chọn lại!");
            } else {
                break;
            }
        }

        System.out.println("Chọn ID position: ");
        List<Position> positions = positionController.findAll();
        String poID;
        while (true) {
            for (Position position : positions) {
                System.out.println("ID: " + position.getPositionID() + ", PositionName: " + position.getPositionName());
            }
            poID = sc.nextLine();
            boolean checkExists = checkExistPosition(positions, poID);
            if (!checkExists) {
                System.out.println("Chọn sai, chọn lại!");
            } else {
                break;
            }
        }
        boolean check = accountController.create(email, userName, fullName, Integer.parseInt(depID), Integer.parseInt(poID));
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }


    public  void deleteAccount() {
        System.out.println("Nhập id cần xóa: ");
        int id = sc.nextInt();
        boolean check = accountController.delete(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public  void updateAccount() {
        System.out.println("Nhập ID cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        String email;
        while (true) {
            boolean check = true;
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            System.out.println("Nhập email cần sửa: ");
            email = sc.nextLine();
            // kiem tra tinh dung dan cua email
            if (Objects.isNull(email)
                    || email.trim().isEmpty()
                    || !email.matches(regex)) {

                System.out.println("Email không hợp lệ");
                check = false;
            }
            if (accountController.checkExistEmail(email, id)) {// kiem tra email da ton tai chua
                System.out.println("Email này đã tồn tại. Nhập lại email khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        String userName;
        while (true) {
            boolean check = true;
            System.out.println("Nhập username cần sửa: ");
            userName = sc.nextLine();
            // kiem tra tinh dung dan cua user name
            if (Objects.isNull(userName) || email.trim().isEmpty()) {
                System.out.println("User Name không hợp lệ");
                check = false;
            }
            if (accountController.checkExistUserName(userName, id)) {// kiem tra user name da ton tai chua
                System.out.println("User Name này đã tồn tại. Nhập lại User Name khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        System.out.println("Nhập fullName cần sửa: ");
        String fullName = sc.nextLine();
        System.out.println("Chọn ID department cần sửa: ");
        List<Department> departments = departmentController.findAll();
        String depID;
        while (true) {
            for (Department department : departments) {
                System.out.println("ID: " + department.getDepartmentID() + ", DepartmentName: " + department.getDepartmentName());
            }
            depID = sc.nextLine();
            boolean checkExists = checkExistDepartment(departments, depID);
            if (!checkExists) {
                System.out.println("Chọn sai, chọn lại!");
            } else {
                break;
            }
        }

        System.out.println("Chọn ID position cần sửa: ");
        List<Position> positions = positionController.findAll();
        String poID;
        while (true) {
            for (Position position : positions) {
                System.out.println("ID: " + position.getPositionID() + ", PositionName: " + position.getPositionName());
            }
            poID = sc.nextLine();
            boolean checkExists = checkExistPosition(positions, poID);
            if (!checkExists) {
                System.out.println("Chọn sai, chọn lại!");
            } else {
                break;
            }
        }
        boolean check = accountController.update(id, email ,fullName, userName, Integer.parseInt(depID), Integer.parseInt(poID));
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }

    public  boolean checkExistDepartment(List<Department> departments, String id) {
        for (Department department : departments) {
            if (id.equals(String.valueOf(department.getDepartmentID()))) {
                return true;
            }
        }
        return false;
    }

    public  boolean checkExistPosition(List<Position> positions, String id) {
        for (Position position : positions) {
            if (id.equals(String.valueOf(position.getPositionID()))) {
                return true;
            }
        }
        return false;
    }
}
