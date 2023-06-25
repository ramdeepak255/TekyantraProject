package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// import javax.sql.DataSource;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private DataSource dataSource;

//     @Autowired
//     public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//         auth.jdbcAuthentication().dataSource(dataSource);
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {

//         http.authorizeRequests()
//                 .antMatchers("/","/global/**").permitAll()
//                 .antMatchers("/admin/**").hasRole("ADMIN")
//                 .anyRequest().authenticated()
//                 .and()
//                 .formLogin()
//                 .loginPage("/login")
//                 .loginProcessingUrl("/authenticateTheUser")
//                 .permitAll()
//                 .and()
//                 .logout()
//                 .permitAll()
//                 .and()
//                 .exceptionHandling().accessDeniedPage("/accessDenied");
//     }

//     @Override
//     public void configure(WebSecurity web) {
//         web.ignoring()
//                 .antMatchers("/css/**");
//     }

// }
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        // TODO Auto-generated method stub
        response.sendError(401,"Unauthorized");
        throw new UnsupportedOperationException("Unimplemented method 'commence'");
    }
    
}