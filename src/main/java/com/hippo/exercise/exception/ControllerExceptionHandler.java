package com.hippo.exercise.exception;

import com.hippo.exercise.model.ClientErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResultException.class)
    public ResponseEntity<ClientErrorResponse> resultException(RuntimeException ex, WebRequest request) {
        ClientErrorResponse message = new ClientErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getLocalizedMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ClientErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        ClientErrorResponse message = new ClientErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
