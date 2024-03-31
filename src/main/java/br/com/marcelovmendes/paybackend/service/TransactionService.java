package br.com.marcelovmendes.paybackend.service;

import org.springframework.stereotype.Service;

import br.com.marcelovmendes.paybackend.model.Transaction;
import br.com.marcelovmendes.paybackend.repository.TransactionRepository;
import br.com.marcelovmendes.paybackend.repository.WalletRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;

    public TransactionService(TransactionRepository transactionRepository, WalletRepository walletRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    public Transaction create(Transaction transaction) {

        validate(transaction);

        var newTransaction = transactionRepository.save(transaction);

        var wallet = walletRepository.findById(transaction.payer()).get();

        walletRepository.save(wallet.debit(transaction.value()));
        return newTransaction;
    }

    private void validate(Transaction transaction) {
        if (transaction.payer().equals(transaction.payee())) {
            throw new IllegalArgumentException("Payer and payee must be different");
        }
        var payer = walletRepository.findById(transaction.payer()).get();
        if (payer.balance().compareTo(transaction.value()) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if (payer.type() == 2) {
            throw new IllegalArgumentException("Payer is a shopkeeper");

        }
    }
}
