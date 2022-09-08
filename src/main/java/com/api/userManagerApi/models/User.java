package com.api.userManagerApi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter


@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
