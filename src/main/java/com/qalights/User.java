package com.qalights;

/**
 * User login class model
 */
public class User {
    private String userLogin;
    private String userPassword;

    public User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public User setUserLogin(String userLogin) {
        this.userLogin = userLogin;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public User setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userLogin != null ? !userLogin.equals(user.userLogin) : user.userLogin != null) return false;
        return userPassword != null ? userPassword.equals(user.userPassword) : user.userPassword == null;
    }

    @Override
    public int hashCode() {
        int result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
