package com.example.LeetCode.RomanTointeger;

// * 다음 요소의 값이 현재 요소보다 크면 마이너스가 핵심인 문제
public class Solution {

    enum RomanNumber {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        public int value;

        RomanNumber(int i) {
            value = i;
        }
    }

    public int romanToInt(String s) {

        String[] inputArray = s.split("");

        int prev = 0;
        int current = 0;
        int result = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (i > 0) {
                current = RomanNumber.valueOf(inputArray[i]).value;
                if (prev >= current) {
                    result += current;
                } else {
                    result += (current - (prev * 2));  // 이전 IF문 으로 이미 이전의 작은 값이 더해져있으므로, IV 같은 연산을 하기 위해서는 이전 요소를 두번 빼줘야 하낟.
                }
                prev = current;
                continue;
            }
            prev = RomanNumber.valueOf(inputArray[i]).value;
            result += prev;
        }
        return result;
    }

}
