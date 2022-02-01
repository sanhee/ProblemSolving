package com.example.LeetCode.SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {



        if(target == 0){
            return 0;
        }


        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = (left  + right)  /2;

            if(nums[middle] == target){
                return middle;
            }else if(left < right){
                left = middle + 1;
            }else{
                right = middle - 1;
            }

        }



        // 배열에서 못찾은 경우
        if(nums.length <= target){
            return nums.length;
        }else {
            return target-1;
        }


    }
}