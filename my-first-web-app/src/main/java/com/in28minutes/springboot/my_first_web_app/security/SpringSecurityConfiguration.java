package com.in28minutes.springboot.my_first_web_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetailsObject = createNewuser("guactimusprime", "4ZEXqvEZTkvuVcb", "USER", "ADMIN");
        UserDetails userDetailsObject2 = createNewuser("Threnodian", "t3rn0dian", "USER");
        UserDetails userDetailsObject3 = createNewuser("admin", "admin", "ADMIN");
        UserDetails userDetailsObject4 = createNewuser("test", "test", "USER");
        UserDetails userDetailsObject5 = createNewuser("in28minutes", "in28minutes", "USER");

        return new InMemoryUserDetailsManager(userDetailsObject, userDetailsObject2, userDetailsObject3, userDetailsObject4, userDetailsObject5);
    }

    private UserDetails createNewuser(String username, String passwordString, String... roles) {
        return User.builder()
                .passwordEncoder(password -> passwordEncoder().encode(password))
                .username(username)
                .password(passwordString)
                .roles(roles)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
