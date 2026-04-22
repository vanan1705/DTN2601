import java.util.Date;

public class Question {
    int questionID;
    String content;
    CategoryQuestion categoryQuestion;
    TypeQuestion typeQuestion;
    Account account;
    Date createDate;

    public Question(int questionID, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion, Account account, Date createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryQuestion = categoryQuestion;
        this.typeQuestion = typeQuestion;
        this.account = account;
        this.createDate = createDate;
    }
}
