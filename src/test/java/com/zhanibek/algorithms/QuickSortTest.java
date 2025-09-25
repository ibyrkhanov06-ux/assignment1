package com.zhanibek.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class QuickSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {5, 2, 9, 1, 3};
        QuickSort.sort(arr);
        assertTrue(QuickSort.isSorted(arr));
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.sort(arr);
        assertTrue(QuickSort.isSorted(arr));
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.sort(arr);
        assertTrue(QuickSort.isSorted(arr));
    }

    @Test
    void testLargeRandomArray() {
        Random rnd = new Random();
        int[] arr = rnd.ints(10000, -100000, 100000).toArray();
        QuickSort.sort(arr);
        assertTrue(QuickSort.isSorted(arr));
    }
}
