package com.example.programmers.소수만들기_12977;

class Solution {

    public static boolean prime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i]+nums[j]+nums[k];
                    if(prime(sum)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
