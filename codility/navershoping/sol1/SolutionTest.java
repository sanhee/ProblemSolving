package com.example.codility.navershoping.sol1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    /**
     * This class tests the `solution` method in the `Solution` class.
     * The `solution` method calculates a fee based on distances between start and
     * destination stations while adhering to a limit defined for the maximum station index.
     */

    @Test
    void testExampleCase1() {
        // Testing with the first sample from the main method
        int[] start = {1, 0, 2, 4};
        int[] dest = {2, 2, 0, 5};
        int[] limit = {3, 17, 7, 4, 5, 17};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(16, result);
    }

    @Test
    void testExampleCase2() {
        // Testing with the second sample from the main method
        int[] start = {1, 2, 0, 2, 3};
        int[] dest = {2, 1, 2, 1, 2};
        int[] limit = {4, 8, 18, 16, 20};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(16, result);
    }

    @Test
    void testExampleCase3() {
        // Testing with the third sample from the main method
        int[] start = {2, 2};
        int[] dest = {4, 3};
        int[] limit = {1, 1, 1, 1, 9, 1, 1};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(8, result);
    }

    @Test
    void testNoStations() {
        // Testing edge case where there are no stations
        int[] start = {};
        int[] dest = {};
        int[] limit = {10};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(0, result);
    }

    @Test
    void testSingleStation() {
        // Testing edge case with a single station
        int[] start = {0};
        int[] dest = {0};
        int[] limit = {5};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(1, result);
    }

    @Test
    void testMultipleStationsWithLimit() {
        // Testing regular scenario with different start, dest, and limit values
        int[] start = {0, 1};
        int[] dest = {1, 2};
        int[] limit = {5, 10, 7};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(6, result);
    }


    @Test
    void testLimitsExceeded() {
        // Testing case where the fee exceeds the limit value
        int[] start = {0, 2, 1};
        int[] dest = {1, 0, 3};
        int[] limit = {10, 5, 3, 12};
        Solution solution = new Solution();

        int result = solution.solution(start, dest, limit);

        assertEquals(12, result);
    }
}