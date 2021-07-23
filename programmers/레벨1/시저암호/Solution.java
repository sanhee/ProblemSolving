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
            else if ( (int) c == 90 || (int) c == 122){
                sb.append((char)(c-25+n-1));
            }else{
                sb.append((char)(c+n));
            }
        }


        return sb.toString();
    }
}