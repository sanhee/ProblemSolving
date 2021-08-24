package com.example.programmers.레벨2.행렬의곱셈;

import java.util.*;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < arr1.length; row++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int col = 0; col < arr1[0].length; col++) {
                queue.add(arr1[row][col]);
            }

            for (int col2 = 0; col2 < arr2[0].length; col2++) {
                for (int row2 = 0; row2 < arr2.length; row2++) {

                    if (!queue.isEmpty()) {
                        int temp = queue.poll();
                        answer[row][col2] += temp * arr2[row2][col2];
                        queue.add(temp);
                    }
                }
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().solution(new int[][]{{1, 4},
                                                                                   {3, 2},
                                                                                   {4, 1}}, new int[][]{{3, 3},
                                                                                                        {3, 3}})));
    }
}