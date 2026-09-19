package com.educandoweb.workshopmongo.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 8400056346716122179L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
