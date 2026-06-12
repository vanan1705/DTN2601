package org.example.entity;

public class Lecturer {
    private int lecturerId;
    private String email;
    private String department;
    private String fullName;

    public Lecturer(int lecturerId, String email, String department, String fullName) {
        this.lecturerId = lecturerId;
        this.email = email;
        this.department = department;
        this.fullName = fullName;
    }
    public Lecturer() {
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
