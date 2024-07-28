package com.in28minutes.springboot.my_first_web_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        @SuppressWarnings("SpellCheckingInspection") UserDetails userDetailsObject = createNewUser("guactimusprime", "4ZEXqvEZTkvuVcb", "USER", "ADMIN");
        UserDetails userDetailsObject2 = createNewUser("Threnodian", "t3rn0dian", "USER");
        UserDetails userDetailsObject3 = createNewUser("admin", "admin", "ADMIN");
        UserDetails userDetailsObject4 = createNewUser("test", "test", "USER");
        UserDetails userDetailsObject5 = createNewUser("in28minutes", "in28minutes", "USER");

        return new InMemoryUserDetailsManager(userDetailsObject, userDetailsObject2, userDetailsObject3, userDetailsObject4, userDetailsObject5);
    }

    private UserDetails createNewUser(String username, String passwordString, String... roles) {
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        http.formLogin(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }
}
