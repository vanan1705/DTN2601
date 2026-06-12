package org.example.frontend;

import org.example.Common.StringCommon;
import org.example.backend.controller.LecturerController;
import org.example.backend.controller.MajorController;
import org.example.backend.controller.StudentController;
import org.example.entity.Lecturer;
import org.example.entity.Major;
import org.example.entity.Student;
import org.example.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.*;

public class Menu {
    static StudentController studentController = new StudentController();
    static MajorController majorController = new MajorController();
    static LecturerController lecturerController = new LecturerController();
    private static Scanner sc = new Scanner(System.in);
    public static void run() throws SQLException {
        List<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("+-------------------------------------------------+");
            System.out.println("|             MỜI BẠN CHỌN CHỨC NĂNG              |");
            System.out.println("+-------------------------------------------------+");
            System.out.println("| 1. Xem danh sách thông tin sinh viên            |");
            System.out.println("| 2. Thêm sinh viên mới                           |");
            System.out.println("| 3. Cập nhật chuyên ngành cho sinh viên          |");
            System.out.println("| 4. Xóa sinh viên theo ID                        |");
            System.out.println("| 5. Tìm kiếm sinh viên theo chuyên ngành         |");
            System.out.println("| 6. Tìm kiếm giảng viên theo ID                  |");
            System.out.println("| 7. Chức năng kiểm tra Password                  |");
            System.out.println("| 8. Exit                                         |");
            System.out.println("+-------------------------------------------------+");
            System.out.print("Nhập tùy chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    students = studentController.findAll();
                    showStudentTable(students);
                    break;
                case "2":
                    addStudent();
                    break;
                case "3":
                    updateMajorForStudent();
                    break;
                case "4":
                    deleteStudentById();
                    break;
                case "5":
                    findStudentByMajor();
                    break;
                case "6":
                    findLecturerById();
                    break;
                case "7":
                    verifyInputPassword();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    private static void showStudentTable(List<Student> list) { // hàm show ra thông tin của sinh viên
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        System.out.println("+-----+---------------------------+---------------------------+--------------+---------------------------+");
        System.out.println("| ID  | Họ và tên                 | Email                     | Ngày sinh    | Chuyên ngành              |");
        System.out.println("+-----+---------------------------+---------------------------+--------------+---------------------------+");
        for (Student s : list) {
            System.out.printf("| %-3d | %-25s | %-25s | %-12s | %-25s |\n",
                    s.getStudentId(), s.getFullName(), s.getEmail(), s.getDateOfBirth(), s.getMajor().getMajorName());
        }
        System.out.println("+-----+---------------------------+---------------------------+--------------+---------------------------+");
    }

    private static void addStudent() throws SQLException {
        System.out.print("Nhập Họ tên sinh viên: ");
        String fullName = ScannerUtils.inputString(); // kiểm tra input đầu vào có bị trống không

        System.out.print("Nhập Email sinh viên: ");
        String email = "";
        while (true) {
            email = ScannerUtils.inputEmail(); // kiểm tra định dạng email đầu vào
            if (studentController.checkExistsEmail(email)) {
                System.out.println("Email này đã được sử dụng. Nhập lại:");
                continue;
            }
            break;
        }


        System.out.print("Nhập Ngày sinh (định dạng YYYY-MM-DD): ");
        Date dateOfBirth = ScannerUtils.inputDate(); // kiểm tra định dạng đầu vào ngày tháng năm sinh

        List<Major> majors = majorController.findAll();
        System.out.print("Nhập ID Chuyên ngành trong danh sách sau: ");
        for (Major m : majors) {
            System.out.println("Mã ngành: " + m.getMajorId() + " | Tên ngành: " + m.getMajorName());
        }
        int majorId = -1;
        while (true) {
            majorId = ScannerUtils.inputID();  // kiểm tra id chuyên ngành người dùng nhập có đúng không
            if (!majorController.checkExistsId(majorId)) {
                System.out.println("Id không tồn tại trong hệ thống. Nhập lại:");
                continue;
            }
            break;
        }

        boolean check =studentController.create(fullName, email, dateOfBirth, majorId);
        if (check) {
            System.out.println("Thêm mới sinh viên thành công");
        } else {
            System.out.println("Thêm mới sinh viên thất bại");
        }
    }
    private static void updateMajorForStudent() throws SQLException {
        System.out.print("Nhập ID của sinh viên : ");
        int studentId = -1;
        while (true) {
            studentId = ScannerUtils.inputID();  // kiểm tra id người dùng nhập vào có đúng định dạng và có tồn tại không
            if (!studentController.checkExistsId(studentId)) {
                System.out.println("Id không tồn tại trong hệ thống. Nhập lại:");
                continue;
            }
            break;
        }

        System.out.print("Nhập ID của chuyên ngành : ");
        int majorId = -1;
        while (true) {
            majorId = ScannerUtils.inputID();  // kiểm tra id người dùng nhập vào có đúng định dạng và có tồn tại không
            if (!majorController.checkExistsId(majorId)) {
                System.out.println("ID này không tồn tại. Nhập lại:");
                continue;
            }
            break;
        }
        boolean check =studentController.updateMajor(studentId, majorId);
        if (check) {
            System.out.println("Cập nhật chuyên ngành thành công");
        } else {
            System.out.println("Cập nhật chuyên ngành thất bại");
        }

    }

    private static void deleteStudentById() throws SQLException {
        System.out.print("Nhập ID của sinh viên : ");
        int studentId = sc.nextInt();
        boolean check =studentController.deleteById(studentId);
        if (check) {
            System.out.println("Xóa sinh viên thành công");
        } else {
            System.out.println("Xóa sinh viên thất bại");
        }
    }

    private static void findStudentByMajor() throws SQLException {
        List<Major> majors = majorController.findAll();
        System.out.print("Nhập tên Chuyên ngành trong danh sách sau: ");
        for (Major m : majors) {
            System.out.println("Tên ngành: " + m.getMajorName());
        }
        String majorName = ScannerUtils.inputString();
        List<Student> students =studentController.findByMajor(majorName);
        showStudentTable(students);
    }
    private static void findLecturerById() throws SQLException {
        int lecturerId = ScannerUtils.inputID();
        Lecturer lecturer =lecturerController.findById(lecturerId);
        if (lecturer != null) {
            System.out.println("Đã tìm thấy giảng viên:");
            System.out.println("ID: " + lecturer.getLecturerId());
            System.out.println("Họ Tên: " + lecturer.getFullName());
            System.out.println("Email: " + lecturer.getEmail());
            System.out.println("Bộ môn: " + lecturer.getDepartment());
        } else {
            System.out.println("Không tìm thấy giảng viên nào");
        }
    }
    public static void verifyInputPassword() {
            String pass = sc.nextLine();
            if (pass == null || pass.trim().isEmpty() || !pass.matches(StringCommon.PASSWORD_REGEX)) {  // kiểm tra định dạng mật khẩu người dùng nhập có đúng theo yêu cầu không
                System.out.print("Password không hợp lệ");
                System.out.println("Yêu cầu bắt buộc:");
                System.out.println("   - Độ dài từ 8 đến 20 ký tự (không chứa khoảng trắng).");
                System.out.println("   - Phải có ít nhất: 1 chữ HOA, 1 chữ thường, 1 chữ số.");
                System.out.println("   - Phải có ít nhất 1 ký tự đặc biệt trong tập hợp: @ # $ % ^ & + !");
            } else {
                System.out.print("Password hợp lệ");
            }
        }
    }

