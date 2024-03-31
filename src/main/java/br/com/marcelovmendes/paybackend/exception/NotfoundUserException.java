package br.com.marcelovmendes.paybackend.exception;

public class NotfoundUserException extends RuntimeException {

    public NotfoundUserException(String message) {
        super(message);
    }

}
