package com.example.programmers.레벨1.신규아이디추천;

//1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

import java.util.Arrays;

public class Solution {
    public String solution(String new_id) {

        char[] newId = new_id.toLowerCase().toCharArray();

        int index = 0;
        int dotCount = 0;

        for (char c : newId) {
            // 허용되지 않는 문자라면 공백으로 치환
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.')) {
                newId[index] = ' ';
                dotCount = 0;
                index++;
                continue;
            }
            // 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            else if (c == '.') {
                dotCount++;
                if (dotCount > 1) {
                    newId[index] = ' ';
                }
            } else {
                dotCount = 0;
            }
            index++;
        }
        // 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (newId[0] == '.') {
            newId[0] = ' ';
        }
        if (newId[newId.length - 1] == '.') {
            newId[newId.length - 1] = ' ';
        }


        StringBuilder sb = new StringBuilder();

        for (char c : newId) {
            // 공백제거
            if(c != ' ') {
                sb.append(c);
            }
        }

        // 빈 문자열이라면, new_id에 "a"를 대입
        if (sb.toString().equals("")) {
            sb.append("a");
        }

        if (sb.length() >= 16) {
            new_id = sb.substring(0, 15);

            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = sb.substring(0, new_id.length() - 1);
            }

        }else{
            new_id = sb.toString();
        }

        // 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (new_id.equals(".")) {
            new_id = "a";
        }

        char copyBase = new_id.charAt(new_id.length() - 1);

        StringBuilder sb2 = new StringBuilder(new_id);

        while (sb2.length() < 3) {
            sb2.append(copyBase);
        }

        return sb2.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("=.="));
    }
}
