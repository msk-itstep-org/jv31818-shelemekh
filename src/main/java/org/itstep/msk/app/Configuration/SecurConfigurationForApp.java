package org.itstep.msk.app.Configuration;

import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.enums.AppRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurConfigurationForApp extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();


    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       String passQuery="SELECT password, 1 as active FROM customer WHERE password=?";
       String authoriQuery = "SELECT n.name, r.roles "
               + "FROM customer c "
               + "INNER JOIN  custom_roles cr ON cd customer_id = c.id "
               + "INNER JOIN  roles r ON r.id = cd.roles_id "
                + "WHERE n.name = ?";

        auth.jdbcAuthentication()
                    .dataSource(this.dataSource)
                        .usersByUsernameQuery("select name,password from customer where name=?")
               .authoritiesByUsernameQuery(authoriQuery)
                    .passwordEncoder(bcryptEncoder());

    }

    @Override
    public void configure(WebSecurity web)  {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/templates/**")
                .antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**","/static/**","/js/**").permitAll()
                .antMatchers("/").permitAll()

                .antMatchers("/register").permitAll()
                .antMatchers("listproduct").permitAll()
                .antMatchers("/product**").permitAll()
                .antMatchers("/delete").hasAnyAuthority("ROLE_CUSTOMER")
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")

              //  .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/register")
                .defaultSuccessUrl("/registersuccess")
                .failureUrl("/");

                http.logout()
                        .logoutSuccessUrl("/register");
                http.exceptionHandling()
                        .accessDeniedPage("/denypage")
                       .and()
                       .httpBasic();












    }
}
