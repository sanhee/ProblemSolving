package com.example.programmers.레벨1.행렬의덧셈;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int columnLength = arr1.length;
        int rowLength = arr1[0].length;
        int[][] answer = new int[columnLength][rowLength];

        for(int column = 0; column < columnLength; column++){
            for(int row = 0; row < rowLength; row++){
                answer[column][row] = arr1[column][row]+arr2[column][row];
            }
        }
        return answer;
    }
}
