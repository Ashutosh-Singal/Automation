package com.as.common.models.result;

import com.as.common.models.commons.TransactionDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TransactionDetailResultModel extends CommonResultModel{
    private List<TransactionDetails> transaction;
}
