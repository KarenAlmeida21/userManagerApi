package com.api.userManagerApi.Dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter

public class UserSaidaDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String login;


}
