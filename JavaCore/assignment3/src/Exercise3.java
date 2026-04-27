import java.util.Date;

public class Exercise3 {
    //Question 1:
    //Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
    //Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau
    //dấu thập phân).

    public static void question1(){
        Integer salaryInt = 5000;
        float salaryFloat = salaryInt.floatValue(); // convert sang float
        System.out.printf("Lương: %.2f", salaryFloat);
    }

    //Question 2:
    //Khai báo 1 String có value = &quot;1234567&quot;
    //Hãy convert String đó ra số int
    public static void question2(){
        String numberText = "1234567";
        int number = Integer.parseInt(numberText);
        System.out.println("Số int: " + number);
    }

    //Question 3:
    //Khởi tạo 1 số Integer có value là chữ &quot;1234567&quot;
    //Sau đó convert số trên thành datatype int

    public static void question3(){
        Integer numberObj = Integer.valueOf("1234567");
        int number = numberObj;
        System.out.println("Giá trị int: " + number);
    }
}
