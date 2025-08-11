package com.as.common.models.commons;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TransactionDetails {
    private long id;
    private long fromAccountId;
    private long toAccountId;
    private BigDecimal amount;
    private Currency currency;
    private String createdAt;
}
