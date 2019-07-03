package com.bangshinchul.backend.auth;

import com.bangshinchul.backend.auth.mapper.SignUpBaseEntity;

public interface AuthService {
    public Auth findByUsername(String username);

    public void signUp(SignUpBaseEntity data);
}
