package br.com.marcelovmendes.paybackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleExeption {

    @ExceptionHandler({ InvalidTransactionExeption.class })
    public ResponseEntity<Object> handleInvalidTransaction(InvalidTransactionExeption e) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler({ NotfoundUserException.class })
    public ResponseEntity<Object> handleNotfoundUser(NotfoundUserException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

}
