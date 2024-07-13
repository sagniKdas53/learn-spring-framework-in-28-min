package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// http://localhost:8080/courses
// Course: id, name, author, description

@RestController
public class CourseController {
    @Autowired
    private CurrencyServiceConf currencyServiceConf;

    @RequestMapping("/currency-service")
    public CurrencyServiceConf getCurrencyServiceConf() {
        return currencyServiceConf;
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1,
                        "Learn Full stack with Spring Boot and Angular",
                        "in28minutes",
                        "Become an full stack developer"
                ),
                new Course(2,
                        "Learn Full stack with Spring Boot and React",
                        "in28minutes",
                        "Become an full stack developer"
                ),
                new Course(3,
                        "Master Microservices with Spring Boot and Spring Cloud",
                        "in28minutes",
                        "Become an expert in Microservices"
                ),
                new Course(4,
                        "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes",
                        "in28minutes",
                        "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"
                ),
                new Course(5,
                        "Learn DevOps with Jenkins, Docker and Kubernetes",
                        "in28minutes",
                        "Master DevOps"
                ),
                new Course(6,
                        "Master Hibernate and JPA with Spring Boot in 100 Steps",
                        "in28minutes",
                        "Learn to build JPA and Hibernate Applications in 100 Steps"
                )
        );
    }
}
