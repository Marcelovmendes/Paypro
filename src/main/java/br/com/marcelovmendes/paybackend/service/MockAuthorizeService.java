package br.com.marcelovmendes.paybackend.service;

import org.springframework.stereotype.Service;

import br.com.marcelovmendes.paybackend.exception.UnauthorizedTransactionException;
import br.com.marcelovmendes.paybackend.model.Transaction;

@Service
public class MockAuthorizeService {

    public void authorize(Transaction transaction) {

        Authorization response = new Authorization("Authorized");

        if (!response.isAuthorized()) {
            throw new UnauthorizedTransactionException("Unauthorized transaction");
        }
    }

    record Authorization(String message) {
        public boolean isAuthorized() {
            return message.equals("Authorized");
        }
    }
}
