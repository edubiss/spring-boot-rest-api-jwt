package com.spring.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends ResponseStatusException{

    public EntityNotFoundException(String entidade) {
        super(HttpStatus.NOT_FOUND, "Entidade não encontrada " + entidade);
    }
}
