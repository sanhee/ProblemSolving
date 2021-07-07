package com.example.BOJ._1978.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int InputTestNum = Integer.parseInt(br.readLine());
        StringTokenizer InputNum = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        while (InputNum.hasMoreTokens()) {
            int num = Integer.parseInt(InputNum.nextToken());
            for (int i = 2; i <= num; i++) {
                if (i != num && num % i == 0) break;
                if (i == num && num % i == 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
