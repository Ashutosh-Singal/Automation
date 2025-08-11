package com.as.common.models.result;

import com.as.common.models.commons.IdModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CreateTransactionResultModel extends CommonResultModel{
    private boolean success;
    private IdModel transaction;
}
