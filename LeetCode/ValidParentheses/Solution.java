package com.example.LeetCode.ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){

            if(isOpen(c)){
                stack.push(c);
                continue;
            }

            if(!stack.isEmpty()){

                char cur = stack.pop();

                if(cur != '(' && c == ')'){
                    return false;
                }

                if(cur != '[' && c == ']'){
                    return false;
                }

                if(cur != '{' && c == '}'){
                    return false;
                }

            }else{
                return false;
            }

        }


        return stack.isEmpty();
    }

    public boolean isOpen(char c){
        return (c == '(' || c == '[' || c == '{');
    }
}