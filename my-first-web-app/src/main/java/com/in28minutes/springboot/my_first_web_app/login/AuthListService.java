package com.in28minutes.springboot.my_first_web_app.login;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AuthListService implements AuthIntf {
    @Override
    public boolean validate(String name, String password) {
        return name.equals("Threnodian") && password.equals("t3rn0dian");
    }
}
