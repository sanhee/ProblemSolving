package com.example.LeetCode.TwoSum;

import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        System.out.println();
        System.out.println("nums = " + Arrays.toString(nums) + ", target = " + target);
        int[] answer = new int[2];

        for (int flag = 0; flag < nums.length; flag++) {
            // if (nums[flag] > 0 && nums[flag] > target) continue; (* nums = [3, 3, 9], target = 12 )
            // if (nums[flag] < 0 && nums[flag] < target) continue; (* nums = [-1, -2, -3, -4, -5], target = -8)
            //m 예외처리를 어떻게 할까? nums = [-3, 4, 3, 90], target = 0

            for (int p = flag + 1; p < nums.length; p++) {
                int sum = nums[flag] + nums[p];

                if (sum == target) {
                    answer = new int[]{flag, p};
                    return answer;
                }
            }
        }
        return answer; // You may assume that each input would have exactly one solution
    }

    public static int[] InputData(String str) {
        String[] cmd = str.split(" ");
        int[] numArray = new int[cmd.length];
        for (int i = 0; i < cmd.length; i++) {
            numArray[i] = Integer.parseInt(cmd[i]);
        }
        return numArray;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(twoSum(InputData("2 7 11 15"), 9)));
        System.out.println(Arrays.toString(twoSum(InputData("3 2 4"), 6)));
        System.out.println(Arrays.toString(twoSum(InputData("3 3"), 6)));
        System.out.println(Arrays.toString(twoSum(InputData("3 3 9"), 12)));
        System.out.println(Arrays.toString(twoSum(InputData("-1 -2 -3 -4 -5"), -8)));
        System.out.println(Arrays.toString(twoSum(InputData("-3 4 3 90"), 0)));

    }
}
