package com.in28minutes.learnSpringFramework.sortingAlgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SimpleAlgo {
    private final SortingAlgo sortingAlgo;

    @Autowired
    public SimpleAlgo(@Qualifier("bubbleSort") SortingAlgo sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
    }

    public void sort(int[] numbers) {
        sortingAlgo.sort(numbers);
    }
}
