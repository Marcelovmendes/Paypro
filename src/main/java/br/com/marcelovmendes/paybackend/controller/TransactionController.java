package br.com.marcelovmendes.paybackend.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelovmendes.paybackend.model.Transaction;
import br.com.marcelovmendes.paybackend.service.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }
    
}
