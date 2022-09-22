package com.api.userManagerApi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntradaDto {
    @NotNull
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;


}
