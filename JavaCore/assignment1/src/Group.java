import java.util.Date;

public class Group {
    int groupID;
    String groupName;
    Account account;
    Date createDate;

    public Group(int groupID, String groupName, Account account, Date createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.account = account;
        this.createDate = createDate;
    }
}
