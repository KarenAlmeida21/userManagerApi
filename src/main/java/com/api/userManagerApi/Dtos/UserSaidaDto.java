package com.api.userManagerApi.Dtos;

import javax.validation.constraints.NotBlank;

public class UserSaidaDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserSaidaDto() {
    }

    public UserSaidaDto(Long id, String login) {
        this.id = id;
        this.login = login;
    }
}
