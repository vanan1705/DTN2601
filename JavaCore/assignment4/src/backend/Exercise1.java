package backend;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;
import enums.PositionEnum;

import java.util.Date;

public class Exercise1 {
    //Question 1:
    //Tạo constructor cho department:
    //a) Không có parameters
    //b) Có 1 parameter là nameDepartment và default id của Department = 0
    //Khởi tạo 1 Object với mỗi constructor ở trên

    public static void question1(){
        Department department1 = new Department();
        department1.setDepartmentID(1);
        department1.setDepartmentName("Department1");

        Department department2 =new Department("Department2");
    }

    //Question 2:
    //Tạo constructor cho Account:
    //a) Không có parameters
    //b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName =
    //FirstName + LastName)
    //c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName =
    //FirstName + LastName) và Position của User, default createDate = now
    //d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName =
    //FirstName + LastName) và Position của User, createDate.
    //Khởi tạo 1 Object với mỗi constructor ở trên.
    public static void question2(){
        Account acc1 = new Account();
        Account acc2 = new Account(
                1,
                "user1@gmail.com",
                "user1",
                "Nguyen",
                "An"
        );
        Position pos = new Position(1, PositionEnum.PM);
        Account acc3 = new Account(
                2,
                "user2@gmail.com",
                "user2",
                "Tran",
                "Binh",
                pos
        );

        Account acc4 = new Account(
                3,
                "user3@gmail.com",
                "user3",
                "Le",
                "Cuong",
                pos,
                new Date()
        );
    }

    //Question 3:
    //Tạo constructor cho Group:
    //a) Không có parameters
    //b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
    //c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
    //Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin
    //còn lại = null).
    //Khởi tạo 1 Object với mỗi constructor ở trên.

    public static void question3() {
        Account creator = new Account(1, "admin@gmail.com", "admin", "Nguyen", "Admin");

        Group group1 = new Group();

        Account[] accounts = new Account[2];
        accounts[0] = new Account(2, "user1@gmail.com", "user1", "Tran", "A");
        accounts[1] = new Account(3, "user2@gmail.com", "user2", "Le", "B");

        Group group2 = new Group(
                "Java Fresher",
                creator,
                accounts,
                new Date()
        );

        String[] usernames = {"user3", "user4", "user5"};

        Group group3 = new Group(
                "Angular Team",
                creator,
                usernames,
                new Date()
        );
    }
}
