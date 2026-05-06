package backend;

import entity.VietnamesePhone;

import java.util.Scanner;

public class Exercise6 {
    //Question 1: abstract class &amp; abstract method
    //Tạo 1 class Phone để lưu thông tin liên lạc, trong Phone có chứa 1 property có kiểu dữ liệu
    //là Array contacts, trong từng contact có lưu thông tin number, name
    //a) Tạo các abstract method
    //a. void insertContact(String name, String phone)
    //b. void removeContact(String name)
    //c. void updateContact(String name, String newPhone)
    //d. void searchContact(String name)
    //b) Tạo class VietnamesePhone kế thừa Phone và triển khai các method abstract
    //Viết chương trình demo.

    public static void question1 () {
        Scanner scanner = new Scanner(System.in);

        VietnamesePhone phone = new VietnamesePhone();

        while(true)

        {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Them contact");
            System.out.println("2. Xoa contact");
            System.out.println("3. Cap nhat contact");
            System.out.println("4. Tim contact");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Thoat");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhap so dien thoai: ");
                    String phoneNumber = scanner.nextLine();

                    phone.insertContact(name, phoneNumber);

                    break;

                case 2:

                    System.out.print("Nhap ten can xoa: ");
                    String removeName = scanner.nextLine();

                    phone.removeContact(removeName);

                    break;

                case 3:

                    System.out.print("Nhap ten can update: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Nhap so moi: ");
                    String newPhone = scanner.nextLine();

                    phone.updateContact(updateName, newPhone);

                    break;

                case 4:

                    System.out.print("Nhap ten can tim: ");
                    String searchName = scanner.nextLine();

                    phone.searchContact(searchName);

                    break;

                case 5:

                    phone.displayContacts();

                    break;

                default:
                    System.out.println("Thoat chuong trinh!");
                    return;
            }
        }
    }

}
