package com.as.common.models.result;

import com.as.common.models.commons.IdModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountResultModel extends CommonResultModel{
    private IdModel account;
}
