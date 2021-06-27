package com.example.programmers.레벨1.문자열다루기기본_12918;

class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }
}
