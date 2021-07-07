package com.example.programmers._64601.JAVA;

import java.util.Stack;


//m 1시간 08분 43초 걸림.

public class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int moveLength = moves.length;
        int yLen = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int m = 0; m < moveLength; m++) {

            int selectPos = moves[m] - 1;

            for (int y = 0; y < yLen; y++) {

                if (board[y][selectPos] > 0) { //m 값이 존재할 경우

                    if (!stack.empty() && (stack.lastElement() == board[y][selectPos])) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[y][selectPos]);
                    }
                    board[y][selectPos] = 0;

                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int expect = 4;

        int answer = new Solution().solution(board, moves) == expect ? 1 : -1;

        System.out.println(answer);
    }

}
