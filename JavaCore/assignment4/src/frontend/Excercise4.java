package frontend;

import entity.Student;

public class Excercise4 {

    public static void main(){
        Student st1 = new Student("An", "Ha Noi");
        Student st2 = new Student("Binh", "Da Nang");
        Student st3 = new Student("Cuong", "Hai Phong");

        st1.setScore(3.5f);

        st1.addScore(2);

        st2.setScore(7.5f);

        st3.setScore(8.5f);

        st1.printInfo();

        System.out.println("----------------");
    }
}
