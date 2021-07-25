package com.example.programmers.레벨1.키패드누르기;

// 01:49 ~

public class Solution {


    // 키패드 좌표 얻는 함수
    private static int[] getPoint(int num) {
        int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}};

        for (int row = 0; row < keypad.length; row++) {
            for (int col = 0; col < keypad[0].length; col++) {
                if (keypad[row][col] == num) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1}; // null을 의미
    }

    private static int getRowDistance(int[] pos, int[] target) {
        return Math.abs(pos[0] - target[0]) + Math.abs(pos[1] - target[1]);
    }


    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[] leftPos = new int[]{3, 0}; // 키패드(*)
        int[] rightPos = new int[]{3, 2}; // 키패드(#)

        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                leftPos = getPoint(n);
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                rightPos = getPoint(n);
            } else {
                int[] targetPos = getPoint(n);
                int leftDiff = getRowDistance(leftPos, targetPos);
                int rightDIff = getRowDistance(rightPos, targetPos);

                if(leftDiff < rightDIff){
                    answer.append("L");
                    leftPos = getPoint(n);
                } else if (leftDiff > rightDIff){
                    answer.append("R");
                    rightPos = getPoint(n);
                }else{
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = getPoint(n);
                    } else {
                        answer.append("R");
                        rightPos = getPoint(n);
                    }
                }

            }

        }


        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        if (s.solution(new int[]{4,5,0}, "right").equals("LLR")) {
            System.out.println("통과");
        } else {
            System.out.println(s.solution(new int[]{4,5,0}, "right"));
        }

    }
}
