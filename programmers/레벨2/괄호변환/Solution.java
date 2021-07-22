package com.example.programmers.레벨2.괄호변환;

import java.util.Stack;

public class Solution {

    private int split(String p) {
        char[] strs = p.toCharArray();

        int count = 0;
        int index = 0;

        for (char c : strs) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) { // 가장 짧은 균형잡힌 괄호의 조건
                return index+1; // 오 마이갓 ...+1을 해줘야 하는 이유 substring의 마지막은 exclusive하기 때문임.
            }
            index++;
        }
        return strs.length;
    }

    private boolean isBalanced(StringBuilder u) {
        Stack<Character> stack = new Stack<>();
        char[] str = u.toString().toCharArray();

        for (char input : str) {
            if (stack.empty()) {
                stack.push(input);
            } else {
                if (input == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(input);
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }

    }

    public String solution(String p) {
        if (p.equals("")) return "";

        int index = split(p);

        StringBuilder u = new StringBuilder(p.substring(0, index));
        StringBuilder v = new StringBuilder(p.substring(index));

        if (isBalanced(u)) {
            u.append(solution(v.toString()));
            return u.toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(solution(v.toString()));
        sb.append(')');

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        if(new Solution().solution("(()())()").equals("(()())()")){
            System.out.println("통과");
        }
    }

}