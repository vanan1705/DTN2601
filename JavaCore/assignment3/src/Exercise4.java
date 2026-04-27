import java.util.List;
import java.util.Scanner;

public class Exercise4 {
    //Question 1:
    //Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau
    //bằng nhiều khoảng trắng );

    public static void question1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        str = str.trim();

        if (str.isEmpty()) {
            System.out.println("Số lượng từ: 0");
        } else {
            String[] words = str.split("\\s+");
            System.out.println("Số lượng từ: " + words.length);
        }
    }

    //Question 2:
    //Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;

    public static void question2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi 1: ");
        String str1 = sc.nextLine();
        System.out.print("Nhập chuỗi 2: ");
        String str2 = sc.nextLine();
        String str3 =str1 + " " + str2;

        System.out.printf("Nội dung chuỗi 1 và 2 là: '%s'",str3);
    }

    //Question 3:
    //Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chữ viết hoa chữ cái
    //đầu thì viết hoa lên.

    public static void question3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập họ tên của bạn: ");
        String name = sc.nextLine();
        name = name.trim().toLowerCase();
        if (name.isEmpty()) {
            System.out.println("Tên không hợp lệ!");
            return;
        }

        String[] words = name.split("\\s+");
        String result = "";

        for (String word : words) {

            String capitalized = word.substring(0, 1).toUpperCase()
                    + word.substring(1);
            result += capitalized + " ";
        }
        result = result.trim();
        System.out.println("Tên sau khi chuẩn hóa: " + result);
    }

    //Question 4:
    //Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
    //VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra
    //"Ký tự thứ 1 là: N";
    //"Ký tự thứ 1 là: A";
    //"Ký tự thứ 1 là: M";

    public static void question4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên của bạn: ");
        String name = sc.nextLine();
        name = name.trim();
        if(name.isEmpty()){
            System.out.println("Tên bị trống");
            return;
        }
        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: "
                    + name.substring(i, i + 1));
        }
    }

    //Question 5:
    //Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên
    //và hệ thống sẽ in ra họ và tên đầy đủ.

    public static void question5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập họ tên đệm của bạn: ");
        String lastName = sc.nextLine();
        System.out.println("Vui lòng nhập tên của bạn: ");
        String firstName = sc.nextLine();
        System.out.println("Họ và tên của bạn là: "+lastName.trim()+" "+firstName.trim());
    }

    //Question 6:
    //Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ
    //tách ra họ, tên , tên đệm
    //VD:
    //Người dùng nhập vào "Nguyễn Văn Nam"
    //Hệ thống sẽ in ra
    //"Họ là: Nguyễn"
    //"Tên đệm là: Văn"
    //"Tên là: Nam"

    public static void question6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập họ và tên của bạn: ");
        String hoVaTen = sc.nextLine().trim();

        if (hoVaTen.isEmpty()) {
            System.out.println("Tên bị trống");
            return;
        }

        String[] words = hoVaTen.split("\\s+");

        if (words.length == 1) {
            System.out.println("Tên là: " + words[0]);
        }
        else if (words.length == 2) {
            System.out.println("Họ là: " + words[0]);
            System.out.println("Tên là: " + words[1]);
        }
        else {
            String ho = words[0];
            String ten = words[words.length - 1];

            String tenDem = "";
            for (int i = 1; i < words.length - 1; i++) {
                tenDem += words[i] + " ";
            }

            System.out.println("Họ là: " + ho);
            System.out.println("Tên đệm là: " + tenDem.trim());
            System.out.println("Tên là: " + ten);
        }
    }

    //Question 7:
    //Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và
    //tên của họ như sau:
    //a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
    //VD: Nếu người dùng nhập vào &quot; nguyễn văn nam &quot; thì sẽ chuẩn hóa thành &quot;nguyễn văn
    //nam&quot;
    //b) Viết hoa chữ cái mỗi từ của người dùng
    //VD: Nếu người dùng nhập vào &quot; nguyễn văn nam &quot; thì sẽ chuẩn hóa thành &quot;Nguyễn
    //Văn Nam&quot;

    /// ĐÃ làm tương tự question 3

    //Question 8:
    //In ra tất cả các group có chứa chữ "Java"

    public static void question8(List<GroupAccount> groupAccounts){
        for (GroupAccount groupAccount : groupAccounts) {
            if (groupAccount.group.groupName.contains("java")) {
                System.out.println(groupAccount);
            }
        }
    }

    //Question 9:
    //In ra tất cả các group &quot;Java&quot;

    public static void question9(List<GroupAccount> groupAccounts){
        for (GroupAccount groupAccount : groupAccounts) {
            if (groupAccount.group.groupName.equals("java")) {
                System.out.println(groupAccount);
            }
        }
    }

    //Question 10:
    //Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
    //Nếu có xuất ra “OK” ngược lại “KO”.
    //Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.

    public static void question10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi 1: ");
        String s1 = sc.nextLine();

        System.out.print("Nhập chuỗi 2: ");
        String s2 = sc.nextLine();

        String reversed = new StringBuilder(s1).reverse().toString();

        if (reversed.equals(s2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
    }

    //Question 11: Count special Character
    //Tìm số lần xuất hiện ký tự &quot;a&quot; trong chuỗi

    public static void question11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của 'a': " + count);
    }

    //Question 12: Reverse String
    //Đảo ngược chuỗi sử dụng vòng lặp

    public static void question12() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        String reversed="";
        for (int i = str.length()-1; i >= 0; i--) {
            reversed+=str.charAt(i);
        }
        System.out.println("Chuỗi đảo ngược: " + reversed);
    }

    //Question 13:
    //String not contains digit
    //Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
    //Ví dụ:
    //"abc" => true
    //"1abc", "abc1", "123", "a1bc", null => false

    public static boolean question13(String str) {
        if (str == null) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    //Question 14: Replace character
    //Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
    //Ví dụ:
    //"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"

    public static void question14() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        System.out.print("Nhập ký tự cần thay: ");
        char oldChar = sc.nextLine().charAt(0);

        System.out.print("Nhập ký tự thay thế: ");
        char newChar = sc.nextLine().charAt(0);

        String result = str.replace(oldChar, newChar);

        System.out.println("Chuỗi sau khi thay: " + result);
    }

    //Question 15: Revert string by word
    //Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
    //Ví dụ: " I am developer " => "developer am I".
    //Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
    //Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách

    public static void question15() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine().trim();
        if (str.isEmpty()) {
            System.out.println("Tên bị trống");
            return;
        }

        String[] words = str.split("\\s+");
        String reversed="";
        for (int i = words.length-1; i >= 0; i--) {
            reversed+=words[i]+" ";
        }
        System.out.println("Chuỗi đảo ngược: " + reversed.trim());
    }

    //Question 16:
    //Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n
    //ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.

    public static void question16() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n phải >= 1");
            return;
        }
        if (str.length() % n != 0) {
            System.out.println("KO");
            return;
        }
        for (int i = 0; i < str.length(); i += n) {
            System.out.println(str.substring(i, i + n));
        }
    }
}
