package com.example.LeetCode.ReverseString;

public class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s) {
            sb.append(c);
        }

        sb.reverse().toString().toCharArray();

    }

    public static void main(String[] args) {
        char[] s = new char[]{'a', 'b', 'c'};
        new Solution().reverseString(s);
        System.out.println(s);
    }
}
