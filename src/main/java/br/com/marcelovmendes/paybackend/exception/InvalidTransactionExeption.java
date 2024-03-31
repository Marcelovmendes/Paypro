package br.com.marcelovmendes.paybackend.exception;

/**
 * InvalidTransactionExeption
 */
public class InvalidTransactionExeption extends RuntimeException{
   
    public InvalidTransactionExeption(String message) {
        super(message);
    }
     
}