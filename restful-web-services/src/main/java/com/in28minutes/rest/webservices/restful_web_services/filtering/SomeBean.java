package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties("field3")
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;
}
