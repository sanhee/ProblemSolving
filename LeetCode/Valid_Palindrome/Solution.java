package com.example.LeetCode.Valid_Palindrome;

public class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        int forward = 0;
        int backward = s.length() - 1;

        while (forward < backward) {
            if (s.charAt(forward) != s.charAt((backward))) {
                return false;
            }
            forward++;
            backward--;
        }
        return true;
    }
}
