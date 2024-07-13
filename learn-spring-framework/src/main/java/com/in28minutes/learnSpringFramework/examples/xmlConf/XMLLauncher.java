package com.in28minutes.learnSpringFramework.examples.xmlConf;

import com.in28minutes.learnSpringFramework.sortingAlgo.CableManagement;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static com.in28minutes.learnSpringFramework.App05SortAlgo.generateRandomArray;

//@Configuration
//@ComponentScan("com.in28minutes.learnSpringFramework.examples.xmlConf")
public class XMLLauncher {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("contextConf.xml")) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            var randomNumbers = generateRandomArray(10, 0, 100);
            var cableManagement = context.getBean(CableManagement.class);
            cableManagement.sortStuff(randomNumbers);
        }
    }
}
