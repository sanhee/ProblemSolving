package com.example.programmers.레벨1.비밀지도;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int num1 = arr1[i];
            int num2 = arr2[i];

            // 정수 비트 변환
            StringBuilder bit1 = new StringBuilder(Integer.toBinaryString(num1));
            StringBuilder bit2 = new StringBuilder(Integer.toBinaryString(num2));

            // 지도의 한 변의 길이를 맞춰주는 조건
            while ((n - bit1.length()) != 0) {
                bit1.insert(0, "0");
            }
            while ((n - bit2.length()) != 0) {
                bit2.insert(0, "0");
            }

            // OR 연산을 하는 로직
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < bit1.length(); j++) {
                if (bit1.charAt(j) == '1' || bit2.charAt(j) == '1') {
                    temp.append('#');
                } else {
                    temp.append(' ');
                }
            }

            result[i] = temp.toString();
        }


        return result;
    }
}