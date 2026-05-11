package frontend;

import backend.QLDepartment;
import entity.Department;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static backend.QLDepartment.getDeparmentWithMaxEmmployee;
import static backend.QLDepartment.getDeparmentWithMinEmmployee;

public class DepartmentFunction {
    private static Scanner sc = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        List<Department> departments = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds department");
            System.out.println("2. Thêm mới department");
            System.out.println("3. Xóa department theo tên");
            System.out.println("4. Update department theo ID");
            System.out.println("5. Tìm kiếm department theo ID và tên phòng ban");
            System.out.println("6. In ra department có nhiều nhân viên nhất");
            System.out.println("7. In ra department có ít nhân viên nhất");
            System.out.println("8. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<Department> departmentList =QLDepartment.getAllDeparment();
                    QLDepartment.printDepartments(departmentList);
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
                    getDeparmentWithMaxEmmployee();
                    break;
                case "7":
                    getDeparmentWithMinEmmployee();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public static void findByIdAndName() throws ClassNotFoundException {
        System.out.println("Nhập tên ID phòng ban cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine();

        List<Department> departments = QLDepartment.findByDeparmentIdAndName(id, name);
        QLDepartment.printDepartments(departments);
    }


    public static void insertDepartment() {
        System.out.println("Nhập tên phòng ban: ");
        String name = sc.nextLine();
        boolean check = QLDepartment.insertDerpartment(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void deleteDepartment() {
        System.out.println("Nhập tên phòng ban cần xóa: ");
        String name = sc.nextLine();
        boolean check = QLDepartment.deleteDerpartment(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public static void updateDepartment() {
        System.out.println("Nhập tên ID phòng ban cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban muốn thay đổi: ");
        String name = sc.nextLine();

        boolean check = QLDepartment.updateDepartment(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
