package com.example.programmers.나누어떨어지는숫자배열_12910;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            if (n % divisor == 0) {
                list.add(n);
            }
        }

        int[] answer = new int[list.size()];

        if (answer.length == 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}
