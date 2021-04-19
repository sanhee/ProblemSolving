package com.example.programmers.핸드폰번호가리기_12948;

class Solution {
    public static void main(String[] args) {
        new Solution().solution("01025466893");
    }
    public String solution(String phone_number) {

        int len = phone_number.length()-1;

        int num = len-4;

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<= num ; i++){
            sb.append("*");
        }

        sb.append(phone_number.charAt(len-3)).append(phone_number.charAt(len-2)).append(phone_number.charAt(len-1)).append(phone_number.charAt(len));

        System.out.println(sb.toString());
        return sb.toString();
    }
}

