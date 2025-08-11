package com.as.common.models.result;

import com.as.common.models.commons.TransactionDetails;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TransactionDetailsResultModel extends CommonResultModel{
    private List<TransactionDetails> transactions;
}
