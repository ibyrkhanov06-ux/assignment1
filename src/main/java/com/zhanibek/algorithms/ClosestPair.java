package com.zhanibek.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static class Point {
        public final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double closestPair(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("Need at least 2 points");
        }

        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));

        Point[] aux = new Point[points.length];
        return closestRecursive(sortedByX, aux, 0, points.length - 1);
    }

    private static double closestRecursive(Point[] pts, Point[] aux, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(pts, left, right);
        }

        int mid = (left + right) / 2;
        double midX = pts[mid].x;

        double dLeft = closestRecursive(pts, aux, left, mid);
        double dRight = closestRecursive(pts, aux, mid + 1, right);
        double d = Math.min(dLeft, dRight);

        // merge step: sort by Y
        mergeByY(pts, aux, left, mid, right);

        // collect strip points
        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midX) < d) {
                aux[stripSize++] = pts[i];
            }
        }

        // check strip
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < d; j++) {
                d = Math.min(d, distance(aux[i], aux[j]));
            }
        }

        return d;
    }

    private static void mergeByY(Point[] pts, Point[] aux, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (pts[i].y <= pts[j].y) aux[k++] = pts[i++];
            else aux[k++] = pts[j++];
        }
        while (i <= mid) aux[k++] = pts[i++];
        while (j <= right) aux[k++] = pts[j++];
        System.arraycopy(aux, 0, pts, left, k);
    }

    private static double bruteForce(Point[] pts, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(pts[i], pts[j]));
            }
        }
        return min;
    }

    private static double distance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
