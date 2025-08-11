package com.as.common.models.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CommonResultModel {
    private HttpStatus statusCode;
    private String message;
}
