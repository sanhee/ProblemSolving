package com.example.codility.naver_20250516.sol3;

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        // (2) 전체 합 계산
        long totalA = 0, totalB = 0;
        for (int i = 0; i < N; i++) {
            totalA += A[i];
            totalB += B[i];
        }
        // (3) 전체 A 합과 B 합이 다르거나, 합이 홀수면 불가능
        if (totalA != totalB || (totalA % 2) != 0) {
            return 0;
        }

        long half = totalA / 2;  // 네 부분합이 모두 이 값이어야 함
        long leftA = 0, leftB = 0;
        int fairCount = 0;

        // (4) K = 1부터 N-1까지 왼쪽합 누적
        for (int k = 1; k < N; k++) {
            leftA += A[k - 1];
            leftB += B[k - 1];
            // (5) A 왼쪽합 == B 왼쪽합 == half 일 때만 공정
            if (leftA == half && leftB == half) {
                fairCount++;
            }
        }

        return fairCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 예제 1
        int[] A1 = {0, 4, -1, 0, 3};
        int[] B1 = {0, -2, 5, 0, 3};
        System.out.printf("예제1 → 기대=2, 실제=%d%n", sol.solution(A1, B1));

        // 예제 2
        int[] A2 = {2, -2, -3, 3};
        int[] B2 = {0, 0, 4, -4};
        System.out.printf("예제2 → 기대=1, 실제=%d%n", sol.solution(A2, B2));

        // 예제 3
        int[] A3 = {4, -1, 0, 3};
        int[] B3 = {-2, 6, 0, 4};
        System.out.printf("예제3 → 기대=0, 실제=%d%n", sol.solution(A3, B3));

        // 예제 4
        int[] A4 = {3, 2, 6};
        int[] B4 = {4, 1, 6};
        System.out.printf("예제4 → 기대=0, 실제=%d%n", sol.solution(A4, B4));

        // 예제 5
        int[] A5 = {1, 4, 2, -2, 5};
        int[] B5 = {7, -2, -2, 2, 5};
        System.out.printf("예제5 → 기대=2, 실제=%d%n", sol.solution(A5, B5));

    }
}

