package entity;

import java.util.Date;

public class Account {
    private int accountID;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String fullName;
    private Department department;
    private Position position;
    private double salary;
    private Date createDate;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    //a) Không có parameters
    public Account() {
    }

    //b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    public Account(int accountID, String email, String userName, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    //c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now


    public Account(int accountID, String email, String userName, String firstName, String lastName, Position position) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = new Date();
    }

    //d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName =
    //FirstName + LastName) và Position của User, createDate.

    public Account(int accountID, String email, String username, String firstName, String lastName, Position position, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = createDate;
    }
    
}
