package com.example.LeetCode.addBinary;

public class Solution {
    public String addBinary(String a, String b) {

        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;

        int sum = 0;

        StringBuilder outputBuilder = new StringBuilder();

        while(aIdx >= 0 || bIdx >= 0){

            if(aIdx >= 0){
                sum += a.charAt(aIdx--) - '0';
            }

            if(bIdx >= 0){
                sum += b.charAt(bIdx--) - '0';
            }

            outputBuilder.append(sum % 2);

            // carry
            sum = sum / 2;
        }

        // carry가 남아있는 경우
        if(sum == 1){
            outputBuilder.append(sum);
        }

        return outputBuilder.reverse().toString();

    }
}