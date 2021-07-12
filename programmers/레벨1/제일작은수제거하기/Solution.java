package com.example.programmers.레벨1.제일작은수제거하기;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr == null || arr.length == 1){
            return new int[]{-1};
        }

        List<Integer> list = new ArrayList<>();

        for(int number : arr){ // 괜히 asList 쓰려고 요상하게 변환 로직 만들지 말고, 정석대로 하자!..
            list.add(number);
        }

        Integer lowNumber = Collections.min(list); // 와 이런 메소드가 있다니 대박 신기!!..
        list.remove(lowNumber);

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
