package org.itstep.msk.app.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class EmailProperties {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port")
    private String port;

    @Value("${spring.mail.username")
    private String username;

    @Value("${spring.mail.password")
    private String password;
    
    public EmailProperties() {
    	
    }
    

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
       return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
