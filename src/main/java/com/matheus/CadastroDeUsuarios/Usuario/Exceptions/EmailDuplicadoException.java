package com.matheus.CadastroDeUsuarios.Usuario.Exceptions;

public class EmailDuplicadoException extends RuntimeException{
    public EmailDuplicadoException(String mensagem){
        super(mensagem);
    }
}
