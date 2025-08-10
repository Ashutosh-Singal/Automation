package com.as.common.models.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class RestRequest {

    private String url;
    private Map<String, String> headers;
    private Map<String, ?> queryParams;
    private Map<String, ?> pathParams;
    private Object body;

}
