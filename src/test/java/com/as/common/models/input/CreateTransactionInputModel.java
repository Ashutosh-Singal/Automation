package com.as.common.models.input;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CreateTransactionInputModel{
    private long fromAccountId;
    private long toAccountId;
    private BigDecimal amount;
    private Currency currency;
}
