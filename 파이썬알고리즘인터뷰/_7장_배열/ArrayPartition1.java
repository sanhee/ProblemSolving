package com.example.파이썬알고리즘인터뷰._7장_배열;

import java.util.Arrays;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            // 정렬 했으므로, 짝수번째가 작은 수임
            if (i % 2 == 0) {
                sum += nums[i];
            }

        }
        return sum;

    }
}