package com.api.userManagerApi.config;

import com.api.userManagerApi.exceptions.MensagemErro;
import com.api.userManagerApi.exceptions.UserExistente;
import com.api.userManagerApi.exceptions.UserInexistente;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

    public List<MensagemErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<MensagemErro> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemErro mensagemErro = new MensagemErro(fieldError.getDefaultMessage());
            erros.add(mensagemErro);
        }

        return erros;
    }

    @ExceptionHandler(UserInexistente.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    public MensagemErro userNaoEncontrado(UserInexistente exception){
        return new MensagemErro((exception.getMessage()));
    }


    @ExceptionHandler(UserExistente.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public MensagemErro userJaCadastrado(UserExistente exception){
        return new MensagemErro((exception.getMessage()));
    }




}
