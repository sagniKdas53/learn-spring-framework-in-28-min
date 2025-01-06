package com.in28minutes.rest.webservices.restful_web_services.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonV1 {
    private final String name;

    public PersonV1(String name) {
        super();
        this.name = name;
    }
}
