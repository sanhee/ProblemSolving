package com.noeul.programmers.레벨1.실패율;

// N: 전체 스테이지의 개수
// stages (1이상 N+1): 게임을 이용하는 사용자가 현재 `멈춰있는` 스테이지의 번호
// ->  (N+1) :  마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자

// 아아... 각 배열 위치가 스테이지 번호인줄 알고 착각했다..
// 출력: 실패율이 높은 스테이지부터 내림차순으로 리턴

import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {

        // 스테이지, 개수 연산
        Map<Integer, Integer> countOfStage = new HashMap<>();

        // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
        for(int i=1; i<=N; i++){
            countOfStage.put(i,0);
        }

        for(int i=0; i<stages.length; i++){
           if(stages[i] > N) continue;

            int key = stages[i];
            int num = countOfStage.get(key);
            countOfStage.put(key, ++num);
        }

        int numberOfPeople = stages.length;
        Map<Integer, Float> fail = new HashMap<>();

        // 실패율 계산
        for(int i=1; i<=N; i++){
            int remain = countOfStage.get(i);
            if(numberOfPeople > 0) {
                fail.put(i, (remain / (float) numberOfPeople));
            }else{
                fail.put(i, (float)0); // 해당 스테이지에 도전한 사용자가 없을 경우에 대한 예외 :: 3/0 을 생각 못함
            }
            numberOfPeople = numberOfPeople-countOfStage.get(i);
        }

        List<Integer> listKeySet = new ArrayList<>(fail.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (fail.get(value2).compareTo(fail.get(value1))));

        return listKeySet.stream().mapToInt(Integer::intValue).toArray();
    }
}
