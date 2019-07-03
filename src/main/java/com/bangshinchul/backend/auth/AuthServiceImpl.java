package com.bangshinchul.backend.auth;

import com.bangshinchul.backend.auth.mapper.AuthMapper;
import com.bangshinchul.backend.auth.mapper.SignUpBaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    private AuthRepository authRepository;
    private AuthMapper authMapper;

    public AuthServiceImpl(AuthRepository authRepository, AuthMapper authMapper) {
        this.authRepository = authRepository;
        this.authMapper = authMapper;
    }

    @Override
    public Auth findByUsername(String username) {
        return authRepository.findByUsername(username);
    }

    @Override
    public void signUp(SignUpBaseEntity data) {
        //username 중복확인
//        String usernameValidation = authMapper.findUsernameByUsername(username);
//        if (usernameValidation != null) {
//            log.info(">>>>>>>>>>>> username '{}' is already used!", username);
//            resBodyEntity.setStatusCode(StatusCodeEntity.FAIL);
//            resBodyEntity.setMessage("username " + username + " is already used!");
//            return resBodyEntity;
//        } else {
//            log.info(">>>>>>>>>>>> username '{}' is not used!", username);
//            resBodyEntity.setStatusCode(StatusCodeEntity.OK);
//            resBodyEntity.setMessage("username " + username + " is already used!");
//            return resBodyEntity;
//        }
    }
}
