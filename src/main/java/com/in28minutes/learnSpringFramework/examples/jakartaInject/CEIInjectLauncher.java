package com.in28minutes.learnSpringFramework.examples.jakartaInject;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.jakartaInject")
public class CEIInjectLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CEIInjectLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            // Arrays.stream(context.getBeanDefinitionNames())
            //         .forEach(System.out::println);

            var businessClass = context.getBean(BusinessClass.class);
            System.out.println("Result of CEI Injection: " + businessClass.getDs());
        }
    }
}

//@Component
@Named
class BusinessClass {
    private final DataService ds;

    //@Autowired
    @Inject
    BusinessClass(DataService ds) {
        this.ds = ds;
    }

    //@Autowired
    @Inject
    public DataService setDs(DataService ds) {
        System.out.println("Setter Injection: " + ds);
        return ds;
    }

    public DataService getDs() {
        return ds;
    }
}

//@Component
@Named
class DataService {

    @Override
    public String toString() {
        return "Data Service";
    }
}
