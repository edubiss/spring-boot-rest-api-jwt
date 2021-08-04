package com.spring.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FieldRequiredException extends ResponseStatusException{

    public FieldRequiredException(String entidade) {
        super(HttpStatus.BAD_REQUEST, "Campo obrigatório não informado: " + entidade);
    }
}
