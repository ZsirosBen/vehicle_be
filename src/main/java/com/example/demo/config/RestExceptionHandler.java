package com.example.demo.config;

import com.example.demo.dtos.ErrorDto;
import com.example.demo.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class} )
    @ResponseBody
    public ResponseEntity<ErrorDto> handleExceptions(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage()));
    }
}
