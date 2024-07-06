package com.in28minutes.learnSpringFramework.examples.simpleLauncher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.simpleLauncher")
public class SimpleLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(SimpleLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
