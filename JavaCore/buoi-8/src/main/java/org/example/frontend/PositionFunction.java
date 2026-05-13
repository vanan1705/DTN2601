package org.example.frontend;



import org.example.backend.controller.PositionController;
import org.example.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PositionFunction {
    PositionController positionController = new PositionController();
    private static Scanner sc = new Scanner(System.in);

    public void run() throws ClassNotFoundException {
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
                    positionList = positionController.findAll();
                    showPosition(positionList);
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
                    showPosition(positionController.getPositionWithMaxEmployee());
                    break;
                case "7":
                    showPosition(positionController.getPositionWithMinEmployee());
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }
    public void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position position : positions) {
            System.out.printf("|%5s|%20s|\n", position.getPositionID(), position.getPositionName());
        }
        if (positions.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }


    public void findByIdAndName() throws ClassNotFoundException {
        System.out.println("Nhập tên ID chức vụ cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên chức vụ cần tìm: ");
        String name = sc.nextLine();

        List<Position> positions = positionController.findByIdAndName(id, name);
        showPosition(positions);
    }


    public void insertPositon() {
        System.out.println("Nhập tên chức vụ: ");
        String name = sc.nextLine();
        boolean check = positionController.create(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public void deletePositon() {
        System.out.println("Nhập id chức vụ cần xóa: ");
        int id = sc.nextInt();
        boolean check = positionController.delete(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public void updatePositon() {
        System.out.println("Nhập tên ID chức vụ cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên chức vụ muốn thay đổi: ");
        String name = sc.nextLine();

        boolean check = positionController.update(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }

}
