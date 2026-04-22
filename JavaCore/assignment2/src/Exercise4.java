
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Exercise4 {
    //Question 1:
    //In ngẫu nhiên ra 1 số nguyên

    public static void question1() {
        Random rd = new Random();
        int number = rd.nextInt();
        System.out.println("Số nguyên ngẫu nhiên: " + number);
    }

    //Question 2:
    //In ngẫu nhiên ra 1 số thực

    public static void question2() {
        Random rd = new Random();
        double number = rd.nextDouble();
        System.out.println("Số thực ngẫu nhiên: " + number);
    }

    //Question 3:
    //Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1
    //bạn
    public static void question3(Account[] accounts) {
        Random rd = new Random();
        int number = rd.nextInt(accounts.length);
        System.out.println("Tên của bạn ngẫu nhiên là: " + accounts[number].fullName);
    }

    //Question 4:
    //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
    public static void question4() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            long start = sdf.parse("24-07-1995").getTime();
            long end = sdf.parse("20-12-1995").getTime();
            Random rd = new Random();
            long randomTime = rd.longs(start, end)
                    .findFirst()
                    .getAsLong();
            Date randomDate = new Date(randomTime);
            System.out.println("Ngày ngẫu nhiên: "
                    + sdf.format(randomDate));

        } catch (Exception e) {
            System.out.println("Lỗi xử lý ngày");
        }
    }

    //Question 5:
    //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây

    public static void question5() {
        try {
            long now = new Date().getTime();
            long start = now - 365 * 24 * 60 * 60 * 1000;
            Random rd = new Random();
            long randomTime = rd.longs(start, now)
                    .findFirst()
                    .getAsLong();
            Date randomDate = new Date(randomTime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Ngày ngẫu nhiên: " + sdf.format(randomDate));
        } catch (Exception e) {
            System.out.println("Lỗi xử lý");
        }
    }

    //Question 6:
    //Lấy ngẫu nhiên 1 ngày trong quá khứ.
    public static void question6() {
        try {
            long now = new Date().getTime();
            long start = 0;
            Random rd = new Random();
            long randomTime = rd.longs(start, now)
                    .findFirst()
                    .getAsLong();
            Date randomDate = new Date(randomTime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Ngày ngẫu nhiên trong quá khứ: "
                    + sdf.format(randomDate));
        } catch (Exception e) {
            System.out.println("Lỗi xử lý");
        }
    }

    //Question 7:
    //Lấy ngẫu nhiên 1 số có 3 chữ số.
    public static void question7() {
        Random rd = new Random();
        int number = rd.nextInt(100, 1000);
        System.out.println("Số nguyên ngẫu nhiên có 3 chữ số: " + number);
    }


}
