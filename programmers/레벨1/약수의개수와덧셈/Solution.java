package com.example.programmers.레벨1.약수의개수와덧셈;

public class Solution {

    public int countOfDivisor(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

    public boolean checkEvenNumber(int targetNumber) {
        return targetNumber % 2 == 0;
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int cursor = left; cursor <= right; cursor++) {
            int counts = countOfDivisor(cursor);

            if (checkEvenNumber(counts)) {
                answer += cursor;
            } else {
                answer -= cursor;
            }
        }

        return answer;
    }
}
