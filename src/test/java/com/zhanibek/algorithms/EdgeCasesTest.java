package com.zhanibek.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCasesTest {

    @Test
    void testEmptyArraySorts() {
        int[] arr = {};
        MergeSort.sort(arr); // не должно падать
        QuickSort.sort(arr); // не должно падать
        assertEquals(0, arr.length);
    }

    @Test
    void testSingleElementSorts() {
        int[] arr = {42};
        MergeSort.sort(arr);
        QuickSort.sort(arr);
        assertEquals(42, arr[0]);
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 5, 5, 5};
        MergeSort.sort(arr);
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{5, 5, 5, 5}, arr);
    }

    @Test
    void testSelectSingle() {
        int[] arr = {99};
        assertEquals(99, Select.deterministicSelect(arr, 0));
    }

    @Test
    void testClosestPairTwoPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1)
        };
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-9);
    }
}