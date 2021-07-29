package com.example.Algorithm.ezsw.bfs.최단경로_예제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
    static final int MAX_N = 10;
    static final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point {
        int row = 0;
        int col = 0;
        int dist = 0;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    static int bfs(int sRow, int sCol, int dRow, int dCol){
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Queue<Point> myqueue = new LinkedList<>();
        visited[sRow][sCol] = true;
        myqueue.add(new Point(sRow, sCol, 0));

        while(!myqueue.isEmpty()){
            Point curr = myqueue.poll();
            if(curr.row == dRow && curr.col == dCol){
                return curr.dist;
            }

            // 인접한 노드의 새로운 좌표를 탐색
            for(int i=0; i<4; i++){
                // 이해 안갔던 부분
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                // 탐색한 좌표에 대한 예외처리
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                // 1은 벽을 의미하므로, 길이 아니니까 패스!
                if(Board[nr][nc] == 1) {
                    continue;
                }
                visited[nr][nc] = true;
                myqueue.add(new Point(nr,nc,curr.dist+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0;i<N; i++){
            for(int j=0; j<N; j++){
                Board[i][j] = sc.nextInt();
            }
        }
        int sRow = sc.nextInt();
        int sCol = sc.nextInt();
        int dRow = sc.nextInt();
        int dCol = sc.nextInt();

        System.out.println(bfs(sRow,sCol,dRow,dCol));

    }

}
