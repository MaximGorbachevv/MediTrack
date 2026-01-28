package com.poject2.meditrack.exception;

import com.poject2.meditrack.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collection;
import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundExeption ex) {
       ErrorResponse error = new ErrorResponse(
               "RESOURCE_NOT_FOUND",
               ex.getMessage(), java.util.Collections.emptyMap()
       );
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
