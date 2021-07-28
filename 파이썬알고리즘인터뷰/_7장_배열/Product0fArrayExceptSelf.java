package com.example.파이썬알고리즘인터뷰._7장_배열;

// 조건: 전체곱하고 나누는 방식을 못함.
// A; 자기자신을 제외한 왼쪽 곱
// B; 자기자신을 제외한 오른쪽 곱

// Solution = A*B

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        result[0] = 1;
        for(int left = 0; left < nums.length-1; left++){
            result[left+1] = result[left] * nums[left];
        }


        int[] result2 = new int[nums.length];

        result2[nums.length-1] = 1;
        for(int right = nums.length-1 ; right >= 1; right--){
            result2[right-1] = result2[right] * nums[right];
        }

        for(int i=0 ; i<result.length; i++){
            result[i] *= result2[i];
        }

        return result;
    }
}