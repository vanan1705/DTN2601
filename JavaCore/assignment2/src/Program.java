import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Department
        Department department1 = new Department(1, "Sale");
        Department department2 = new Department(2, "Marketing");
        Department department3 = new Department(3, "IT");

        // Position
        Position position1 = new Position(1, PositionEnum.DEV);
        Position position2 = new Position(2, PositionEnum.TEST);
        Position position3 = new Position(3, PositionEnum.PM);

        // Account
        Account account1 = new Account(1, "a@gmail.com", "user1", "Nguyen Van A", department1, position1, new Date());
        Account account2 = new Account(2, "b@gmail.com", "user2", "Nguyen Van B", department2, position2, new Date());
        Account account3 = new Account(3, "c@gmail.com", "user3", "Nguyen Van C", department3, position3, new Date());

        // Group
        Group group1 = new Group(1, "Java Group", account1, new Date());
        Group group2 = new Group(2, "Test Group", account2, new Date());
        Group group3 = new Group(3, "Dev Group", account3, new Date());

        // GroupAccount
        GroupAccount groupAccount1 = new GroupAccount(group1, account1, new Date());
        GroupAccount groupAccount2 = new GroupAccount(group2, account2, new Date());
        GroupAccount groupAccount3 = new GroupAccount(group3, account3, new Date());

        // TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion(1, TypeEnum.ESSAY);
        TypeQuestion typeQuestion2 = new TypeQuestion(2, TypeEnum.MULTIPLE_CHOICE);
        TypeQuestion typeQuestion3 = new TypeQuestion(3, TypeEnum.ESSAY);

        // Category
        CategoryQuestion categoryQuestion1 = new CategoryQuestion(1, "Java");
        CategoryQuestion categoryQuestion2 = new CategoryQuestion(2, "SQL");
        CategoryQuestion categoryQuestion3 = new CategoryQuestion(3, "Test");

        // Question
        Question question1 = new Question(1, "Java là gì?", categoryQuestion1, typeQuestion1, account1, new Date());
        Question question2 = new Question(2, "SQL dùng để làm gì?", categoryQuestion2, typeQuestion2, account2, new Date());
        Question question3 = new Question(3, "Test case là gì?", categoryQuestion3, typeQuestion3, account3, new Date());

        // Answer
        Answer answer1 = new Answer(1, "Ngôn ngữ lập trình", question1, true);
        Answer answer2 = new Answer(2, "Lưu trữ, truy xuất, thao tác và quản lý dữ liệu", question2, true);
        Answer answer3 = new Answer(3, "Là tài liệu cốt lõi giúp tester kiểm tra phần mềm theo kịch bản, đảm bảo chất lượng và phát hiện lỗi.", question3, true);

        // Exam
        Exam exam1 = new Exam(1, "EX01", "Java Basic", categoryQuestion1, 60, account1, new Date());
        Exam exam2 = new Exam(2, "EX02", "SQL Basic", categoryQuestion2, 45, account2, new Date());
        Exam exam3 = new Exam(3, "EX03", "Test Basic", categoryQuestion3, 30, account3, new Date());

        // ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion(exam1, question1);
        ExamQuestion eqxamQuestion2 = new ExamQuestion(exam2, question2);
        ExamQuestion examQuestion3 = new ExamQuestion(exam3, question3);

        // ===== IN RA =====
        Exercise1.question1(account1);

        Group[] listGroup= {group1,group2,group3};
        Exercise1.question2(account2,listGroup);

        Exercise1.question3(account1);

        Exercise1.question4(account1);

        GroupAccount[] listGroupAccounts ={groupAccount1,groupAccount2,groupAccount3};
        Exercise1.question5(group1,listGroupAccounts);

        Exercise1.question6(account2,listGroup);

        Exercise1.question7(account1);

        Account[] listAccount ={account1,account2,account3};
        Exercise1.question8(listAccount);

        Department[] listDepartment ={department1,department2,department3};
        Exercise1.question9(listDepartment);

        Exercise1.question10(listAccount);

        Exercise1.question11(listDepartment);

        Exercise1.question12(listDepartment);

        Exercise1.question13(listAccount);

        Exercise1.question14(listAccount);

        Exercise1.question15();

        Exercise2.question1(5);

        Exercise2.question2();

        Exercise2.question3();

        Exercise2.question4("Nguyễn Văn An");

        Exercise2.question5();

        Exercise3.question1(exam1);

        Exercise3.question2(exam1);

        Exercise3.question3(exam1);

        Exercise3.question4(exam1);

        Exercise3.question5(exam1);

        Exercise4.question1();
        Exercise4.question2();
        Exercise4.question3(listAccount);
        Exercise4.question4();
        Exercise4.question5();
        Exercise4.question6();
        Exercise4.question7();

        Exercise5.question1();
        Exercise5.question2();
        Exercise5.question3();
        Exercise5.question4();
        Exercise5.question5();
        Exercise5.question6();
        Exercise5.question7();
        Exercise5.question8();
        Exercise5.question9(listAccount,listGroup);
        Exercise5.question10(listAccount,listGroup);
        Exercise5.question11(listAccount,listGroup);

        Exercise6.question1();
        Exercise6.question3();
    }
}
