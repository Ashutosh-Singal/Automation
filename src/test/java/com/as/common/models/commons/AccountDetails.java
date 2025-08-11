package com.as.common.models.commons;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountDetails {
    private long id;
    private String owner;
    private BigDecimal balance;
    private Currency currency;
    private String createdAt;
}
