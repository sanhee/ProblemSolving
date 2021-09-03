package com.example.BOJ.완전탐색.연산자_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, max, min;
    static int[] nums, operators, order;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }


    static int calculator() {

        int value = nums[1];

        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1) { // +
                value = value + nums[i + 1];
            }
            if (order[i] == 2) { // -
                value = value - nums[i + 1];
            }
            if (order[i] == 3) { // *
                value = value * nums[i + 1];
            }
            if (order[i] == 4) { // /
                value = value / nums[i + 1];
            }
        }
        return value;
    }

    static void rec_func(int k) {

        if (k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else { // 완성된 식이 없다면
            for (int cand = 1; cand <= 4; cand++) {
                if(operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;

                    rec_func(k+1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {

        input();
        rec_func(1);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
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
