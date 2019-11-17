package org.itstep.msk.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import javax.security.auth.message.callback.PasswordValidationCallback;

@Configuration
public class MainConfiguration  {


    @Bean
    public PasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();


    }







}
