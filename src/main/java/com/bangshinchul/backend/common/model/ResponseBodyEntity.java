package com.bangshinchul.backend.common.model;

import lombok.Data;

@Data
public class ResponseBodyEntity {
    private String statusCode;
    private String message;
}
