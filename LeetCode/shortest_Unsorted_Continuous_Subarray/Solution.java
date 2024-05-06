package com.example.LeetCode.shortest_Unsorted_Continuous_Subarray;

/*
    1. nums 배열을 복사를 해서, 정렬을 합니다. (o(nlogn))
    2. 비교를 합니다. (o(n))
    3. 달라지는 부분부터 길이를 구합니다.
*/

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        if(nums.length == 1){
            return 0;
        }

        int[] copy = new int[nums.length];

        System.arraycopy(nums, 0, copy, 0, nums.length);

        Arrays.sort(copy);

        int sIdx = -1;
        int eIdx = -1;

        // 투 포인터
        int right = nums.length -1;
        for(int left=0; left<nums.length; left++){

            // 종료조건 (중요)
            if(right >= nums.length){
                break;
            }

            if(sIdx == -1 && (nums[left] != copy[left])){
                sIdx = left;
            }

            if(eIdx == -1 && (nums[right] != copy[right])){
                eIdx = right;
            }

            right--;
        }

        return eIdx != -1 ? eIdx-sIdx+1 : 0;
    }
}