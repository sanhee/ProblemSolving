package com.example.programmers._64601.JAVA;

public class Solution {

    private int checkAnswer(int[] ANSWER_PATTERN, int[] answers){

        int patternLen = ANSWER_PATTERN.length;
        int numOfTest = answers.length; // 문제 문항 체크

        int countOfTest= 0;
        int loopMax = 0;
        int loopCnt = 0;
        int calibrationRange = 0;

        if(patternLen < numOfTest)
            loopMax = patternLen + numOfTest - patternLen;
        else
            loopMax = numOfTest;

        for(int i=0; i<loopMax;i++){
            if(loopCnt == loopMax) break;
            if(answers[i] == ANSWER_PATTERN[calibrationRange]) countOfTest++;
            if(calibrationRange+1 >= patternLen) calibrationRange = 0;
            else calibrationRange++;

            loopCnt++;
        }
        return countOfTest;
    }

    public int[] solution(int[] answers) {

        final int[] ANSWER_PATTERN_1 = {1, 2, 3, 4, 5};
        final int[] ANSWER_PATTERN_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] ANSWER_PATTERN_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int[] countOfTest = {checkAnswer(ANSWER_PATTERN_1, answers), checkAnswer(ANSWER_PATTERN_2, answers), checkAnswer(ANSWER_PATTERN_3, answers)};
        int max = countOfTest[0];

        if(max<countOfTest[1]) max = countOfTest[1];
        if(max<countOfTest[2]) max = countOfTest[2];

        if(max == countOfTest[0] && max ==countOfTest[1] && max == countOfTest[2])  return new int[]{1,2,3};
        else if(max == countOfTest[0] && max ==countOfTest[1]) return new int[]{1,2};
        else if(max == countOfTest[0] && max ==countOfTest[2]) return new int[]{1,3};
        else if(max == countOfTest[1] && max ==countOfTest[2]) return new int[]{2,3};
        else if(max ==countOfTest[0]) return new int[]{1};
        else if(max ==countOfTest[1]) return new int[]{2};

        return new int[]{3};
    }

    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5};
        new Solution().solution(answers);
    }
}
