package com.zhanibek.algorithms;

import java.util.Random;

public class QuickSort {
    private static final Random rnd = new Random();

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        while (left < right) {
            int pivotIndex = partition(array, left, right);

            // Выбираем меньшую часть для рекурсии, большую — для итерации
            if (pivotIndex - left < right - pivotIndex) {
                quickSort(array, left, pivotIndex - 1);
                left = pivotIndex + 1; // итерация на правую часть
            } else {
                quickSort(array, pivotIndex + 1, right);
                right = pivotIndex - 1; // итерация на левую часть
            }
        }
    }

    private static int partition(int[] array, int left, int right) {
        // Случайный pivot
        int pivotIndex = left + rnd.nextInt(right - left + 1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right); // переносим pivot в конец

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }
}
