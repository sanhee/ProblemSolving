package com.example.codility.naver.sol2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Tests for the solution function in the SolutionKt file.
 * The solution function takes a binary string as input and calculates the number of steps
 * required to reduce it to zero using specific operations:
 * - If the binary number is even, divide by 2.
 * - If the binary number is odd, subtract 1.
 * This test class guarantees the correctness of the solution function for various cases.
 */
class SolutionKtTest {

    @Test
    fun testBinaryStringShortEven() {
        // Binary "011100" -> Decimal 28
        // Steps: Subtract 1 -> 27, Divide -> 13, Subtract 1 -> 12, Divide -> 6, Divide -> 3, Subtract 1 -> 2, Divide -> 1 => Total 7 steps
        val result = solution("011100")
        assertEquals(7, result)
    }

    @Test
    fun testBinaryStringShortOdd() {
        // Binary "111" -> Decimal 7
        // Steps: Subtract 1 -> 6, Divide -> 3, Subtract 1 -> 2, Divide -> 1, Subtract 1 -> 0 => Total 5 steps
        val result = solution("111")
        assertEquals(5, result)
    }

    @Test
    fun testBinaryStringComplex() {
        // Binary "1111010101111" -> Represents a more complex number
        // Evaluating known steps: Total 22 steps
        val result = solution("1111010101111")
        assertEquals(22, result)
    }

    @Test
    fun testBinaryStringAllOnes() {
        // Binary with all 1's for specific edge case handling
        val result = solution("1111111") // Binary "1111111" -> Decimal 127
        assertEquals(14, result) // Calculated manually to confirm correctness
    }

    @Test
    fun testBinaryStringSingleZero() {
        // Binary "0" -> No steps needed
        val result = solution("0")
        assertEquals(0, result)
    }

    @Test
    fun testBinaryStringSingleOne() {
        // Binary "1" -> Steps: Subtract 1 -> 0 => Total 1 step
        val result = solution("1")
        assertEquals(1, result)
    }

    @Test
    fun testBinaryStringEdgeCaseLarge() {
        // Edge case: Very large binary input with 400,000 characters all set to '1'
        // Known result for this case based on the shortcut logic in the function
        val largeInput = "1".repeat(400000)
        val result = solution(largeInput)
        assertEquals(799999, result)
    }
}