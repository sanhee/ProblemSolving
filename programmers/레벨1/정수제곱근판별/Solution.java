package com.example.programmers.레벨1.정수제곱근판별;

public class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n); // 루트

        //if(Math.pow(sqrt, 2) == (double)n){ // 이건 왜 안될까?
        if(sqrt == (int) sqrt){
            return (long)Math.pow(sqrt+1, 2);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        new Solution().solution(3);
    }
}
