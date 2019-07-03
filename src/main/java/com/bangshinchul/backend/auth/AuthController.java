package com.bangshinchul.backend.auth;

import com.bangshinchul.backend.auth.mapper.AuthMapper;
import com.bangshinchul.backend.auth.mapper.SignUpDesignerDTO;
import com.bangshinchul.backend.auth.mapper.SignUpRequestBodyDTO;
import com.bangshinchul.backend.auth.mapper.SignUpUserDTO;
import com.bangshinchul.backend.common.model.ResponseBodyEntity;
import com.bangshinchul.backend.common.model.StatusCodeEntity;
import com.bangshinchul.backend.common.utils.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    AuthMapper authMapper;

    @GetMapping("/login")
    public String signIn(@RequestHeader HttpHeaders header) {
//    public String signIn(@RequestHeader HttpHeaders header,
//                                      final HttpServletRequest request,
//                                      final HttpServletResponse response) {
        log.debug("]-----] AuthController.login::call::GET[-----[");
        String getHeader = header.getFirst("Authorization");
        if(getHeader != null) {
//            response.setStatus(HttpServletResponse.SC_OK); // 200 return
//            response.addHeader("WWW-Authenticate", "Basic Authorization=" + getHeader + "");
            return "Login Success! GET : " + getHeader;
        }else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 return
            return "Please try Basic Auth Login! : GET";
        }
    }

    @PostMapping("/login")
    public String signInPost(@RequestHeader HttpHeaders header) {
        log.debug("]-----] AuthController.login::call::POST[-----[");
        String getHeader = header.getFirst("Authorization");
        if(getHeader != null) {
            return "Login Success! POST : " + getHeader;
        }else {
            return "Please try Basic Auth Login! : POST";
        }
    }

//    @PostMapping("/login")
//    public String login(@RequestHeader HttpHeaders header) {
//        log.debug("]-----] AuthController.login::call [-----[");
//
//        String getHeader = header.getFirst("Authorization");
//
//        // UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        // Authentication authentication = authenticationManager.authenticate(token);
//        // SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        if(getHeader != null){
//            return "Login Success! POST : " + getHeader;
//        }else{
//            return "Please try Basic Auth Login! : POST";
//        }
//    }

//    @PostMapping("/login")
//    public String login(@RequestBody Auth request) {
//        log.debug("]-----] AuthController.login::call [-----[");
//
//        String username = request.getUsername();
//        String password = request.getPassword();
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return "Login Success!";
//    }

    @PostMapping("/login-basic")
    public String loginBasic(@AuthenticationPrincipal Auth request) {
        return "welcome user " + request.getUsername();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/db-test")
    public Auth test() {
        return authRepository.findByUsername("user");
    }

    @GetMapping("/login-success")
    public String signInSuccess() {
        return "Hello world!";
    }

    @GetMapping("/login-error")
    public String signInError() {
        return "Login error occur!!";
    }

    @GetMapping("/username-check")
    public String usernameValidation(String username) {
        log.info("]-----] usernameValidation CALL [-----[ : {}", username);
        String result = authMapper.findUsernameByUsername(username);
        if (!result.isEmpty()) {
            return "already use";
        } else {
            return "not use";
        }
    }


    @PutMapping("/signup")
    @ResponseBody
    public ResponseBodyEntity signUp(@RequestHeader HttpHeaders header, @RequestBody SignUpRequestBodyDTO dataset) {
        ResponseBodyEntity resBodyEntity = new ResponseBodyEntity();
        log.info("]-----] signUp Basic Auth [-----[ : {} ", header.get("Authorization"));
        String authorization = header.get("Authorization").get(0);

        Auth decodeAuth = HashUtil.basicToken(authorization);
        log.info(">>>>>>>>>>>> username: {} , password: {} ", decodeAuth.getUsername(), decodeAuth.getPassword());
        log.info(">>>>>>>>>>>> email: {} , name: {} ", dataset.getEmail(), dataset.getName());

        //username 중복확인
        String usernameValidation = authMapper.findUsernameByUsername(decodeAuth.getUsername());
        if (usernameValidation != null) {
            log.info(">>>>>>>>>>>> username '{}' is already used!", decodeAuth.getUsername());
            resBodyEntity.setStatusCode(StatusCodeEntity.FAIL);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        } else {
            log.info(">>>>>>>>>>>> username '{}' is not used!", decodeAuth.getUsername());

            // 회원가입 진행

            resBodyEntity.setStatusCode(StatusCodeEntity.OK);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        }
    }

    @PutMapping("/signup/user")
    @ResponseBody
    public ResponseBodyEntity signUpUser(@RequestHeader HttpHeaders header, @RequestBody SignUpUserDTO dataset) {
        ResponseBodyEntity resBodyEntity = new ResponseBodyEntity();
        log.info("]-----] signUp Basic Auth [-----[ : {} ", header.get("Authorization"));
        String authorization = header.get("Authorization").get(0);

        Auth decodeAuth = HashUtil.basicToken(authorization);
        log.info(">>>>>>>>>>>> username: {} , password: {} ", decodeAuth.getUsername(), decodeAuth.getPassword());
        log.info(">>>>>>>>>>>> params: {} ", dataset.toString());

        //username 중복확인
        String usernameValidation = authMapper.findUsernameByUsername(decodeAuth.getUsername());
        if (usernameValidation != null) {
            log.info(">>>>>>>>>>>> username '{}' is already used!", decodeAuth.getUsername());
            resBodyEntity.setStatusCode(StatusCodeEntity.FAIL);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        } else {
            log.info(">>>>>>>>>>>> username '{}' is not used!", decodeAuth.getUsername());

            // 회원가입 진행

            resBodyEntity.setStatusCode(StatusCodeEntity.OK);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        }
    }

    @PutMapping("/signup/designer")
    @ResponseBody
    public ResponseBodyEntity signUpDesigner(@RequestHeader HttpHeaders header, @RequestBody SignUpDesignerDTO dataset) {
        ResponseBodyEntity resBodyEntity = new ResponseBodyEntity();
        log.info("]-----] signUp Basic Auth [-----[ : {} ", header.get("Authorization"));
        String authorization = header.get("Authorization").get(0);

        Auth decodeAuth = HashUtil.basicToken(authorization);
        log.info(">>>>>>>>>>>> username: {} , password: {} ", decodeAuth.getUsername(), decodeAuth.getPassword());
        log.info(">>>>>>>>>>>> params: {} ", dataset.toString());

        //username 중복확인
        String usernameValidation = authMapper.findUsernameByUsername(decodeAuth.getUsername());
        if (usernameValidation != null) {
            log.info(">>>>>>>>>>>> username '{}' is already used!", decodeAuth.getUsername());
            resBodyEntity.setStatusCode(StatusCodeEntity.FAIL);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        } else {
            log.info(">>>>>>>>>>>> username '{}' is not used!", decodeAuth.getUsername());

            // 회원가입 진행

            resBodyEntity.setStatusCode(StatusCodeEntity.OK);
            resBodyEntity.setMessage("username " + decodeAuth.getUsername() + " is already used!");
            return resBodyEntity;
        }
    }
}
