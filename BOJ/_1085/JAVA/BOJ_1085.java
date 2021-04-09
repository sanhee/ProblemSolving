package com.example.BOJ._1085.JAVA;

import java.io.*;

public class BOJ_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputCommand = br.readLine().split(" ");

        int x = Integer.parseInt(inputCommand[0]); // x->0 까지 거리
        int y = Integer.parseInt(inputCommand[1]);  // y->0 까지 거리
        int w = Integer.parseInt(inputCommand[2]);
        int h = Integer.parseInt(inputCommand[3]);

        x = Math.min(x, w - x); // x-> w까지 거리와 어떤게 더 가까운지 비교
        y = Math.min(y, h - y);

        bw.write(String.valueOf(Math.min(x,y)));
        bw.flush();

        bw.close();
        br.close();

    }
}
