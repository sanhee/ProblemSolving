package com.example.programmers.레벨1.수박수박수박수박수박수;

public class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for(int index=0; index<n; index++){
            char cursor = (index % 2) == 0 ? '수' : '박';
            sb.append(cursor);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3));
    }
}
