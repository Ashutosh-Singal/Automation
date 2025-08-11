package com.as.common.models.commons;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountDetails {
    private int id;
    private String owner;
    private int balance;
    private Currency currency;
    private String createdAt;
}
