package model;

public class Person {
    private String name;
    private String email;
    private String mobile;
    private String dobYear;

    public Person(String name, String email, String mobile, String dobYear) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dobYear = dobYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }
}
