package com.example.codility.krafton.sol2;

public class Solution2 {
    public int solution(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int answer = 0;

        while(left <= right)  {
            int height = Math.min(A[left], A[right]);
            int width = right - left + 1;
            int squareSize = Math.min(height, width);
            answer = Math.max(squareSize, answer);

            if(A[left] < A[right]) {
                left++;
            }else {
                right--;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        // 테스트 케이스
        System.out.println(sol.solution(new int[]{1, 2, 2, 2, 4, 4, 5})); // 3 출력
        System.out.println(sol.solution(new int[]{1, 2, 2, 4, 5})); // 2 출력
        System.out.println(sol.solution(new int[]{10, 10, 10, 10})); // 4 출력
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5})); // 3 출력
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7})); // 4 출력

    }
}