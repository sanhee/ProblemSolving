package com.example.LeetCode.minimum_size_subarray_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;


        for(int i=0; i<nums.length; i++){

            sum += nums[i];


            // 주어진 target을 구했으므로, 최소길이를 구하기 위한 while
            while(sum >= target){
                length = Math.min(length, i - left + 1);

                sum = sum - nums[left];
                left++;
            }

        }

        return length != Integer.MAX_VALUE ? length : 0;
    }

    @Test
    void test(){
        assertEquals(3, new Solution().minSubArrayLen(11, new int[]{1,2,3,4,5}));
        assertEquals(2, new Solution().minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}