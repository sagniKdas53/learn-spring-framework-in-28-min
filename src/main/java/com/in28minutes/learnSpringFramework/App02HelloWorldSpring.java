package com.in28minutes.learnSpringFramework;

import com.in28minutes.learnSpringFramework.helloworld.Address;
import com.in28minutes.learnSpringFramework.helloworld.HelloWorldConfiguration;
import com.in28minutes.learnSpringFramework.helloworld.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class App02HelloWorldSpring {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
                (HelloWorldConfiguration.class)) {

            System.out.println(context.getBean("greeting"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("location"));
            System.out.println("person2MethodCalls: " + context.getBean("person2MethodCalls"));
            System.out.println("person3Parameters: " + context.getBean("person3Parameters"));

            //context.getBeanDefinitionNames();
            System.out.println("Beans in context: " + context.getBeanDefinitionCount());
            System.out.println("Beans in context: " + Arrays.toString(context.getBeanDefinitionNames()));

            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));

            System.out.println("\nPrinting all beans in context");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("person4Parameters: " + context.getBean("person4Parameters"));
            System.out.println("person5Qualifier: " + context.getBean("person5Qualifier"));
        }
    }
}
