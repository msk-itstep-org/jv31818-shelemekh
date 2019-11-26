package org.itstep.msk.app.Configuration;

import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.enums.AppRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurConfigurationForApp extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("bcryptEncoder")
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String customQuery = "SELECT name, email, phone, password  1 as active FROM customer WHERE name =? ";

        String authoriQuery = "SELECT n.name, r.roles "
                + "FROM customer c "
                + "INNER JOIN  custom_roles cr ON cd customer_id = c.id"
                + "INNER JOIN  roles r ON r.id = cd.roles_id"
                + "WHERE n.name = ?";

        auth.jdbcAuthentication()
                .usersByUsernameQuery(customQuery)
                    .authoritiesByUsernameQuery(authoriQuery)
                    .dataSource(dataSource)
                    .passwordEncoder(passwordEncoder);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/register").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/register")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/successlogin")
                .usernameParameter("name");

                http.logout()

                        .logoutSuccessUrl("/login");
                http.exceptionHandling()
                        .accessDeniedPage("/denypage");








    }
}
