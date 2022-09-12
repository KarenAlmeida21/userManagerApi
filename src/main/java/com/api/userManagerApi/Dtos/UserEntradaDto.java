package com.api.userManagerApi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntradaDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;


}
