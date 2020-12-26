package com.example.BOJ._10952.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10952 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean zeroCheck = (br.readLine().charAt(0)-'0' == 0)&&(br.readLine().charAt(2)-'0' == 0) ;

        while(br.readLine() != null || !zeroCheck){
            int a = br.readLine().charAt(0)-'0';
            int b = br.readLine().charAt(2)-'0';
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}
