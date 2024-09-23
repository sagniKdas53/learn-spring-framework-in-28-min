package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class HelloWorldBean implements Serializable {
    String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }
}