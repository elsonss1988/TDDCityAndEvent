package com.devsuperior.bds02.resources.exceptions;

import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> entityNotFound(ResourceNotFoundException e,HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err= new StandartError();
        err.setMessage("Entidades nao encontradas");
        err.setPath(request.getRequestURI());
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> dataBaseException(DataBaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError();
        err.setError(e.getMessage());
        err.setMessage("Dados Invalidos");
        err.setStatus(status.value());
        err.setTimestamp(Instant.now());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
