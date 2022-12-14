package com.summerproject.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String mobile_no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String mobile_no) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile_no=" + mobile_no +
                '}';
    }
}
