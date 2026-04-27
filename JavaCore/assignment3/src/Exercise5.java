import java.util.Arrays;
import java.util.Comparator;

public class Exercise5 {
    //Question 1:
    //In ra thông tin của phòng ban thứ 1 (sử dụng toString())
    public static void question1(Department department){
        department.toString();
    }

    //Question 2:
    //In ra thông tin của tất cả phòng ban (sử dụng toString())

    public static void question2(Department[] departmentList){
        for (Department department:departmentList){
            department.toString();
        }
    }

    //Question 3:
    //In ra địa chỉ của phòng ban thứ 1 (Do chưa tạo thuộc tính địa chỉ của phòng ban nên e đã in tạm ra tên phòng ban)
    public static void question3(Department department){
        System.out.println("Tên phòng ban: "+department.departmentName);
    }

    //Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
    public static void question4(Department department, String name){
        if (department == null || name == null){
            System.out.println("Thông tin đưa vào bị sai");
            return;
        }
        if (department.departmentName.equals(name)){
            System.out.println("Phòng ban trên trùng với tên so sánh");
        }else {
            System.out.println("Phòng ban trên ko trùng với tên so sánh");
        }
    }

    //Question 5:
    //So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi
    //tên của 2 phòng ban đó bằng nhau)

    public static void question5(Department department1, Department department2){
        if (department1 == null || department2 == null){
            System.out.println("Thông tin đưa vào bị sai");
            return;
        }
        if (department1.departmentName.equals(department2.departmentName)){
            System.out.println("Hai phòng ban trên bằng nhau");
        }else {
            System.out.println("Hai phòng ban trên không bằng nhau");
        }
    }

    //Question 6:
    //Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo
    //thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
    //VD:
    //Accounting
    //Boss of director
    //Marketing
    //Sale
    //Waiting room

    public static void question6(Department[] departmentList){
        Arrays.sort(departmentList, new Comparator<Department>() {
            public int compare(Department d1, Department d2) {
                return d1.departmentName.compareTo(d2.departmentName);
            }
        });

        for (Department d : departmentList) {
            System.out.println(d.departmentName);
        }
    }

    //Question 7: tương tự Question 6


}
