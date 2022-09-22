package com.api.userManagerApi.config.controller;

import com.api.userManagerApi.config.LoginForm;
import com.api.userManagerApi.Dtos.TokenDto;
import com.api.userManagerApi.config.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class autenticacaoController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;

    //logica de autenticacao
    @PostMapping
    public ResponseEntity <TokenDto>autenticar(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try{Authentication authentication = authManager.authenticate(dadosLogin);
            //geracao do token
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);
         return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();

        }
    }
}
