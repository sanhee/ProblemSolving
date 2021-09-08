package com.example.BOJ.완전탐색.N_Queen;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] column;
    private static int result;
    private static FastReader scan = new FastReader();
    private static int N;

    private static void input(){
        N = scan.nextInt();
        column = new int[N];
    }


    private static void rec_func(int row) {

        if(row == N){
            result++;
        }else{

           for(int i=0; i<N; i++){
               boolean possible = true;

               for(int j=0; j<row; j++){
                   if(attackable(row, i, j, column[j])){
                       possible = false;
                       break;
                   }
               }

               if(possible){
                   column[row] = i;
                   rec_func(row+1);
                   column[row] = 0;
               }
           }

        }

    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {

        if(c1 == c2 || r1+c1 == r2+c2 || r1-c1 == r2-c2 ){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(0);
        System.out.println(result);
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
