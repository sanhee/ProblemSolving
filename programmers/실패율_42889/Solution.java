package com.example.programmers.실패율_42889;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(2, new int[]{3, 3, 3})));
    }

    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> stageResult = new HashMap<>();


        for (int i = 1; i <= N; i++) { // 스테이지 순회

            int numOfFailedUser = 0;
            int numOfReachedUser = 0;
            double rateOfFail = 0.0;
            for (int j = 0; j < stages.length; j++) {

                if (i <= stages[j]) {
                    if (i == stages[j]) {
                        numOfFailedUser++;
                    }
                    numOfReachedUser++;
                }

            }

            if (numOfReachedUser == 0) {
                rateOfFail = 0;
                stageResult.put(i, rateOfFail);
                continue;
            }
            rateOfFail = (double) numOfFailedUser / numOfReachedUser;
            stageResult.put(i, rateOfFail);
        }


        List<Map.Entry<Integer, Double>> list_entries = new ArrayList<>(stageResult.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int[] answer = new int[N];

        int index = 0;
        for (Map.Entry<Integer, Double> entry : list_entries) {
            answer[index] = entry.getKey();
            index++;
        }

        return answer;
    }
}
