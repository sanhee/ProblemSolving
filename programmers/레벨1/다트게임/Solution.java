package com.example.programmers.레벨1.다트게임;

import java.util.Arrays;

public class Solution {

    private final int CUSTOM_NULL = 0;

    private int isBonus(char c) {
        switch (c) {
            case 'S':
                return 1;
            case 'D':
                return 2;
            case 'T':
                return 3;
            default:
                return CUSTOM_NULL;
        }
    }

    private boolean isOption(char c) {
        switch (c) {
            case '*':
            case '#':
                return true;
            default:
                return false;
        }
    }


    public int solution(String dartResult) {

        final int numOfChance = 3;

        int[] scores = new int[numOfChance];
        char[] results = dartResult.toCharArray();

        int roundIndex = 0;
        boolean roundCheck = false;
        for (int i = 0; i < results.length - 1; i++) {

            if (!roundCheck && Character.isDigit(results[i])) {
                roundCheck = true;
                if (Character.isDigit(results[i + 1])) {
                    scores[roundIndex] = Integer.parseInt(results[i] + results[i + 1] + "");
                }else{
                    scores[roundIndex] = Integer.parseInt(results[i] + "");
                }
            }

            if (roundCheck && isBonus(results[i]) != CUSTOM_NULL) {
                if(!isOption(results[i+1])){ // 옵션이 없을 경우
                    scores[roundIndex] = (int)Math.pow(scores[i],isBonus(results[i]));
                }else{ // 옵션이 존재할 경우
                    if(results[i+1] == '*'){
                        try {
                            scores[roundIndex] = (int)Math.pow(scores[i],isBonus(results[i])) * 2;
                            scores[roundIndex - 1] *= 2;
                        }catch (ArrayIndexOutOfBoundsException ignored){
                        }

                    }else if(results[i+1] == '#'){
                        scores[i] *= -1;
                    }
                }
                roundCheck = false;
                roundIndex++;
            }


        }

        return Arrays.stream(scores).sum();

    }

    public static void main(String[] args) {
        if(new Solution().solution("1S2D*3T") == 37){
            System.out.println("통과");
        }
    }
}
