import java.util.Date;

public class Exam {
    int examID;
    String code;
    String title;
    CategoryQuestion categoryQuestion;
    int duration;
    Account account;
    Date createDate;

    public Exam(int examID, String code, String title, CategoryQuestion categoryQuestion, int duration, Account account, Date createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.account = account;
        this.createDate = createDate;
    }
}
