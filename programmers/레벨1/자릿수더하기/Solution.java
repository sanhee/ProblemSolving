package com.example.programmers.레벨1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String converts = String.valueOf(n);
        String[] convertArray = converts.split("");

        for(String str : convertArray){
            answer += Integer.parseInt(str);
        }

        return answer;
    }
}
