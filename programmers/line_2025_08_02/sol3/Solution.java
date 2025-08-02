package com.example.programmers.line_2025_08_02.sol3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

/*
   시간초과
 */
public class Solution {
    static class RawCoin {
        int startDay, endDay, type;
        RawCoin(int startDay, int endDay, int type) {
            this.startDay = startDay;
            this.endDay   = endDay;
            this.type     = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        // 코인 단가 (0-indexed)
        int[] coinPrice = new int[m];
        for (int i = 0; i < m; i++) {
            coinPrice[i] = sc.nextInt();
        }

        // 작업 원본 입력
        List<RawCoin> raw = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt() - 1;  // 입력이 1..m 이므로 0-index로
            raw.add(new RawCoin(s, e, t));
        }
        sc.close();

        int maxDay = 0;
        for (RawCoin r : raw) {
            if (r.endDay > maxDay) maxDay = r.endDay;
        }

        // -------------------------------
        // 여기부터 구현
        // 1) 종료일 기준 정렬
        raw.sort(Comparator.comparingInt(a -> a.endDay));

        // 2) 이진탐색용 종료일 배열, 각 작업의 이익
        int[] endDay = new int[n];
        long[] profit = new long[n];
        for (int i = 0; i < n; i++) {
            RawCoin r = raw.get(i);
            endDay[i] = r.endDay;
            // [s, e) 기간 × 단가
            profit[i] = (long) (r.endDay - r.startDay) * coinPrice[r.type];
        }

        // 3) DP: dp[i] = jobs[0..i-1] 고려 시 최대 수익
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            RawCoin cur = raw.get(i - 1);

            // cur 시작일보다 같거나 작게 끝나는 마지막 작업의 인덱스 p 찾기
            int p = upperBound(endDay, cur.startDay) - 1; // p: -1 이면 이전 선택 없음

            long take = (p >= 0 ? dp[p + 1] : 0) + profit[i - 1];
            long skip = dp[i - 1];

            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[n]);
        // -------------------------------
    }

    // endDay에서 value 이하의 마지막 위치 다음 인덱스 반환(표준 upper_bound)
    private static int upperBound(int[] a, int value) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] <= value) lo = mid + 1;
            else hi = mid;
        }
        return lo; // value보다 큰 첫 위치
    }
}
