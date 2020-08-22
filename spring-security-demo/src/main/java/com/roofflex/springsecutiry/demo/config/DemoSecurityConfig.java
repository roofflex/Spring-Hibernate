package com.roofflex.springsecutiry.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    // add a reference to security data source
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // using jdbc authentication

        auth.jdbcAuthentication().dataSource(securityDataSource);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/").permitAll()  // allow public access to home page
            .antMatchers("/employees").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
            .antMatchers("/managers/**").hasRole("MANAGER")
            .antMatchers("/admins/**").hasRole("ADMIN")
            .and()
            .formLogin().loginPage("/showLoginPage")
            .loginProcessingUrl("/authenticateTheUser")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/")  // after logout then redirect to landing page
            .permitAll()
            .and()
            .exceptionHandling()
            .accessDeniedPage("/access-denied");

    }
}
