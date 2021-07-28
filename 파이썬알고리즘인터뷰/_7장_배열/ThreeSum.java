package com.example.파이썬알고리즘인터뷰._7장_배열;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<List<Integer>>();

        // 중복제거를 수월하게 하기위한 정렬

        Arrays.sort(nums);


        // threeSum = base + twoSum 형식
        // twoSum을 구할 때 투포인터를 이용할 것이기 때문에 left 포인터가 인덱스를 벗어나지 않도록 length-2;
        for (int base = 0; base < nums.length - 2; base++) {

            if (base > 0 && nums[base] == nums[base - 1]) {
                continue;
            }

            // base를 제외한 나머지 구간에서 쉬프트 하면서 값을 찾을 예정
            int left = base + 1;
            int right = nums.length - 1;

            // 투포인터 순회 시작
            while (left < right) {

                int sum = nums[base] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else { // sum이 0인 경우!

                    results.add(Arrays.asList(nums[base], nums[left], nums[right]));

                    // a+b+c = 0이 되는 수를 찾았기 때문에, 이제 두수는 볼일이 없음.
                    // 두 개씩 포인터를 이동하는 이유는, b+c 중 하나라도 없다면 0을 만들 수 없기 때문임.
                    left++;
                    right--;

                    // 쉬프트를 했지만 중복이 있다면! 스킵
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return results;
    }
}

