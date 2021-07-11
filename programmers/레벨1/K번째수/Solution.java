package com.example.programmers.레벨1.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int column = 0; column < commands.length; column++) {
            List<Integer> list = new ArrayList<>();

            int i = commands[column][0] - 1; // 자르기 start 좌표
            int j = commands[column][1] - 1; // 자르기 end 좌표
            int k = commands[column][2] - 1; // 자른 범위에서 찾을 숫자

            for (int index = i; index <= j; index++) {
                list.add(array[index]);
            }
            Collections.sort(list); // 오름차순 정렬

            answer[column] = list.get(k);
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
