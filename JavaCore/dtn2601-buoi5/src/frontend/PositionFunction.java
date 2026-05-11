package frontend;

import backend.QLPositon;
import entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static backend.QLPositon.getPositionWithMaxEmmployee;
import static backend.QLPositon.getPositionWithMinEmmployee;

public class PositionFunction {
    private static Scanner sc = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        List<Position> positionList = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds Position");
            System.out.println("2. Thêm mới Position");
            System.out.println("3. Xóa Position theo tên");
            System.out.println("4. Update Position theo ID");
            System.out.println("5. Tìm kiếm Position theo ID và tên chức vụ");
            System.out.println("6. In ra Position có nhiều nhân viên nhất");
            System.out.println("7. In ra Position có ít nhân viên nhất");
            System.out.println("8. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<Position> positions = QLPositon.getAllPosition();
                    QLPositon.printPositions(positions);
                    break;
                case "2":
                    insertPositon();
                    break;
                case "3":
                    deletePositon();
                    break;
                case "4":
                    updatePositon();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    getPositionWithMaxEmmployee();
                    break;
                case "7":
                    getPositionWithMinEmmployee();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public static void findByIdAndName() throws ClassNotFoundException {
        System.out.println("Nhập tên ID chức vụ cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên chức vụ cần tìm: ");
        String name = sc.nextLine();

        List<Position> positions = QLPositon.findByPositionIdAndName(id, name);
        QLPositon.printPositions(positions);
    }


    public static void insertPositon() {
        System.out.println("Nhập tên chức vụ: ");
        String name = sc.nextLine();
        boolean check = QLPositon.insertPosition(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void deletePositon() {
        System.out.println("Nhập tên chức vụ cần xóa: ");
        String name = sc.nextLine();
        boolean check = QLPositon.deletePosition(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public static void updatePositon() {
        System.out.println("Nhập tên ID chức vụ cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên chức vụ muốn thay đổi: ");
        String name = sc.nextLine();

        boolean check = QLPositon.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
