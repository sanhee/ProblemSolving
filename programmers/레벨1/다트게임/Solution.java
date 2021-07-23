package com.example.programmers.레벨1.다트게임;

import java.util.Arrays;

public class Solution {
    public int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();

        int index = 0;
        int[] scores = new int[3];

        for (int i = 0; i < darts.length; i++) {
            if (Character.isDigit(darts[i]) && Character.isDigit(darts[i + 1])) {
                scores[index] = 10;
                i++;
                continue;
            } else if (Character.isDigit(darts[i]) && !Character.isDigit(darts[i + 1])) {
                scores[index] = Integer.parseInt(darts[i] + "");
                continue;
            }

            switch (darts[i]) {
                case 'S':
                    index++;
                    break;
                case 'D':
                    scores[index] = (int) Math.pow(scores[index], 2);
                    index++;
                    break;
                case 'T':
                    scores[index] = (int) Math.pow(scores[index], 3);
                    index++;
                    break;
                case '*':
                    scores[index - 1] *= 2;

                    if (index > 1) {
                        scores[index - 2] *= 2;
                    }

                    break;
                case '#':
                    scores[index - 1] *= -1;
                    break;
                default:
                    break;

            }

        }

        return Arrays.stream(scores).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1S1S1S"));
    }
}