package com.as.common.models.result;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AuthResultModel extends CommonResultModel{
    private String apiKey;
}
