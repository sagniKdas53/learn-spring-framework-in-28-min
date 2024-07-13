package com.in28minutes.learnSpringFramework.examples.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// BusinessClass
// Dep1
// Dep2

@Component
class BusinessClass {
    // Field injection is not recommended here
    //@Autowired - Not recommended
    private Dep1 dep1;
    //@Autowired - Not recommended
    private Dep2 dep2;

    public Dep1 getDep1() {
        return dep1;
    }

    //This is a setter injection
    //@Autowired - Setter injection (Good practice?)
    public void setDep1(Dep1 dep1) {
        System.out.println("setDep1: " + dep1);
        this.dep1 = dep1;
    }

    public Dep2 getDep2() {
        return dep2;
    }

    //This is a setter injection
    //@Autowired - Setter injection
    public void setDep2(Dep2 dep2) {
        System.out.println("setDep2: " + dep2);
        this.dep2 = dep2;
    }

    @Autowired //Constructor injection
    public BusinessClass(Dep1 dep1, Dep2 dep2) {
        System.out.println("Constructor injection: " + dep1 + ", " + dep2);
        this.dep1 = dep1;
        this.dep2 = dep2;
    }

    @Override
    public String toString() {
        return "BusinessClass{" +
                "dep1=" + dep1 +
                ", dep2=" + dep2 +
                '}';
    }
}
@Component
class Dep1 {
    Dep1(){}

    @Override
    public String toString() {
        return "Dep1{}";
    }
}

@Component
class Dep2 {
    Dep2(){}

    @Override
    public String toString() {
        return "Dep2{}";
    }
}

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.dependencyInjection")
public class DependencyInjectionLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println("BusinessClass: " + context.getBean(BusinessClass.class));
            // context.getBean(BusinessClass.class).toString();
        }
    }
}
