package com.bangshinchul.backend.auth.mapper;

import lombok.Data;

@Data
public class SignUpRequestBodyDTO {
    private String email;
    private String name;
}
