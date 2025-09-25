package com.zhanibek.algorithms;

import java.util.Arrays;

public class Select {

    // Находим k-ю порядковую статистику (0-based index)
    public static int deterministicSelect(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k out of bounds");
        }

        // если массив состоит из одного элемента
        if (arr.length == 1) {
            return arr[0];
        }

        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = medianOfMedians(arr, left, right);
        pivotIndex = Utils.partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k);
        }
    }

    // Медиана медиан (MoM5)
    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return left + n / 2;
        }

        int numMedians = (int) Math.ceil(n / 5.0);
        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);

            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        return deterministicSelect(medians, medians.length / 2);
    }
}
