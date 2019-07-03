package com.bangshinchul.backend.auth.mapper;
import lombok.Data;

@Data
public class SignUpBaseEntity {
    /*
    - 이메일주소
    - 이름
    - 성별
    * */
    private Long authId;
    private String name; // 이름
    private String email; // 이메일
    private String gender; // M:남자 or W:여자
}
