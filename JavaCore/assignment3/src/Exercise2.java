import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exercise2 {
    //Question 1:
    //Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi tạo 5 phần tử
    //theo cú pháp (sử dụng vòng for để khởi tạo):
    // Email: "Email 1"
    // Username: "User name 1"
    // FullName: "Full name 1"
    // CreateDate: now

    public static void question1(){
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Account acc = new Account();
            acc.email = "Email " + (i + 1);
            acc.userName = "User name " + (i + 1);
            acc.fullName = "Full name " + (i + 1);
            acc.createDate = new Date();

            accounts.add(acc);
        }
    }
}
