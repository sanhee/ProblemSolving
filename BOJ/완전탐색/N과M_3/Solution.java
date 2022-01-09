package com.example.BOJ.완전탐색.N과M_3;

import java.util.Scanner;

public class Solution {
    private static int N;
    private static int M;
    private static int[] selected;
    private static StringBuilder sb = new StringBuilder();

    private static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            selected[k] = i;
            rec_func(k + 1);
            selected[k] = 0;
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1);

        System.out.println(sb);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
        sc.close();
    }
}
