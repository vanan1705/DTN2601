package org.example.frontend;

import org.example.backend.controller.UserController;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserFunction {
    UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        List<User> users = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách user");
            System.out.println("2. Tìm kiếm user theo id");
            System.out.println("3. Xóa user theo id");
            System.out.println("4. Tạo user mới");
            System.out.println("5. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    users = userController.findAll();
                    this.showUser(users);
                    break;
                case "2":
                    findById();
                    break;
                case "3":
                    deleteUser();
                    break;
                case "4":
                    updateDepartment();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    showDepartment( departmentController.getDeparmentWithMaxEmployee());
                    break;
                case "7":
                    showDepartment( departmentController.getDeparmentWithMinEmployee());
                    break;
                case "8":
                    this.importDepartmentToCSV();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public void showUser(List<User> users) {
        System.out.println("+-----+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|\n", "ID", "FullName", "Email");
        System.out.println("+-----+--------------------+--------------------+");
        for (User user : users) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", user.getId(), user.getFullName(), user.getEmail();
        }
        if (users.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+--------------------+");
    }

    public  void findById() {
        System.out.println("Nhập tên ID user cần tìm: ");
        int id = sc.nextInt();

        List<User> users = userController.findById(id);
        showUser(users);
    }

    public  void deleteUser() {
        System.out.println("Nhập id cần xóa: ");
        int id = sc.nextInt();
        boolean check = userController.delete(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public void insertUser() {
        String fullName;
        while (true) {
            boolean check = true;
            System.out.println("Nhập full name: ");
            fullName = sc.nextLine();
            if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {//name.isEmpty() check xem đọ dài = 0
                System.out.println("Ko đc để trống. Nhập lại full name");
                check = false;
            }
            if (departmentController.checkExistName(fullName, null)) {// kiem tra xem ten da ton tai chua
                System.out.println("Tên này đã tồn tại. Nhập lại tên khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        boolean check = departmentController.create(fullName);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }
}
