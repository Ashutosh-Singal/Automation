package com.as.common.models.result;

import com.as.common.models.commons.AccountDetails;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AccountDetailsResultModel extends CommonResultModel{
    private List<AccountDetails> accounts;
}
