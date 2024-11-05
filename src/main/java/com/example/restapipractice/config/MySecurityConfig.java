package com.example.restapipractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("Bishnu")
                .password("pass")
                .roles("ROLE_NORMAL")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("password")
                .roles("ROLE_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/public")
                .permitAll()
                .and()
                .formLogin();
        return httpSecurity.build();
    }
}
