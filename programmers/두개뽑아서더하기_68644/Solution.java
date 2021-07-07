package com.example.programmers.두개뽑아서더하기_68644;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];

        Iterator<Integer> iterator = set.iterator();

        int cnt = 0;
        while (iterator.hasNext()) {
            answer[cnt] = iterator.next();
            cnt++;
        }

        Arrays.sort(answer);
        return answer;
    }
}
