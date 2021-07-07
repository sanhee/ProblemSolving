package com.example.BOJ._10818.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {


    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(buff.readLine());

        StringTokenizer strToken = new StringTokenizer(buff.readLine(), " ");

        int max = -1000000;
        int min = 1000000;

        while (strToken.hasMoreTokens()) {
            int val = Integer.parseInt(strToken.nextToken());

            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }

        }
        System.out.println(min + " " + max);


    }
}
