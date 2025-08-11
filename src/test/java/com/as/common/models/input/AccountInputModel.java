package com.as.common.models.input;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountInputModel extends CommonInputModel{
    private String owner;
    private int balance;
    private Currency currency;
}
