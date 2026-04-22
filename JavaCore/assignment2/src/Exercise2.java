import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise2 {
    //Question 1:
    //Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
    //nguyên đó
    public static void question1(int number){
        System.out.printf("số %d là số nguyên.%n", number);
    }

    //Question 2:
    //Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
    //ra số nguyên đó thành định dạng như sau: 100,000,000
    public static void question2() {
        int number = 100000000;
        System.out.printf("%,d%n", number);
    }

    //Question 3:
    //Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
    //thực đó chỉ bao gồm 4 số đằng sau

    public static void question3() {
        double number = 5.567098;
        System.out.printf("%.4f%n", number);
    }

    //Question 4:
    //Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
    //dạng như sau:
    //Họ và tên: &quot;Nguyễn Văn A&quot; thì sẽ in ra trên console như sau:
    //Tên tôi là &quot;Nguyễn Văn A&quot; và tôi đang độc thân.

    public static void question4(String fullName) {
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.%n", fullName);
    }

    //Question 5:
    //Lấy thời gian bây giờ và in ra theo định dạng sau:
    //24/04/2020 11h:16p:20s

    public static void question5() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");
        System.out.println(now.format(formatter));
    }

    //Question 6:
    //In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
    //table (giống trong Database)
}
