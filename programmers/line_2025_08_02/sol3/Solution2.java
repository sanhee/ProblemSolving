package com.example.programmers.line_2025_08_02.sol3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    이거로 제출함 시간초과 안함.
 */
public class Solution2 {
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
            int t = sc.nextInt() - 1;  // 1..m → 0..m-1
            raw.add(new RawCoin(s, e, t));
        }
        sc.close();

        // 최대 날짜 계산
        int maxDay = 0;
        for (RawCoin r : raw) {
            if (r.endDay > maxDay) maxDay = r.endDay;
        }

        // -------------------------------
        // 여기부터 구현 (날짜 축 DP)
        // 1) 시작일별 작업 리스트 만들기
        List<RawCoin>[] jobsByDay = new ArrayList[maxDay + 1];
        for (int d = 0; d <= maxDay; d++) {
            jobsByDay[d] = new ArrayList<>();
        }
        for (RawCoin r : raw) {
            jobsByDay[r.startDay].add(r);
        }

        // 2) dp[d]: d일째(정확히 d일이 지난 시점)까지 얻을 수 있는 최대 수익
        long[] dp = new long[maxDay + 1 + 1];
        // dp[0] = 0 (시작 전 수익 0)

        // 3) 날짜별 순회
        for (int day = 0; day <= maxDay; day++) {
            // 전날까지 수익을 이어받기
            if (day > 0) {
                dp[day] = Math.max(dp[day], dp[day - 1]);
            }
            // 오늘 시작 가능한 모든 작업 처리
            for (RawCoin job : jobsByDay[day]) {
                int end = job.endDay;
                long profit = (long)(job.endDay - job.startDay) * coinPrice[job.type];
                // job.startDay가 day이므로 dp[day] + profit → dp[end]
                dp[end] = Math.max(dp[end], dp[day] + profit);
            }
        }

        // 4) maxDay까지의 최대값 출력
        System.out.println(dp[maxDay]);
        // -------------------------------
    }
}
