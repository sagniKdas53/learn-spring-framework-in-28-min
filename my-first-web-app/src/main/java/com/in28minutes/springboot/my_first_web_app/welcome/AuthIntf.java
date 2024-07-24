package com.in28minutes.springboot.my_first_web_app.welcome;

public interface AuthIntf {
    boolean validate(String name, String password);
}
