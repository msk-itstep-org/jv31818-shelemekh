package org.itstep.msk.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import sun.security.util.Password;

import javax.security.auth.message.callback.PasswordValidationCallback;

@Configuration
public class MainConfiguration  {


    @Bean
    public SpringResourceTemplateResolver thymeleafresolev(){
        final SpringResourceTemplateResolver resolver= new SpringResourceTemplateResolver();
       resolver.setPrefix("classpath:/templates/");
       resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }







}
