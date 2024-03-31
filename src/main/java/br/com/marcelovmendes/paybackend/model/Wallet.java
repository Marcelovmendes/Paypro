package br.com.marcelovmendes.paybackend.wallet;

import org.springframework.data.annotation.Id;

public record Wallet(
    @Id Long id,
    String fullname,
    Long cpf,
    String email,
    String password,
    int type,
    BigDecimal balance){}
