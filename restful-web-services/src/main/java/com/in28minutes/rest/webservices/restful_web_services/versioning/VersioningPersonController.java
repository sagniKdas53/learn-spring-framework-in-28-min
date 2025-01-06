package com.in28minutes.rest.webservices.restful_web_services.versioning;

import com.in28minutes.rest.webservices.restful_web_services.person.Name;
import com.in28minutes.rest.webservices.restful_web_services.person.PersonV1;
import com.in28minutes.rest.webservices.restful_web_services.person.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 retrievePersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 retrievePersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/param", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    /**
     * Return the second version of the person resource, using the Accept header.
     *
     * @return the second version of the person resource
     */
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
