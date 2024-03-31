package br.com.marcelovmendes.paybackend.repository;

import org.springframework.data.repository.ListCrudRepository;
import br.com.marcelovmendes.paybackend.model.Transaction;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long>{
    
}
