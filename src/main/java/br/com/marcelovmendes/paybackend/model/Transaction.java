package br.com.marcelovmendes.paybackend.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("transactions")
public record Transaction(
    @Id Long id,
    Long payer,
    Long payee,
    BigDecimal value,
    LocalDateTime createdAt) {
    
}
