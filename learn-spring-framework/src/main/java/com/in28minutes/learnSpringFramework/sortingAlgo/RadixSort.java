package com.in28minutes.learnSpringFramework.sortingAlgo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Qualifier("radixSort")
public class RadixSort implements SortingAlgo {

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // the actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to a current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixSort(int[] arr, int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // Exp is 10^i where i is a current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    @Override
    public void sort(int[] numbers) {
        radixSort(numbers, numbers.length);
    }

    @Override
    public boolean sorted(int[] numbers) {
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        sort(sorted);
        return Arrays.compare(numbers, sorted) == 0;
    }

    @Override
    public void swap(int[] numbers, int i, int j) {

    }
}
