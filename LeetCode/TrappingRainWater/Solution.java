package com.example.LeetCode.TrappingRainWater;

public class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int volum = 0;


        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    volum += left_max - height[left];
                }


                left++;

            } else {

                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    volum += right_max - height[right];
                }

                right--;
            }

        }

        return volum;

    }
}
