package com.api.userManagerApi.Dtos;

public class UserLoginDto {
    private String login;
    private String password;

    public UserLoginDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
