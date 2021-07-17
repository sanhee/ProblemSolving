package com.example.programmers.레벨1.자연수뒤집어배열로만들기;

public class Solution {
    public int[] solution(long n) {

        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.reverse();

        String[] str = sb.toString().split("");
        int[] answer = new int[str.length];

        int index = 0;
        for(String s : str){
            answer[index] = Integer.parseInt(s);
            index++;
        }

        return answer;
    }
}
