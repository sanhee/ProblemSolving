package com.example.programmers.레벨1.이상한문자만들기;


/*
    문자열의 공백을 기준으로, 카운트가 짝수일 때 대문자, 홀수일 때 소문자
     - 0번째 카운트는 짝수로 정의

    tRy Hello -> TrY HeLlO
 */

public class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        int count = 0; // 공백을 기준으로 문자열을 구분하기 위한 카운트
        for (int i = 0; i < s.length(); i++) {
            char currentWord = s.charAt(i);
            if (currentWord == ' ') {  // 공백을 만나면 카운트를 0으로 초기화하고, 새로운 문자열을 만날 준비한다.
                count = 0;
                sb.append(" ");
                continue;
            }
            if (count % 2 == 0) { //  카운트가 0이거나 짝수인 경우  ex 0%2 = 0
                sb.append(Character.toUpperCase(currentWord));  // 대문자
            } else {
                sb.append(Character.toLowerCase(currentWord)); // 소문자
            }
            count++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("try hello world"));
    }
}
