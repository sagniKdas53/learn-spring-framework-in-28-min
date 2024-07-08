package com.in28minutes.learnSpringFramework.examples.lazyInit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.lazyInit")
public class LazyLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println("Init ClassB");
            var classB = context.getBean(ClassB.class);
            System.out.println("classB: " + classB);
        }
    }
}

@Component
class ClassA {
    @Override
    public String toString() {
        return "ClassA";
    }
}

@Component
@Lazy
class ClassB {
    private final ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Initializing ClassB");
        this.classA = classA;
        System.out.println("classA: " + this.classA);
    }

    @Override
    public String toString() {
        return "ClassB";
    }
}
