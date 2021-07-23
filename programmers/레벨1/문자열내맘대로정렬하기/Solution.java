package com.example.programmers.레벨1.문자열내맘대로정렬하기;

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (s1,s2)->{
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            if(c1 == c2){ // 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순
                return s1.compareTo(s2);
            }
            return c1-c2; // 오름차순
        });

        return strings;

    }
}