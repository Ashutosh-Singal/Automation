package com.as.common.models.commons;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TransactionDetails {
    private int id;
    private int fromAccountId;
    private int toAccountId;
    private int amount;
    private Currency currency;
    private String createdAt;
}
