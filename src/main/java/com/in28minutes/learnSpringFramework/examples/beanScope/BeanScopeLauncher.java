package com.in28minutes.learnSpringFramework.examples.beanScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.beanScope")
public class BeanScopeLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopeLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("NormalClass1: " + context.getBean(NormalClass.class));
            System.out.println("NormalClass2: " + context.getBean(NormalClass.class));
            System.out.println("NormalClass3: " + context.getBean(NormalClass.class));
            System.out.println();
            System.out.println("PrototypeClass1: " + context.getBean(PrototypeClass.class));
            System.out.println("PrototypeClass2: " + context.getBean(PrototypeClass.class));
            System.out.println("PrototypeClass3: " + context.getBean(PrototypeClass.class));
            System.out.println();
        }
    }
}

@Component
class NormalClass {
}

// Default scope is singleton, which means that there will only be one instance of this bean
@Component
@Scope(value = "prototype")
class PrototypeClass {
}
