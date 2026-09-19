package com.educandoweb.workshopmongo.services.exceptions;

import com.educandoweb.workshopmongo.resources.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
            ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Não encontrado";

        StandardError err = new StandardError(
                System.currentTimeMillis(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
