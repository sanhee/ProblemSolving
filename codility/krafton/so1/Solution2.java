package com.example.codility.krafton.so1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int solution(int num1, int num2, int num3, int num4) {


        return 0;

    }



    public static void main(String[] args) {
        Solution2 sol = new Solution2();


        // 테스트 케이스 1: 기본 케이스
        System.out.println("Test Case 1: " + (sol.solution(1, 2, 3, 6) == 6)); // Expected output: 6

        // 테스트 케이스 2: 중복된 숫자가 있을 때
        System.out.println("Test Case 2: " + (sol.solution(2, 2, 3, 3) == 3)); // Expected output: 3

        // 테스트 케이스 3: 유효한 시간이 없는 케이스
        System.out.println("Test Case 3: " + (sol.solution(6, 2, 4, 8) == 0)); // Expected output: 0

        // 테스트 케이스 4: 중복된 숫자만으로 구성된 케이스
        System.out.println("Test Case 4: " + (sol.solution(2, 2, 2, 2) == 1)); // Expected output: 1

        // 테스트 케이스 5: 숫자들이 0을 포함하는 케이스
        System.out.println("Test Case 5: " + (sol.solution(0, 0, 1, 9) == 6)); // Expected output: 6,

        // 테스트 케이스 6: 낮은 숫자들로만 이루어진 경우
        System.out.println("Test Case 6: " + (sol.solution(0, 1, 0, 5) == 9)); // Expected output: 9

        // 테스트 케이스 7: 큰 숫자들이 포함된 경우
        System.out.println("Test Case 7: " + (sol.solution(9, 5, 3, 9) == 0)); // Expected output: 0, 가능한 케이스: 없음

        System.out.println("Test Case 8: " + (sol.solution(0, 0, 0, 0) == 1)); // Expected output: 1, 가능한 케이스:  00:00
        System.out.println("Test Case 9: " + (sol.solution(0, 0, 0, 1) == 4)); // Expected output: 4, 가능한 케이스:  00:00, 00:01, 00:10, 01:00
        System.out.println("Test Case 10: " + (sol.solution(0, 0, 1, 1) == 6)); // Expected output: 6, 가능한 케이스:  00:11, 01:01, 01:10, 10:01, 10:10, 11:00
        System.out.println("Test Case 11: " + (sol.solution(0, 1, 1, 1) == 4)); // Expected output: 4, 가능한 케이스:  01:11, 10:11, 11:01, 11:10

    }
}