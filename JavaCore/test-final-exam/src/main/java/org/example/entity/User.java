package org.example.entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private float expInYear;
    private String proSkill;

    public User(int id, String fullName, String email, String password, float expInYear, String proSkill) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public User(){};

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public float getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(float expInYear) {
        this.expInYear = expInYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
