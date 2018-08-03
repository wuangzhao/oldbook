package org.fd.entity;

import java.util.Date;

public class UserEntity {

    private int userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String useTel;

    private Date userBirthday;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUseTel() {
        return useTel;
    }

    public void setUseTel(String useTel) {
        this.useTel = useTel;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
