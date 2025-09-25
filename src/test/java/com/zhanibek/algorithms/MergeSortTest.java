package com.zhanibek.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {5, 2, 9, 1, 3};
        MergeSort.sort(arr);
        assertTrue(MergeSort.isSorted(arr));
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.sort(arr);
        assertTrue(MergeSort.isSorted(arr));
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        assertTrue(MergeSort.isSorted(arr));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        MergeSort.sort(arr);
        assertTrue(MergeSort.isSorted(arr));
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        MergeSort.sort(arr);
        assertTrue(MergeSort.isSorted(arr));
    }
}
