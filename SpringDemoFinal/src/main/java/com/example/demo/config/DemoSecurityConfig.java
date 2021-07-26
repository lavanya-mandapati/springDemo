package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //use jdbc authentication
        auth.jdbcAuthentication().dataSource(securityDataSource);
       ;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("STUDENT,ADMIN,LIBRARIAN").antMatchers("/media/**").hasAnyRole("ADMIN").antMatchers("/books/**").hasAnyRole("ADMIN,LIBRARIAN").and()
                .formLogin().loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

    }



}
