package com.api.userManagerApi.config.services;

import com.api.userManagerApi.models.User;
import com.api.userManagerApi.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    //injecao de parametros doaplication properties
    @Value("${forum.jwt.expiration}")
    private String experation;

    @Value("${forum.jwt.secret}")
    private String secret;


//gerar token
    public String gerarToken(Authentication authentication) {
        User logado = (User) authentication.getPrincipal();
        Date hoje = new Date();
        Date dateExpiration = new Date(hoje.getTime() + Long.parseLong(experation));

        return Jwts.builder()
                .setIssuer("API UserManager")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dateExpiration)
                .signWith( SignatureAlgorithm.HS256,secret)
                .compact();
    }
}
