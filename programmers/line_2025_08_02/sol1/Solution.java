package com.example.programmers.line_2025_08_02.sol1;

import java.util.*;

public class Solution {
    // 한 자리(0~9)의 제곱을 미리 테이블화 (미세 최적화)
    private static final int[] DIGIT_SQUARES = {0,1,4,9,16,25,36,49,64,81};

    // 자릿수 제곱 합 f(n)
    private static int sumOfSquareOfDigits(long x) {
        int sum = 0;
        while (x > 0) {
            sum += DIGIT_SQUARES[(int)(x % 10)];
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        Set<Integer> visited = new HashSet<>();

        // 1에 도달하면 HAPPY, 1에 도달하기 전에 값이 반복되면 UNHAPPY
        while (n != 1 && !visited.contains((int)n)) {
            visited.add((int)n);
            n = sumOfSquareOfDigits(n);
        }

        System.out.println(n == 1 ? "HAPPY" : "UNHAPPY");
    }
}

