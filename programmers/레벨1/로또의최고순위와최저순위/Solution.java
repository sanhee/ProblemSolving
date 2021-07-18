package com.example.programmers.레벨1.로또의최고순위와최저순위;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        final int LOTTO_MAX_LENGTH = win_nums.length;

        int zeroCount = 0;
        int answerCount = 0;

        for (int i = 0; i < LOTTO_MAX_LENGTH; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
            for (int j = 0; j < LOTTO_MAX_LENGTH; j++) {
                if (zeroCount == LOTTO_MAX_LENGTH) {   //m zero 개수가 6개면 바로 리턴
                    return new int[]{1, 6};
                }
                if (win_nums[i] == lottos[j]) {
                    answerCount++;
                    break;
                }
            }
        }

        if (answerCount > 0 && zeroCount > 0) {
            return new int[]{getRank(answerCount + zeroCount), getRank(answerCount)};
        } else if (answerCount > 0 && zeroCount == 0) {
            return new int[]{getRank(answerCount), getRank(answerCount)};
        } else if (zeroCount > 0 && answerCount == 0) {
            return new int[]{getRank(zeroCount), getRank(zeroCount)};
        } else {
            return new int[]{getRank(answerCount), getRank(answerCount)};
        }
    }

    private int getRank(int number) {
        switch (number) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

}
