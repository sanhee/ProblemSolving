package com.example.programmers.레벨2.짝지어제거하기;

import java.util.Stack;

public class Solution {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] words = s.toCharArray();

        for(char word : words){
            char temp = ' ';
            if(!stack.empty()){
                temp = stack.peek();
            }

            if(temp != word) {
                stack.push(word);
            }else{
                stack.pop();
            }
        }

        if(stack.isEmpty()){
           return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("cdcd"));
    }

}
