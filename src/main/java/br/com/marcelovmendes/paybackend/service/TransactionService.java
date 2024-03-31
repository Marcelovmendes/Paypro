package br.com.marcelovmendes.paybackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcelovmendes.paybackend.exception.InvalidTransactionExeption;
import br.com.marcelovmendes.paybackend.exception.NotfoundUserException;
import br.com.marcelovmendes.paybackend.model.Transaction;
import br.com.marcelovmendes.paybackend.repository.TransactionRepository;
import br.com.marcelovmendes.paybackend.repository.WalletRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final MockAuthorizeService authorizeService;
    private final NotificationService notificationService;

    public TransactionService(TransactionRepository transactionRepository, MockAuthorizeService authorizeService,
            WalletRepository walletRepository, NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.authorizeService = authorizeService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction create(Transaction transaction) {

        validateTransaction(transaction);

        var newTransaction = transactionRepository.save(transaction);

        var wallet = walletRepository.findById(transaction.payer()).get();
        walletRepository.save(wallet.debit(transaction.value()));

        authorizeService.authorize(transaction);
        notificationService.notify(transaction);

        return newTransaction;
    }

    private void validateTransaction(Transaction transaction) {
        var payer = walletRepository.findById(transaction.payer())
                .orElseThrow(() -> new NotfoundUserException("Payer not found: " + transaction.payer()));
        var payee = walletRepository.findById(transaction.payee())
                .orElseThrow(() -> new NotfoundUserException("Payee not found: " + transaction.payee()));

        if (payer.balance().compareTo(transaction.value()) < 0) {
            throw new InvalidTransactionExeption("Insufficient balance - %s".formatted(payer.balance()));
        }
        if (payer.type() != 1) {
            throw new InvalidTransactionExeption("Payer is not a store - %s".formatted(payer.type()));
        }
        if (payer.id().equals(payee.id())) {
            throw new InvalidTransactionExeption("Payer and payee are the same");
        }

    }
}