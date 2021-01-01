package com.example.BOJ._1259.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (!buff.readLine().equals("0")) {
            sb.append(buff.readLine());
            System.out.println(sb);
        }


    }
}
