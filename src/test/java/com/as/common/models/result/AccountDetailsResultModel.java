package com.as.common.models.result;

import com.as.common.models.commons.AccountDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetailsResultModel extends CommonResultModel{
    private List<AccountDetails> accounts;
}
