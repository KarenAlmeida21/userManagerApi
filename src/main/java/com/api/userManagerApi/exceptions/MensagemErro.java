package com.api.userManagerApi.exceptions;

public class MensagemErro {

    private String mensagem;
    public MensagemErro(String mensagem) {
        this.mensagem= mensagem;
    }

    public MensagemErro() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
