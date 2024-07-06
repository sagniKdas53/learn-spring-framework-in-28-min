package com.in28minutes.learnSpringFramework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "in28Minutes";
    }

    @Bean
    public int age() {
        return 28;
    }

    @Bean
    public String email() {
        return "in28@min.com";
    }

//    @Bean(name = "address")
//    public Address address1() {
//        return new Address("Albuquerque", "New Mexico", "USA");
//    }

    @Bean
    public Person person() {
        return new Person("Name", 24, "email@smtp.tld",
                new Address("city", "state", "country"));
    }

    @Bean
    public Person person2MethodCalls() {
        return new Person(name(), age(), email(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, String email, Address address3) {
        return new Person(name, age, email, address3);
    }

    @Bean
    public String city() {
        return "Springfield";
    }

    @Bean
    public String state() {
        return "Illinois";
    }

    @Bean
    public String country() {
        return "USA";
    }

    @Bean(name = "location")
    @Primary
    public Address address() {
        return new Address(city(), state(), country());
    }

    @Bean
    public Address address2() {
        return new Address("city2", "state2", "country2");
    }

    @Bean
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("city3", "state3", "country3");
    }

    @Bean
    public String greeting() {
        return "Hello World";
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, String email, Address address) {
        return new Person(name, age, email, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, String email, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, email, address);
    }
}
