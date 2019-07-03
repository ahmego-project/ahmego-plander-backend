package com.bangshinchul.backend.common.security.jwt;

import com.bangshinchul.backend.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * BaseSecurityHandler 에서는 Basic Auth로 인증이 성공한 경우
 * onAuthenticationSuccess 메서드 안의 내용을 실행합니다.
 * 실패한 경우에는 onAuthenticationFailure 메서드 안의 내용을 실행합니다.
 *
 * */

@Component
public class BaseSecurityHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) {

        UserDetails userDetails = new UserDetailsImpl(authentication.getPrincipal().toString(), new ArrayList<>(authentication.getAuthorities()));
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader(JwtInfo.HEADER_NAME, JwtUtil.createToken(userDetails));
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage());
    }
}
