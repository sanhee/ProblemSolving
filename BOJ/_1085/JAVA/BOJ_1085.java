package com.example.BOJ._1085.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085 {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer InputStr = new StringTokenizer(buff.readLine()," ");

        int x = Integer.parseInt(InputStr.nextToken());
        int y = Integer.parseInt(InputStr.nextToken());
        int w = Integer.parseInt(InputStr.nextToken());
        int h = Integer.parseInt(InputStr.nextToken());

        int x_min = Math.min(x,w-x);
        int y_min = Math.min(y,h-y);

        System.out.println(Math.min(x_min,y_min));
    }
}
