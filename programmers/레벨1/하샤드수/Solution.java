package com.example.programmers.레벨1.하샤드수;

/*
    하샤드 수  =  각 자릿수의 합으로 x가 나누어져야 한다.

 */


public class Solution {
    public boolean solution(int x){
        String[] str = (x+"").split("");

        int sum = 0;

        for(String s : str){
            sum += Integer.parseInt(s);
        }

        if(x % sum == 0){
            return true;
        }
        return false;
    }
}
