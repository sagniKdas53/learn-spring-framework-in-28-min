package com.in28minutes.learnSpringFramework.examples.dataBase;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.dataBase")
public class DataBaseSimpleLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DataBaseSimpleLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            var findMax = context.getBean(FindMaxService.class);
            System.out.println(findMax.findMax());

            var dataService = context.getBean("mySQLDataService", DataService.class);
            System.out.println(new FindMaxService(dataService).findMax());

            var findMaxMySQLService = context.getBean("mySQLFindMaxService", FindMaxService.class);
            System.out.println(findMaxMySQLService.findMax());

            // Bean named "mongoDBFindMaxService" not found; it does not get made even when explicitly annotated
            // var findMaxMongoDBService = context.getBean("mongoDBFindMaxService", FindMaxService.class);
            // System.out.println(findMaxMongoDBService.findMax());

        }
    }

    @Bean
    public DataService mySQLDataService(@Qualifier("mySQL") DataService ds) {
        return ds;
    }

    @Bean
    public FindMaxService mySQLFindMaxService(@Qualifier("mySQLDataService") DataService ds) {
        return new FindMaxService(ds);
    }
}
