package com.as.common.models.input;

import com.as.common.models.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CreateTransactionInputModel extends CommonInputModel {
    private int fromAccountId;
    private int toAccountId;
    private int amount;
    private Currency currency;
}
