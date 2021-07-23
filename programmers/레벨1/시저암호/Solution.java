package com.example.programmers.레벨1.시저암호;

import java.util.*;

class Solution {
    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();

        char[] str = s.toCharArray();


        for(char c : str){

            if(c == ' '){
                sb.append(c);
            }

            else if( 'A' <= (int) c  && (int)c <= 'Z'){ // 대문자
                if(c+n > 'Z') {
                    sb.append((char) (c - 25 + n - 1));  // n-1인 이유는 25를 빼는 과정도 생각해야 하기 때문임.
                }else{
                    sb.append((char)(c+n));
                }

            }else if( 'a' <= (int) c && (int)c <= 'z') { // 소문자
                if(c+n > 'z') {
                    sb.append((char) (c - 25 + n - 1));
                }else{
                    sb.append((char)(c+n));
                }
            }

        }

        return sb.toString();
    }
}