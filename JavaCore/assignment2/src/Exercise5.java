import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
    //Question 1:
    //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình.
    public static void question1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thứ 1: ");
        int a = sc.nextInt();
        System.out.print("Nhập số thứ 2: ");
        int b = sc.nextInt();
        System.out.print("Nhập số thứ 3: ");
        int c = sc.nextInt();
        System.out.println("Bạn đã nhập: " + a + ", " + b + ", " + c);
    }

    //Question 2:
    //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình.

    public static void question2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thực thứ 1: ");
        double a = sc.nextDouble();
        System.out.print("Nhập số thực thứ 2: ");
        double b = sc.nextDouble();
        System.out.println("Bạn đã nhập: " + a + " và " + b);
    }

    //Question 3:
    //Viết lệnh cho phép người dùng nhập họ và tên.

    public static void question3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();
        System.out.println("Họ và tên của bạn là: " + fullName);
    }

    //Question 4:
    //Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ.
    public static void question4() {
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            System.out.print("Nhập ngày sinh theo định dạng dd-MM-yyy: ");
            Date d = sdf.parse(sc.nextLine());

            System.out.println(sdf.format(d));
        } catch (Exception e) {
            System.out.println("Sai format");
        }
    }

    //Question 5:
    //Viết lệnh cho phép người dùng tạo account (viết thành method)
    //Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
    //chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster,
    //Position.PM.

    public static Account question5() {
        Scanner sc = new Scanner(System.in);
        Account acc= new Account();
        System.out.print("Nhập AccountID: ");
        acc.accountID = sc.nextInt();
        System.out.print("Nhập Email: ");
        acc.email = sc.nextLine();
        System.out.print("Nhập Username: ");
        acc.userName = sc.nextLine();
        System.out.print("Nhập FullName: ");
        acc.fullName = sc.nextLine();

        System.out.print("Chọn Position (1.Dev, 2.Test, 3.ScrumMaster, 4.PM): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                acc.position.positionName = PositionEnum.DEV;
                break;
            case 2:
                acc.position.positionName = PositionEnum.TEST;
                break;
            case 3:
                acc.position.positionName = PositionEnum.SCRUM_MASTER;
                break;
            case 4:
                acc.position.positionName = PositionEnum.PM;
                break;
            default:
                System.out.println("Chọn sai, mặc định Dev");
                acc.position.positionName = PositionEnum.DEV;
        }

        return acc;
    }

    //Question 6:
    //Viết lệnh cho phép người dùng tạo department (viết thành method)

    public static Department question6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập DepartmentID: ");
        int departmentID = sc.nextInt();
        System.out.print("Nhập DepartmentName: ");
        String departmentName = sc.nextLine();

        Department department =new Department(departmentID,departmentName);

        return department;
    }

    //Question 7:
    //Nhập số chẵn từ console

    public static void question7() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Nhập 1 số chẵn: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number % 2 == 0) {
                    System.out.println("Số chẵn bạn vừa nhập là: " + number);
                    break;
                } else {
                    System.out.println("Đây không phải số chẵn, nhập lại!");
                }
            } else {
                System.out.println("Vui lòng nhập số nguyên!");
                sc.next();
            }
        }
    }

    //Question 8:
    //Viết chương trình thực hiện theo flow sau:
    //Bước 1:Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
    //Bước 2:
    //Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
    //Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
    //department
    //Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1

    public static void question8() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
            System.out.println("Tạo account nhập số 1");
            System.out.println("Tạo department nhập số 2");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                switch (number){
                    case 1:
                        question5();
                        break;
                    case 2:
                        question6();
                        break;
                    default:
                        System.out.println("Mời bạn nhập lại");
                }
            } else {
                System.out.println("Vui lòng nhập số nguyên!");
                sc.next();
            }
        }
    }

    //Question 9:
    //Viết method cho phép người dùng thêm group vào account theo flow sau:
    //Bước 1: In ra tên các usernames của user cho người dùng xem
    //Bước 2: Yêu cầu người dùng nhập vào username của account
    //Bước 3: In ra tên các group cho người dùng xem
    //Bước 4: Yêu cầu người dùng nhập vào tên của group
    //Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account
    //vào group đó .

    public static void question9(Account[] accounts, Group[] groups) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.userName);
        }

        System.out.print("Nhập username: ");
        String inputUsername = sc.nextLine();

        Account selectedAccount = null;
        for (Account acc : accounts) {
            if (acc.userName.equals(inputUsername)) {
                selectedAccount = acc;
                break;
            }
        }

        if (selectedAccount == null) {
            System.out.println("Không tìm thấy account!");
            return;
        }

        System.out.println("Danh sách group:");
        for (Group g : groups) {
            System.out.println("- " + g.groupName);
        }

        System.out.print("Nhập tên group: ");
        String inputGroup = sc.nextLine();

        Group selectedGroup = null;
        for (Group g : groups) {
            if (g.groupName.equals(inputGroup)) {
                selectedGroup = g;
                break;
            }
        }

        if (selectedGroup == null) {
            System.out.println("Không tìm thấy group!");
            return;
        }

        GroupAccount groupAccount = new GroupAccount(selectedGroup,selectedAccount,new Date());

    }

    //Question 10: Tiếp tục Question 8 và Question 9
    //Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
    //account
    //Bổ sung thêm Bước 3 của Question 8 như sau:
    //Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi
    //người dùng &quot;Bạn có muốn thực hiện chức năng khác không?&quot;. Nếu người dùng chọn &quot;Có&quot;
    //thì quay lại bước 1, nếu người dùng chọn &quot;Không&quot; thì kết thúc chương trình (sử dụng lệnh
    //return để kết thúc chương trình).

    public static void question10(Account[] accounts, Group[] groups) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
            System.out.println("Tạo account nhập số 1");
            System.out.println("Tạo department nhập số 2");
            System.out.println("Thêm Account vào Group nhập số 3");

            int number;
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Vui lòng nhập số!");
                sc.next();
                continue;
            }

            switch (number) {
                case 1:
                    question5();
                    break;
                case 2:
                    question6();
                    break;
                case 3:
                    question9(accounts, groups);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
                    continue;
            }

            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Kết thúc chương trình!");
                return;
            }
        }
    }
    public static void addAccountToRandomGroup(Account[] accounts, Group[] groups) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.userName);
        }

        System.out.print("Nhập username: ");
        String inputUsername = sc.nextLine();

        Account selectedAccount = null;
        for (Account acc : accounts) {
            if (acc.userName.equals(inputUsername)) {
                selectedAccount = acc;
                break;
            }
        }

        if (selectedAccount == null) {
            System.out.println("Không tìm thấy account!");
            return;
        }
        Random rd = new Random();
        int randomGroup = rd.nextInt(groups.length);

        GroupAccount groupAccount = new GroupAccount(groups[randomGroup],selectedAccount,new Date());

    }

    //Question 11: Tiếp tục Question 10
    //Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu
    //nhiên, chức năng sẽ được cài đặt như sau:
    //Bước 1: In ra tên các usernames của user cho người dùng xem
    //Bước 2: Yêu cầu người dùng nhập vào username của account
    //Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
    //Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên

    public static void question11(Account[] accounts, Group[] groups) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
            System.out.println("Tạo account nhập số 1");
            System.out.println("Tạo department nhập số 2");
            System.out.println("Thêm Account vào Group nhập số 3");
            System.out.println("Thêm Account Group ngẫu nhiên nhập số 4");

            int number;
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Vui lòng nhập số!");
                sc.next();
                continue;
            }

            switch (number) {
                case 1:
                    question5();
                    break;
                case 2:
                    question6();
                    break;
                case 3:
                    question9(accounts, groups);
                    break;
                case 4:
                    addAccountToRandomGroup(accounts, groups);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
                    continue;
            }

            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Kết thúc chương trình!");
                return;
            }
        }
    }
}
