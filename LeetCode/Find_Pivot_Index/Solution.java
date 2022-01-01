package com.example.LeetCode.Find_Pivot_Index;

// 전체 합을 구하고, leftSum과 rightSum을 구해가는 형태로 진행
// leftSum = leftSum + pastPivot;
// rightSum = totalSum - leftSum - currentPivot;


class Solution {

    public int pivotIndex(int[] nums) {
        int total = sum(nums);

        int leftSum = 0;
        int rightSum = total;

        int pastPivot = 0;

        for(int i=0; i<nums.length; i++){
            int currentPivot = nums[i];
            leftSum += pastPivot;
            rightSum -= currentPivot;

            if(leftSum == rightSum){
                return i;
            }

            pastPivot = nums[i];
        }


        return -1;
    }

    private int sum(int[] nums){
        int result = 0;

        for(int n : nums){
            result += n;
        }

        return result;
    }
}