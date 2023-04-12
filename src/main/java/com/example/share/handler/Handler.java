package com.example.share.handler;

import com.example.share.exceptions.users.AuthorizationError;
import com.example.share.exceptions.users.RegistrationError;
import com.example.share.exceptions.users.TokenError;
import com.example.share.responses.SharedErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(RegistrationError.class)
    public ResponseEntity<SharedErrorResponse> registrationErrorHandler(RegistrationError ex){
        return ResponseEntity.status(422).body(new SharedErrorResponse(false, List.of(ex.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<SharedErrorResponse> validationFiledFailHandler(MethodArgumentNotValidException ex){
        return ResponseEntity.status(422)
                .body(new SharedErrorResponse(false, ex.getFieldErrors().stream()
                        .map(p->String.format("Поле %s %s", p.getField(), p.getDefaultMessage())).toList()));
    }

    @ExceptionHandler(TokenError.class)
    public ResponseEntity<SharedErrorResponse> tokenErrorHandler(TokenError ex){
        return ResponseEntity.status(403).body(new SharedErrorResponse(false, List.of(ex.getMessage())));
    }

    @ExceptionHandler(AuthorizationError.class)
    public ResponseEntity<SharedErrorResponse> authorizationFailedHandler(AuthorizationError ex){
        return ResponseEntity.status(401).body(new SharedErrorResponse(false, List.of(ex.getMessage())));
    }
}
