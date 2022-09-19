package com.api.userManagerApi.Dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class UserEntradaDto {
    @NotNull
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;


}
