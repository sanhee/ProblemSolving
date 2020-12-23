package com.example.BOJ._10951.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(br.readLine() != null){

            int a = br.readLine().charAt(0)-'0';
            int b = br.readLine().charAt(2)-'0';
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);

    }
}
