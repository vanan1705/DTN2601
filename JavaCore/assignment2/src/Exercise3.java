
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise3 {
    //Question 1:
    //In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
    //dạng vietnamese

    public static void question1(Exam exam) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(exam.createDate));
    }

    //Question 2:
    //In ra thông tin: Exam đã tạo ngày nào theo định dạng
    //Năm – tháng – ngày – giờ – phút – giây

    public static void question2(Exam exam) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        System.out.println(sdf.format(exam.createDate));
    }

    //Question 3:
    //Chỉ in ra năm của create date property trong Question 2

    public static void question3(Exam exam) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy");
        System.out.println(sdf.format(exam.createDate));
    }

    //Question 4:
    //Chỉ in ra tháng và năm của create date property trong Question 2

    public static void question4(Exam exam) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM");
        System.out.println(sdf.format(exam.createDate));
    }

    //Question 5:
    //Chỉ in ra &quot;MM-DD&quot; của create date trong Question 2

    public static void question5(Exam exam) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("MM-dd");
        System.out.println(sdf.format(exam.createDate));
    }
}
