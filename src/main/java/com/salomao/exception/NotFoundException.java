package com.salomao.exception;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serial;

@ApplicationScoped
public class NotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = -5563897357984895396L;

    public NotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }

}
