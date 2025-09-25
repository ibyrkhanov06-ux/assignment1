package com.zhanibek.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectTest {

    @Test
    void testMiddleElement() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int median = Select.deterministicSelect(arr.clone(), arr.length / 2);
        assertEquals(5, median); // исправлено
    }


    @Test
    void testSmallArray() {
        int[] arr = {10, 20, 30};
        assertEquals(20, Select.deterministicSelect(arr.clone(), 1));
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, Select.deterministicSelect(arr.clone(), 0));
    }

    @Test
    void testOrderStatistics() {
        int[] arr = {5, 2, 9, 1, 7};
        assertEquals(1, Select.deterministicSelect(arr.clone(), 0)); // min
        assertEquals(9, Select.deterministicSelect(arr.clone(), 4)); // max
    }
}
