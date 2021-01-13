[Two Sum - LeetCode](https://leetcode.com/problems/two-sum/)

> Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

**Example 1:**

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
```

## 접근 과정

1. 반드시, element < target  

2. 포인터 2개를 만들어, 하나는 기준 포인터, 하나는 이동 포인터로 배열 인덱스를 움직이며 기준 포인터와 합산해 target이 만들어지는지 확인

```java
public static int[] twoSum(int[] nums, int target) {
        System.out.println();
        System.out.println("nums = "+Arrays.toString(nums)+", target = "+target);
        int[] answer = new int[2];

        for (int flag = 0; flag < nums.length; flag++) {
       
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
```

```java

*Success

Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
Memory Usage: 39.4 MB, less than 38.04% of Java online submissions for Two Sum.
Next challenges:
```