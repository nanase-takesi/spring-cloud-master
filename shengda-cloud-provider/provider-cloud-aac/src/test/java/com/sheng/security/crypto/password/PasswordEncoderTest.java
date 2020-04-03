package com.sheng.security.crypto.password;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author takesi
 * @date 2020-04-02
 */
public class PasswordEncoderTest {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void encodePassword() {
        String password = passwordEncoder.encode("webApp");
        System.out.println(password);
    }

}
