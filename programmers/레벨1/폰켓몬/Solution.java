package com.example.programmers.레벨1.폰켓몬;

// 오전 2시 20분 시작 -> 2시 45분 종료
// N/2 마리 선택
// [3,1,2,3] => 3(2), 1(1), 2(1)
// 가질 수 있는 폰켓몬 종류 수의 최댓값
// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
// 중복되는 숫자 제거하고 N/2안쪽으로 구하면됨.
// 정렬한번 하고, 중복되는 숫자제거하기
// 그리고 카운트

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Integer[] numbers = new Integer[nums.length];

        int i = 0;
        for(int n : nums){
            numbers[i] = n;
            i++;
        }

        Set<Integer> set = new HashSet<>(); // 중복 제거를 위한 자료구조 정의
        set.addAll(Arrays.asList(numbers));

        if(set.size() > nums.length/2 ){
            return nums.length/2;
        }else{
            return set.size();
        }

    }
}
