package com.zhanibek.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void testTwoPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4)
        };
        assertEquals(5.0, ClosestPair.closestPair(pts), 1e-9);
    }

    @Test
    void testSimpleCase() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(5, 5),
                new ClosestPair.Point(1, 1)
        };
        // ближайшие точки (0,0) и (1,1) → sqrt(2)
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-9);
    }

    @Test
    void testMultiplePoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        // ближайшие точки (2,3) и (3,4) → sqrt(2)
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-9);
    }

    @Test
    void testDuplicatePoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2)
        };
        assertEquals(0.0, ClosestPair.closestPair(pts), 1e-9);
    }
}
