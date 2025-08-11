package com.as.common.models.input;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountInputModel{
    private String owner;
    private BigDecimal balance;
    private Currency currency;
}
