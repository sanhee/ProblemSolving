package com.noeul.programmers.레벨1.음양더하기;

public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {

        int sum = 0;
        for(int i=0; i<absolutes.length; i++){
                absolutes[i] = signs[i] ? absolutes[i] : -absolutes[i];
                sum += absolutes[i];
        }

        return sum;

    }
}
