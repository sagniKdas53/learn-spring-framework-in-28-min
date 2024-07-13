package com.in28minutes.learnSpringFramework.sortingAlgo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Qualifier("bubbleSort")
public class BubbleSort implements SortingAlgo {
    void bubbleSort(int[] arr, int n) {
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // If inner loop
            // swapped no two elements, then break
            if (!swapped)
                break;
        }
    }

    @Override
    public void sort(int[] numbers) {
        bubbleSort(numbers, numbers.length);
    }

    @Override
    public boolean sorted(int[] numbers) {
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        sort(sorted);
        return Arrays.compare(numbers, sorted) == 0;
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
