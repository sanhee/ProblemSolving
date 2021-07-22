package com.example.programmers.레벨1._3진법뒤집기;

// 02:24
public class Solution {
    public int solution(int n) {

        StringBuilder sb = new StringBuilder();

        while ( (n / 3) != 0) {
            sb.append(n%3);
            n = n / 3;
        }
        sb.append(1);

        sb.reverse();

        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            result += ((sb.charAt(i) - '0') * Math.pow(3, i));
        }

        return result;
    }

    public static void main(String[] args) {
        if(new Solution().solution(125) == 229){
            System.out.println("성공");
        }
    }

}
