package com.example.파이썬알고리즘인터뷰._7장_배열;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }

            // 해당 엘리먼트와 합해서 타겟을 만들 수 있는 요소를 구한후, 엘리먼트의 좌표를 저장
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
