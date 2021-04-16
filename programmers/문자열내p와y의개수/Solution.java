package com.example.programmers.문자열내p와y의개수;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("Pyy"));
    }

    boolean solution(String s) {

        int pCount = 0;
        int yCount = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                ++pCount;
            } else if (c == 'y' || c == 'Y') {
                ++yCount;
            } else {
                ++count;
            }
        }

        if (pCount == yCount) {
            return true;
        }

        if (count == s.length()) {
            return false;
        }

        return false;
    }
}
