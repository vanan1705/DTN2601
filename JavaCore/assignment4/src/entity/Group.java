package entity;

import java.util.Date;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private Account[] accounts;
    private Date createDate;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    //a) Constructor không có parameters
    public Group() {}

    //b) Constructor có GroupName, Creator, Account, CreateDate
    public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    //c) Constructor có String[] usernames
    public Group(String groupName, Account creator, String[] userNames, Date createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;

        this.accounts = new Account[userNames.length];

        for (int i = 0; i < userNames.length; i++) {
            Account acc = new Account();
            acc.setUserName(userNames[i]);
            // các field khác = null
            this.accounts[i] = acc;
        }
    }
}
