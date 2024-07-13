package com.in28minutes.learnSpringFramework;

import com.in28minutes.learnSpringFramework.sortingAlgo.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Random;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.sortingAlgo")
public class App05SortAlgo {
    public static int[] generateRandomArray(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(upperBound - lowerBound) + lowerBound;
        }

        return array;
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App05SortAlgo.class)) {
            System.out.println("\nDirectly getting a sorting algorithm: \n");
            int[] numbers = generateRandomArray(10, 0, 100);
            var sortAlgo = context.getBean(SortingAlgo.class);
            isSorted(numbers, sortAlgo);
            sortAlgo.sort(numbers);
            isSorted(numbers, sortAlgo);

            System.out.println("\nBasic auto Wiring: \n");

            int[] randomNumbers = generateRandomArray(10, 0, 100);
            var sortAlgo2 = context.getBean(CableManagement.class);
            sortAlgo2.sortStuff(randomNumbers);

            System.out.println("\nGenerating a bean and auto wiring: \n");

            int[] randomNumbers2 = generateRandomArray(10, 0, 100);
            var sortAlgo3 = (CableManagement) context.getBean("inlineQualifier");
            sortAlgo3.sortStuff(randomNumbers2);

            var radixSort = (RadixSort) context.getBean("radixSort");

            System.out.println("\nSimpleAlgo Class used auto wiring: \n");
            int[] randomNumbers3 = generateRandomArray(10, 0, 100);
            var sortAlgo4 = context.getBean(SimpleAlgo.class);
            isSorted(randomNumbers3, radixSort);
            sortAlgo4.sort(randomNumbers3);
            isSorted(randomNumbers3, radixSort);

            System.out.println("\nComplexAlgo Class used auto wiring: \n");
            int[] randomNumbers4 = generateRandomArray(10, 0, 100);
            var sortAlgo5 = context.getBean(ComplexAlgo.class);
            isSorted(randomNumbers4, radixSort);
            sortAlgo5.sort(randomNumbers4);
            isSorted(randomNumbers4, radixSort);


            System.out.println("\nBeans loaded by Spring: \n");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }

    public static void isSorted(int[] numbers, SortingAlgo sortAlgo) {
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Sorted: " + sortAlgo.sorted(numbers));
    }

    @Bean
    public CableManagement inlineQualifier(@Qualifier("radixSort") SortingAlgo sortingAlgo) {
        return new CableManagement(sortingAlgo);
    }
}
