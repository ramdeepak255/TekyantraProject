package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/","/global/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/users").permitAll()
                .antMatchers(HttpMethod.GET,"/api/users").permitAll()
                .antMatchers(HttpMethod.POST,"/api/books/{userid}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/users/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/users/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/users/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/books").permitAll()
                .antMatchers(HttpMethod.GET,"/api/books").permitAll()
                .antMatchers(HttpMethod.GET,"/api/books/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/books/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/{userid}/books/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/{userid}/books/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/books/{id}").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint);
                // accessDeniedPage("/accessDenied");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/css/**");
    }

}
