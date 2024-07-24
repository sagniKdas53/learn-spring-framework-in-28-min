package com.in28minutes.springboot.my_first_web_app.welcome;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("authNamedService")
public class AuthService implements AuthIntf {

    @Override
    public boolean validate(String name, String password) {
        return name.equals("guactimusprime") && password.equals("4ZEXqvEZTkvuVcb");
    }
}
