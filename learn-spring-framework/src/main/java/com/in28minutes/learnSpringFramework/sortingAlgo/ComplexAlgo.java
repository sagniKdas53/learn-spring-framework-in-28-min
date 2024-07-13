package com.in28minutes.learnSpringFramework.sortingAlgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComplexAlgo {
    private final SortingAlgo sortingAlgo;

    @Autowired
    public ComplexAlgo(@Qualifier("radixSort") SortingAlgo sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
    }

    public void sort(int[] randomNumbers4) {
        sortingAlgo.sort(randomNumbers4);
    }
}
