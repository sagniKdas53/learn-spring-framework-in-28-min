package com.in28minutes.learnSpringFramework.sortingAlgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.in28minutes.learnSpringFramework.App05SortAlgo.isSorted;

@Component
@Primary
public class CableManagement {
    private final SortingAlgo sortingAlgo;

    @Autowired
    public CableManagement(SortingAlgo sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
    }

    public void sortStuff(int[] numbers) {
        isSorted(numbers, sortingAlgo);
        sortingAlgo.sort(numbers);
        isSorted(numbers, sortingAlgo);
    }
}
