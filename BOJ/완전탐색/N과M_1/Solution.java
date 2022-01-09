package com.example.BOJ.완전탐색.N과M_1;

import java.util.Scanner;

public class Solution {

    private static int N;
    private static int M;
    private static int[] selected;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
        visited = new boolean[N + 1];
        sc.close();
    }

    private static void rec_fuc(int k) {
        // 가지치기
        if (k == M + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i]){
                continue;
            }

            selected[k] = i;
            visited[i] = true;

            rec_fuc(k+1);
            selected[k] = 0;
            visited[i] = false;
        }


    }

    public static void main(String[] args) {
        input();

        rec_fuc(1);

        System.out.println(sb);
    }
}
