package com.example.programmers.레벨1.약수의합;

import java.util.*;

public class Solution {

    public List<Integer> getDivisor(int number) {  // 약수 구하는 메서드
        List<Integer> list = new ArrayList<>();

        if (number == 1) {  // 약수가 없는 경우
            list.add(number);
            return list;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public int getSumOfDivisor(List<Integer> divisor) { // 약수의 합을 구하는 메서드

        int result = 0;

        for (int number : divisor) {
            result += number;
        }

        return result;
    }

    public int solution(int n) {
        return getSumOfDivisor(getDivisor(n));
    }
}
