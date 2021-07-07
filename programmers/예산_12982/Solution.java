package com.example.programmers.예산_12982;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int result = new Solution().solution(new int[]{1, 3, 2, 5, 4}, 9);
        int expect = 3;

        if (result == expect) {
            System.out.println("통과");
        }
    }

    public int solution(int[] d, int budget) {
        int len = d.length;

        int sum = 0;

        Arrays.sort(d); // 오름차순 정렬

        for (int n : d) {
            sum += n;
        }
        if (sum <= budget) {
            return len;
        }

        sum = 0;
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            int result = sum + d[i];
            if (result > budget) {
                return i;
            }
            sum += result;
            count++;
        }
        return count;
    }

}
