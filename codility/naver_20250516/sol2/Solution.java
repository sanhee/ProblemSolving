package com.example.codility.naver_20250516.sol2;

class Solution {
    public int solution(String S) {
        int n = S.length();
        // 1) 첫 번째 '1' 인덱스 찾기
        int firstOne = S.indexOf('1');
        if (firstOne == -1) {
            // 전부 0 → 이미 V=0
            return 0;
        }

        int ops = 0;
        // 2) 첫 '1' 이후 비트별 카운팅
        for (int i = firstOne + 1; i < n; i++) {
            if (S.charAt(i) == '0') {
                // 짝수 단계 → 나누기 1회
                ops += 1;
            } else {
                // 홀수 단계 → 빼기+나누기 2회
                ops += 2;
            }
        }
        // 3) 첫 ‘1’ 비트를 0으로 만드는 빼기 1회
        ops += 1;

        return ops;
    }

    // 간단 테스트
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("011100"));     // 7
        System.out.println(sol.solution("111"));        // 5
        System.out.println(sol.solution("1111010101111"));// 22
        System.out.println(sol.solution("0000"));       // 0
    }
}
