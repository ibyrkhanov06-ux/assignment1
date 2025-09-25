package com.zhanibek.algorithms;

public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private int maxDepth = 0;

    private int currentDepth = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        maxDepth = 0;
        currentDepth = 0;
    }

    public void incComparisons() {
        comparisons++;
    }

    public void incSwaps() {
        swaps++;
    }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "comparisons=" + comparisons +
                ", swaps=" + swaps +
                ", maxDepth=" + maxDepth +
                '}';
    }
}
