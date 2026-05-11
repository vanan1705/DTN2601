package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPositon;
import entity.Account;
import entity.Department;
import entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner sc = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        List<Account> accountList = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Xóa account theo tên");
            System.out.println("4. Update account theo ID");
            System.out.println("5. Tìm kiếm account theo ID và user name");
            System.out.println("6. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<Department> departmentList = QLDepartment.getAllDeparment();
                    QLDepartment.printDepartments(departmentList);
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

    public static void findByIdAndName() throws ClassNotFoundException {
        System.out.println("Nhập tên ID account cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập user name account cần tìm: ");
        String name = sc.nextLine();

        List<Account> accounts = QLAccount.findByAccountIdAndName(id, name);
        QLAccount.printAccounts(accounts);
    }


    public static void insertAccount() {
        System.out.println("Nhập user name: ");
        String userName = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập full name: ");
        String fullName = sc.nextLine();
        System.out.println("Nhập id phòng ban theo danh sách phòng ban có sẵn sau: ");
        List<Department> departmentList =QLDepartment.getAllDeparment();
        QLDepartment.printDepartments(departmentList);
        int departmentId = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập id chức vụ theo danh sách chức vụ có sẵn sau: ");
        List<Position> positions = QLPositon.getAllPosition();
        QLPositon.printPositions(positions);
        int positionId = sc.nextInt();


        boolean check = QLAccount.insertAccount(email, userName, fullName, departmentId, positionId);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void deleteAccount() {
        System.out.println("Nhập user name cần xóa: ");
        String name = sc.nextLine();
        boolean check = QLAccount.deleteAccount(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public static void updateAccount() {
        System.out.println("Nhập tên ID account cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập email bạn muốn thay đổi: ");
        String email = sc.nextLine();
        System.out.println("Nhập user name bạn muốn thay đổi: ");
        String userName = sc.nextLine();
        System.out.println("Nhập full name bạn muốn thay đổi: ");
        String fullName = sc.nextLine();
        System.out.println("Nhập id phòng ban bạn muốn thay đổi trong danh sách sau: ");
        List<Department> departmentList =QLDepartment.getAllDeparment();
        QLDepartment.printDepartments(departmentList);
        int departmentId = sc.nextInt();
        System.out.println("Nhập id chức vụ bạn muốn thay đổi trong danh sách sau: ");
        List<Position> positions = QLPositon.getAllPosition();
        QLPositon.printPositions(positions);
        int positionId = sc.nextInt();

        boolean check = QLAccount.updateAccount(id, email, fullName, userName, departmentId, positionId);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
