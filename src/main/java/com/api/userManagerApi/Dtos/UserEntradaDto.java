package com.api.userManagerApi.Dtos;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Size

public class UserEntradaDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;


}
