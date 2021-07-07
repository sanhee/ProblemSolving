package com.example.programmers.가운데글자가져오기_12903;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("qwer"));
    }

    public String solution(String s) {

        if (s.length() % 2 != 0) {
            return s.charAt(s.length() / 2) + "";
        } else {
            return s.charAt(s.length() / 2 - 1) + "" + s.charAt(s.length() / 2);
        }

    }
}
