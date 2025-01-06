package com.in28minutes.rest.webservices.restful_web_services.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        super();
        this.name = name;
    }
}
