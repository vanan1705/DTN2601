import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    //Question 1:
    //Khai báo 2 số lương có kiểu dữ liệu là float.
    //Khởi tạo Lương của Account 1 là 5240.5 $
    //Khởi tạo Lương của Account 2 là 10970.055$
    //Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
    //Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

    public static void question1(Account account){
        int salary = (int) account.salary;

        System.out.println("Salary Account: " + salary);
    }

    //Question 2:
    //Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho
    //đủ 5 chữ số)

    public static int question2() {
        Random random = new Random();
        int number = random.nextInt(100000);
        System.out.printf("Số ngẫu nhiên: %05d\n", number);

        return number;
    }

    //Question 3:
    //Lấy 2 số cuối của số ở Question 2 và in ra.
    //Gợi ý:
    //Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
    //Cách 2: chia lấy dư số đó cho 100

    public static void question3(int number){
        String str = String.format("%05d", number);
        String cach1 = str.substring(str.length() - 2);
        System.out.println("2 số cuối theo cách 1: " + cach1);

        int cach2 = number % 100;
        System.out.printf("2 số cuối theo cách 2: %02d", cach2);
    }

    //Question 4:
    //Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng.

    public static void question4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();
        float result = (float) a / b;
        System.out.println("Thương của số a và số b là: "+ result);
    }

}
