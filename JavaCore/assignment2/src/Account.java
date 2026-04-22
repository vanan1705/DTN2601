import java.util.Date;

public class Account {
    int accountID;
    String email;
    String userName;
    String fullName;
    Department department;
    Position position;
    Date createDate;

    public Account(int accountID, String email, String userName, String fullName, Department department, Position position, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    public Account() {
    }
}
