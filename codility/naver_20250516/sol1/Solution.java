package com.example.codility.naver_20250516.sol1;

class Solution {
    public String solution(int N) {
        StringBuilder sb = new StringBuilder();

        // 'z'에 해당하는 k=25 부터 'a'(k=0)까지 순회
        for (int k = 25; k >= 0; k--) {
            // Math.pow를 써서 2^k 계산
            int need = (int) Math.pow(2, k);
            // 해당 글자를 만들 수 있는 횟수
            int count = N / need;

            // count번만큼 문자 추가
            for (int i = 0; i < count; i++) {
                sb.append((char) ('a' + k));
            }
            // 사용한 만큼만큼 N에서 빼고 다음 k로
            N %= need;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tests = {
                11,        // → "dba"
                1,         // → "a"
                67_108_876,// → "zzdc" (예시)
                1_000_000_000// → "???" (예시)
        };

        for (int n : tests) {
            System.out.printf("N=%d → %s%n", n, sol.solution(n));
        }
    }
}