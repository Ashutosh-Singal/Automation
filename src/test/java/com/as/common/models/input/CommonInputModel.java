package com.as.common.models.input;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CommonInputModel {
    private String testCaseName;
    private int apiVersion;
}
