package com.example.BOJ._2439.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2441 {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputStarNum = br.readLine();

            int nStar = Integer.parseInt(inputStarNum); // 별 개수
            int num = 0;

            for(int i=0; i<nStar;i++)
            {
                for(int j=0;j<nStar-i;j++)
                {
                    System.out.print("*");
                }

                System.out.print("\n");
            }


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
