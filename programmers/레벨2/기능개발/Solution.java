package com.example.programmers.레벨2.기능개발;

import java.util.*;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        int length = progresses.length;
        for(int i=0; i < length ; i++){

            int remainProgresses = 100-progresses[i];
            int countOfDay = 0;

            if(remainProgresses % speeds[i] == 0){
                countOfDay = remainProgresses/speeds[i];
            }else{
                countOfDay = remainProgresses/speeds[i]+1;
            }

            queue.add(countOfDay);
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){

            int peek = queue.peek();
            int count = 0;

            // [99, 99, 99], [1, 1, 1] 인 경우에 대한 예외
            while (!queue.isEmpty() && queue.peek() <= peek){
                ++count;
                queue.poll();
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
