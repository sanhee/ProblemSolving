package com.example.codility.navershoping.sol1;

public class Solution {

    public int solution(int[] start, int[] dest, int[] limit) {
        int maxStationNo = 0;
        int stationLength = start.length;
        int fee = 0;
        for (int i = 0; i < stationLength; i++) {
            maxStationNo = Math.max(maxStationNo, start[i]);
            maxStationNo = Math.max(maxStationNo, dest[i]);

            int distance = Math.abs(start[i] - dest[i]);
            fee += 1 + (2 * distance);
        }

        return Math.min(fee, limit[maxStationNo]);
    }

    public static void main(String[] args) {
        int query1 = new Solution().solution(new int[]{1, 0, 2, 4}, new int[]{2, 2, 0, 5}, new int[]{3, 17, 7, 4, 5, 17});
        System.out.println("query1 == 16: " + (query1 == 16));

        int query2 = new Solution().solution(new int[]{1, 2, 0, 2, 3}, new int[]{2, 1, 2, 1, 2}, new int[]{4, 8, 18, 16, 20});
        System.out.println("query2 == 16: " + (query2 == 16));

        int query3 = new Solution().solution(new int[]{2,2}, new int[]{4,3}, new int[]{1,1,1,1,9,1,1});
        System.out.println("query3 == 8: " + (query3 == 8));

        // ---------------------------
        // 여기서부터는 엣지/특이 케이스
        // ---------------------------

        // 4) 빈 배열 케이스
        //  start, dest가 길이 0 → 탑승 횟수 0번
        int query4 = new Solution().solution(
                new int[]{},
                new int[]{},
                new int[]{3, 17, 7, 4, 5, 17}
        );
        System.out.println("[Test 4 - empty arrays] query4 = " + query4 + " (expected: 0)");

    }
}