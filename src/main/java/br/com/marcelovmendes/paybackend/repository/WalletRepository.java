package br.com.marcelovmendes.paybackend.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.marcelovmendes.paybackend.model.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long>{
    
}
