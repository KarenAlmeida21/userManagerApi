package com.api.userManagerApi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class UserFilterDto {
    @Id
    private Long id;
    private String login;
    private String password;
}
