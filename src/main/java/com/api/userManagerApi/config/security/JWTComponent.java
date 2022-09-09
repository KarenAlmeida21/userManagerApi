package com.api.userManagerApi.config.security;

import com.api.userManagerApi.exceptions.TokenInvalidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JWTComponent {
    @Value("${SEGREDO_JWT}")
    private String segredo;
    @Value("${JWT_TIME}")
    private Long milissegundo;

    public String gerarToken(String login, Long id) {
        Date vencimento = new Date(System.currentTimeMillis() + milissegundo);

        String token = Jwts.builder().setSubject(login)
                .claim("idUser", id).setExpiration(vencimento).claim("aleatorio", "karen")
                .signWith(SignatureAlgorithm.HS512, segredo.getBytes()).compact();

        return token;
    }

    public Claims pegarClaims(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(segredo.getBytes()).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            throw new TokenInvalidoException();
        }
    }

    public boolean tokenValido(String token) {
        try {
            Claims claims = pegarClaims(token);
            Date dataAtual = new Date(System.currentTimeMillis());

            String username = claims.getSubject();
            Date vencimentoToken = claims.getExpiration();

            if (username != null && vencimentoToken != null && dataAtual.before(vencimentoToken)) {
                return true;
            } else {
                return false;
            }
        } catch (TokenInvalidoException e) {
            return false;

        }
    }
}
