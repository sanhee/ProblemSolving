package com.noeul.programmers.레벨1.숫자문자열과영단어;

public class Solution {
    public int solution(String s) {

        if(s.contains("zero")){
            s = s.replaceAll("zero","0");
        }
        if(s.contains("one")){
            s = s.replaceAll("one","1");
        }
        if(s.contains("two")){
            s = s.replaceAll("two","2");
        }
        if(s.contains("three")){
            s = s.replaceAll("three","3");
        }
        if(s.contains("four")){
            s = s.replaceAll("four","4");
        }
        if(s.contains("five")){
            s = s.replaceAll("five","5");
        }
        if(s.contains("six")){
            s = s.replaceAll("six","6");
        }
        if(s.contains("seven")){
            s = s.replaceAll("seven","7");
        }
        if(s.contains("eight")){
            s = s.replaceAll("eight","8");
        }
        if(s.contains("nine")){
            s = s.replaceAll("nine","9");
        }

        return Integer.parseInt(s);
    }
}
