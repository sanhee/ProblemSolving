package com.example.programmers.레벨1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;  // ex)  12345  % 10  = 5 ... 12%10 = 2
            n /= 10;  //ex) 1234, 123, 12, 1
        }

        return answer;
    }
}
