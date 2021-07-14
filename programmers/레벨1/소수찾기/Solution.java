package com.example.programmers.레벨1.소수찾기;

public class Solution {
    public boolean checkPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = n; i > 0; i--) {
            if (checkPrime(i)) {
                answer++;
            }
        }

        return answer;
    }
}
