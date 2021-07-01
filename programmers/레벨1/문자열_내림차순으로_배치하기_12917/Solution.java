package com.example.programmers.레벨1.문자열_내림차순으로_배치하기_12917;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String solution(String s) {
        String[] array = s.split("");
        Arrays.sort(array, Collections.reverseOrder());

        return String.join("",array);
    }

    public static void main(String[] args) {
        System.err.println(new Solution().solution("Zbcdefg"));
    }
}
