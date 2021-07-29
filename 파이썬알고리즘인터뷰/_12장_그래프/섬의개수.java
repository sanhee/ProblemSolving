package com.example.파이썬알고리즘인터뷰._12장_그래프;

import java.util.Arrays;

/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/

재귀를 for문안에서 할 때, return을 정말 조심해야겠다..

 */
public class 섬의개수 {

    // 노드 인근 주변 순회를 위한 변수
    private static final int[][] Direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {

        int countOfIsland = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    countOfIsland++;
                    dfs(grid, row, col);
                }
            }
        }


        return countOfIsland;
    }

    private static void dfs(char[][] grid, int row, int col) {

        // for문 안에 넣었다가, 인접 노드 순회가 중간에 끝나서 올바른 결과가 안나왔었음.
        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = 'X';

        // 노드 인근 순회(상 하 좌 우)
        for (int d = 0; d < Direction.length; d++) {

            int nRow = row + Direction[d][0];
            int nCol = col + Direction[d][1];

            if (nRow < 0 || nRow > grid.length - 1 || nCol < 0 || nCol > grid[nRow].length - 1) {
                continue;
            }

            dfs(grid, nRow, nCol);

        }
    }

}