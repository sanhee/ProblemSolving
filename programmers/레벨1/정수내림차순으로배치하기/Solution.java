package com.example.programmers.레벨1.정수내림차순으로배치하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public long solution(long n) {
        int length = Long.toString(n).length();
        Integer[] numbers = new Integer[length];

        int pow = (int) Math.pow(10, length-1);
        long m = n;

        for(int i=0; i<length; i++){
            numbers[i] = (int) m / pow;
            m =  (int) m % pow;
            pow = pow / 10;
        }
        Arrays.sort(numbers,Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(Integer number : numbers){
            sb.append(number);
        }

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1234));
    }
}
