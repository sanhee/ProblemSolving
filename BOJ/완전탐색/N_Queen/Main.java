package com.example.BOJ.완전탐색.N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, ans;
    private static int[] col; // col[i] : i번의 행의 퀸은 col[i]번 열에 놓았다는 기록
    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    private static StringBuilder sb = new StringBuilder();

    public static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        col = new int[N+1];
    }

    public static void rec_func(int row){
        if(row == N+1){ // 각 행마다 하나씩 잘 놓았다.
            ans++;
        }else{
            for(int c = 1; c<= N; c++){
                boolean possible = true;
                // valid check (row, c)
                // 이전에 놓였던 퀸을 봄
                for(int i=1; i<=row-1; i++){
                    if(attackable(row, c, i, col[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean validity_check() {

        for(int i=1; i<=N; i++){
            // (i, col[i])
            for(int j=1; j<i; j++){
                // (j, col[j])
                if(attackable(i, col[i], j, col[j])){
                    return false;
                }
                return true;
            }

        }
        return false;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(r1 - c1 == r2 -c2) return true;
        if(r1 + c1 == r2 + c2) return true;
        return false;
    }

    public static void main(String[] args) {
        input();
        // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
        rec_func(1);
        System.out.println(ans);
    }

    static class FastReader {

        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
