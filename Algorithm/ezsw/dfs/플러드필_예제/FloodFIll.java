package com.example.Algorithm.ezsw.dfs.플러드필_예제;

import java.util.Scanner;

public class FloodFIll {
    static final int MAX_N = 10;
    static final int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static class Point{
        private final int row;
        private final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i= 0; i<N; i++){
            for(int j=0 ; j<N; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        int sRow = sc.nextInt();
        int sCol = sc.nextInt();
        int color = sc.nextInt();

        for(int i= 0; i<N; i++){
            for(int j=0 ; j<N; j++){
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============ After flood fill ===============");
        dfs(sRow,sCol,color);

        for(int i= 0; i<N; i++){
            for(int j=0 ; j<N; j++){
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void dfs(int sRow, int sCol, int color) {
        // dfs 가 무엇? 타고 들어가야함. stack or 재귀
        // 재귀로 한번 구현해보자

        if(!visited[sRow][sCol] && Board[sRow][sCol] != 1){
            Board[sRow][sCol] = color;
            visited[sRow][sCol] = true;
        }

        Point point = new Point(sRow,sCol);

        // 인접 노드를 순환 해야함.
        for(int i=0; i<4; i++){
            int nRow = point.row + D[i][0];
            int nCol = point.col + D[i][1];

            if(nRow < 0 || nRow > N-1 || nCol < 0 || nCol > N-1 || visited[nRow][nCol]){
                continue;
            }
            if(Board[nRow][nCol] == 1){
                continue;
            }

            Board[nRow][nCol] = color;
            dfs(nRow,nCol,color);
        }
    }
}
