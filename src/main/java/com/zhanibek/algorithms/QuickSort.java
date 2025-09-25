package com.zhanibek.algorithms;

public class QuickSort {

    public static void sort(int[] array) {
        if (Utils.isTrivial(array)) return;
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        while (left < right) {
            int pivotIndex = Utils.partition(array, left, right);

            if (pivotIndex - left < right - pivotIndex) {
                quickSort(array, left, pivotIndex - 1);
                left = pivotIndex + 1;
            } else {
                quickSort(array, pivotIndex + 1, right);
                right = pivotIndex - 1;
            }
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }
}
