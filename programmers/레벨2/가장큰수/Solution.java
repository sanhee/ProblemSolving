package com.example.programmers.레벨2.가장큰수;

import java.util.Arrays;

public class Solution {

    public String solution(int[] numbers) {

        int length = numbers.length;
        String[] strs = new String[length];

        for(int i=0; i<length; i++){
            strs[i] = numbers[i]+"";
        }

        // 내림차순
        Arrays.sort(strs, (s1, s2)->(s2+s1).compareTo(s1+s2));

        if(strs[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }

        return sb.toString();
    }

}
