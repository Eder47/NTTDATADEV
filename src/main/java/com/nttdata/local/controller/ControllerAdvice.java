package com.nttdata.local.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nttdata.local.clienteDto.ErrorDto;
import com.nttdata.local.excepciones.ExcepClienteNoExiste;


@RestControllerAdvice
public class ControllerAdvice {
	
    @ExceptionHandler(value = ExcepClienteNoExiste.class)
    public ResponseEntity<ErrorDto> businessExceptionHandler(ExcepClienteNoExiste ex){
    	ErrorDto error = ErrorDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
    

}
