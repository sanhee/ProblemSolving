package com.example.programmers.레벨1.수박수박수박수박수박수;

import java.util.*;

public class Solution {
    public String solution(int n) {
        Queue<Character> queue = new LinkedList<>();
        queue.add('수');
        queue.add('박');

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            Character word = queue.poll();
            queue.add(word);
            sb.append(word);
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3));
    }
}
