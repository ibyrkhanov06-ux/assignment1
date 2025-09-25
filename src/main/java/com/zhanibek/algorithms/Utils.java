package com.zhanibek.algorithms;

import java.util.Random;

public class Utils {
    private static final Random rnd = new Random();

    // Проверка на null или слишком маленький массив
    public static boolean isTrivial(int[] arr) {
        return arr == null || arr.length <= 1;
    }

    // Поменять местами два элемента
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Partition для QuickSort / Select
    public static int partition(int[] arr, int left, int right) {
        int pivotIndex = left + rnd.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    // Перемешивание массива
    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(arr, i, j);
        }
    }
}
