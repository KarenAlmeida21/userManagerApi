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
    @Size(min = 2, max = 10)
    private String login;
    @NotBlank
    @Size(min  =5, max = 12)
    private String password;


}
