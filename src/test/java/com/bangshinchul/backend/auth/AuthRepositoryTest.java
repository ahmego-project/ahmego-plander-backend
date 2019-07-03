package com.bangshinchul.backend.auth;

import com.bangshinchul.backend.BackendApplicationTests;
import com.bangshinchul.backend.common.config.SecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
public class AuthRepositoryTest extends BackendApplicationTests {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthRoleRepository authRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * account_role 테이블에 INSERT하는 테스트코드
     * */
    @Test
    public void setRole() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ADMIN");
        roleRepository.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setRole("USER");
        roleRepository.save(roleUser);

        Role roleDesigner = new Role();
        roleDesigner.setRole("DESIGNER");
        roleRepository.save(roleDesigner);
    }

    @Test
    public void saveTest() {
        Auth authAdmin = new Auth();
        authAdmin.setUsername("admin");
        authAdmin.setPassword(passwordEncoder.encode("12345"));
        authRepository.save(authAdmin);

        Auth authUser = new Auth();
        authUser.setUsername("user");
        authUser.setPassword(passwordEncoder.encode("12345"));
        authRepository.save(authUser);

        Auth authDesigner = new Auth();
        authDesigner.setUsername("designer");
        authDesigner.setPassword(passwordEncoder.encode("12345"));
        authRepository.save(authDesigner);
        ////
        AuthRole authRoleAdmin = new AuthRole();
        authRoleAdmin.setRoleId(Long.valueOf(1));
        authRoleAdmin.setAuthId(authAdmin.getId());
        authRoleRepository.save(authRoleAdmin);

        AuthRole authRoleUser = new AuthRole();
        authRoleUser.setRoleId(Long.valueOf(2));
        authRoleUser.setAuthId(authUser.getId());
        authRoleRepository.save(authRoleUser);

        AuthRole authRoleDesigner = new AuthRole();
        authRoleDesigner.setRoleId(Long.valueOf(3));
        authRoleDesigner.setAuthId(authDesigner.getId());
        authRoleRepository.save(authRoleDesigner);
    }

    @Test
    public void saveAdminTest() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword(passwordEncoder.encode("12345"));
        authRepository.save(auth);

        Role roleAdmin = roleRepository.findByRole("ADMIN");

        AuthRole authRoleUser = new AuthRole();
        authRoleUser.setRoleId(roleAdmin.getId());
        authRoleUser.setAuthId(auth.getId());
        authRoleRepository.save(authRoleUser);
    }

    @Test
    public void saveUserTest() {
        Auth auth = new Auth();
        auth.setUsername("test123");
        auth.setPassword(passwordEncoder.encode("12345"));
        authRepository.save(auth);

        Role roleUser = roleRepository.findByRole("USER");

        AuthRole authRoleUser = new AuthRole();
        authRoleUser.setRoleId(roleUser.getId());
        authRoleUser.setAuthId(auth.getId());
        authRoleRepository.save(authRoleUser);
    }

    @Test
    public void saveDesignerTest() {
        Auth auth = new Auth();
        auth.setUsername("esther0728");
        auth.setPassword(passwordEncoder.encode("ms0728*"));
        authRepository.save(auth);

        Role roleUser = roleRepository.findByRole("DESIGNER");

        AuthRole authRoleUser = new AuthRole();
        authRoleUser.setRoleId(roleUser.getId());
        authRoleUser.setAuthId(auth.getId());
        authRoleRepository.save(authRoleUser);
    }

    @Test
    public void findByIdTest() {
        Auth auth = authRepository.findByUsername("esther0728");
        log.debug("]-----] auth [-----[ {}", auth);

        Auth auth2 = authRepository.findById(1l).get();
        log.debug("]-----] auth2 [-----[ {}", auth2);
    }

}