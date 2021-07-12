package com.example.programmers.레벨1.제일작은수제거하기;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr == null || arr.length == 1){
            return new int[]{-1};
        }

        Integer[] arrWrapping = new Integer[arr.length];

        for(int i = 0 ; i< arr.length; i++){
            arrWrapping[i] = arr[i];
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arrWrapping));

        int lowNumber = 9_999_999_99;
        int lowIndex = -1;
        for(int index = 0; index < list.size(); index++){
            if(lowNumber > list.get(index)){
                lowNumber = list.get(index);
                lowIndex = index;
            }
        }
        list.remove(lowIndex);

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
