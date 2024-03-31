package br.com.marcelovmendes.paybackend.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("wallets")
public record Wallet(
      @Id Long id,
      String fullname,
      Long cpf,
      String email,
      String password,
      int type,
      BigDecimal balance) {

   public Wallet debit(BigDecimal value) {
      return new Wallet(id, fullname, cpf, email, password, type, balance.subtract(value));
   }
}
