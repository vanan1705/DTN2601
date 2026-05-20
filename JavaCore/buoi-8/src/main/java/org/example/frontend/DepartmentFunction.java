package org.example.frontend;

import org.example.backend.controller.DeparmentController;
import org.example.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class DepartmentFunction {

    DeparmentController departmentController = new DeparmentController();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        List<Department> departments = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds department");
            System.out.println("2. Thêm mới department");
            System.out.println("3. Xóa department theo id");
            System.out.println("4. Update department theo ID");
            System.out.println("5. Tìm kiếm department theo ID và tên phòng ban");
            System.out.println("6. In ra department có nhiều nhân viên nhất");
            System.out.println("7. In ra department có ít nhân viên nhất");
            System.out.println("8. Import phòng ban từ file csv");
            System.out.println("9. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    departments = departmentController.findAll();
                    this.showDepartment(departments);
                    break;
                case "2":
                    insertDepartment();
                    break;
                case "3":
                    deleteDepartment();
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

    //  địa chỉ lưu file  D:\input_department.csv
    private void importDepartmentToCSV() {
        System.out.println("Nhập địa chỉ file cần import: ");
        String pathName = sc.nextLine();
        String message = departmentController.importDepartmentToCSV(pathName);
        System.out.println(message);
    }

    public void showDepartment(List<Department> departments) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (Department department : departments) {
            System.out.printf("|%5s|%20s|\n", department.getDepartmentID(), department.getDepartmentName());
        }
        if (departments.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }

    public void insertDepartment() {
        String name;
        while (true) {
            boolean check = true;
            System.out.println("Nhập tên phòng ban: ");
            name = sc.nextLine();
            // kiem tra tinh dung dan cua ten phong ban
            if (Objects.isNull(name) || name.trim().isEmpty()) {//name.isEmpty() check xem đọ dài = 0
                System.out.println("Ko đc để trống. Nhập lại tên");
                check = false;
            }
            if (departmentController.checkExistName(name, null)) {// kiem tra xem ten da ton tai chua
                System.out.println("Tên này đã tồn tại. Nhập lại tên khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        boolean check = departmentController.create(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public void deleteDepartment() {
        System.out.println("Nhập ID phòng ban cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean check = departmentController.delete(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public void updateDepartment() {
        System.out.println("Nhập tên ID phòng ban cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        // bắt validation cho id
        String name;
        while (true) {
            boolean check = true;
            System.out.println("Nhập tên phòng ban muốn thay đổi: ");
            name = sc.nextLine();
            // kiem tra tinh dung dan cua ten phong ban
            if (Objects.isNull(name) || name.trim().isEmpty()) {//name.isEmpty() check xem đọ dài = 0
                System.out.println("Ko đc để trống. Nhập lại tên");
                check = false;
            }
            if (departmentController.checkExistName(name, id)) {// kiem tra xem ten da ton tai chua
                System.out.println("Tên này đã tồn tại. Nhập lại tên khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        boolean check = departmentController.update(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }

    public void findByIdAndName()  {
        System.out.println("Nhập tên ID phòng ban cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine();
        List<Department> departments = departmentController.findByIdAndName(id, name);
        showDepartment(departments);
    }
}
