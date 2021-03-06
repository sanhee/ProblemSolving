package com.example.BOJ._2439.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputStarNum = br.readLine();

            int nStar = Integer.parseInt(inputStarNum); // 별 개수
            int num = 0;

            for (int i = 1; i <= nStar; i++) {
                num = nStar - i;

                for (int j = 0; j < num; j++) {
                    System.out.print(" ");
                }
                for (int j = num; j < nStar; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
