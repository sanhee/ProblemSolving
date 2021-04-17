package com.example.programmers.같은숫자는싫어_12906;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    }

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int prev = -1;
        for (int cur : arr) {
            if (prev != cur) {
                list.add(cur);
            }
            prev = cur;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
