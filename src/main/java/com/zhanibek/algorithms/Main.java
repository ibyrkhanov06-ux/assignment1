package com.zhanibek.algorithms;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar assignment1.jar <algorithm> <size>");
            System.out.println("Algorithms: mergesort, quicksort, select, closest");
            return;
        }

        String algorithm = args[0].toLowerCase();
        int size = Integer.parseInt(args[1]);

        // Генерация случайного массива
        int[] arr = new Random().ints(size, 0, 10000).toArray();

        Metrics metrics = new Metrics();
        metrics.reset();
        long start = System.nanoTime();

        switch (algorithm) {
            case "mergesort" -> MergeSort.sort(arr);
            case "quicksort" -> QuickSort.sort(arr);
            case "select" -> {
                int k = size / 2;
                int result = Select.deterministicSelect(arr.clone(), k);
                System.out.println("Selected element at " + k + ": " + result);
            }
            case "closest" -> {
                ClosestPair.Point[] pts = new ClosestPair.Point[size];
                Random rnd = new Random();
                for (int i = 0; i < size; i++) {
                    pts[i] = new ClosestPair.Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);
                }
                double dist = ClosestPair.closestPair(pts);
                System.out.println("Closest distance: " + dist);
            }
            default -> {
                System.out.println("Unknown algorithm: " + algorithm);
                return;
            }
        }

        long end = System.nanoTime();
        double elapsedMs = (end - start) / 1_000_000.0;

        // Логируем метрики
        System.out.println("Algorithm: " + algorithm);
        System.out.println("Time: " + elapsedMs + " ms");
        System.out.println(metrics);

        // Пишем в CSV
        try {
            CSVWriter writer = new CSVWriter("results.csv");
            writer.writeHeader(List.of("Algorithm", "Size", "TimeMs", "Comparisons", "Swaps", "MaxDepth"));
            writer.appendRow(List.of(
                    algorithm,
                    String.valueOf(size),
                    String.format("%.3f", elapsedMs),
                    String.valueOf(metrics.getComparisons()),
                    String.valueOf(metrics.getSwaps()),
                    String.valueOf(metrics.getMaxDepth())
            ));
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
