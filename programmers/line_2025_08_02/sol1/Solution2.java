package com.example.programmers.line_2025_08_02.sol1;

import java.util.*;

public class Solution2 {
    // 한 자리(0~9) 제곱 테이블 (미세 최적화)
    private static final int[] SQ = {0,1,4,9,16,25,36,49,64,81};

    // 자릿수 제곱 합 f(n)
    private static int sumOfSquareOfDigits(long x) {
        int sum = 0;
        while (x > 0) {
            sum += SQ[(int)(x % 10)];
            x /= 10;
        }
        return sum;
    }

    // 분해식(예: 19 -> "1^2+9^2=82") 문자열 생성
    private static String decomposeWithSum(long x) {
        if (x == 0) return "0^2=0";
        List<Integer> digits = new ArrayList<>();
        long t = x;
        while (t > 0) {
            digits.add((int)(t % 10));
            t /= 10;
        }
        // 거꾸로 저장되어 있으니 역순으로 이어 붙임
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            int d = digits.get(i);
            sb.append(d).append("^2");
            if (i > 0) sb.append("+");
            sum += SQ[d];
        }
        sb.append("=").append(sum);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // 방문 기록으로 사이클 감지
        Set<Long> visited = new HashSet<>();
        // 출력용 체인 기록
        List<Long> chain = new ArrayList<>();

        // 과정 출력 모드 (원하면 false로 바꾸면 체인만 출력)
        final boolean verbose = true;

        while (n != 1 && !visited.contains(n)) {
            chain.add(n);
            visited.add(n);

            int next = sumOfSquareOfDigits(n);
            if (verbose) {
                // 예: "19: 1^2+9^2=82"
                System.out.println(n + ": " + decomposeWithSum(n));
            }
            n = next;
        }
        // 마지막 상태(1 또는 반복 시작 지점)도 체인에 포함
        chain.add(n);

        // 1) 한 줄 체인 출력
        // 예: 19 -> 82 -> 68 -> 100 -> 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chain.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(chain.get(i));
        }
        System.out.println(sb);

        // 2) 최종 판정
        System.out.println(n == 1 ? "HAPPY" : "UNHAPPY");
    }
}
