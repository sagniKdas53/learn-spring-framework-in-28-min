package com.in28minutes.springboot.my_first_web_app.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Entity
@Component
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

}
