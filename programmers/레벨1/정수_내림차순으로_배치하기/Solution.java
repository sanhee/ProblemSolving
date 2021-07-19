package com.example.programmers.레벨1.정수_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public long solution(long n) {
        String[] array = String.valueOf(n).split("");
        Integer[] numbers = new Integer[array.length];

        int i = 0;
        for (String s : array) {
            numbers[i] = Integer.valueOf(array[i]);
            i++;
        }

        Arrays.sort(numbers, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer num : numbers) {
            sb.append(num + "");
        }

        return Long.parseLong(sb.toString());

    }
}
