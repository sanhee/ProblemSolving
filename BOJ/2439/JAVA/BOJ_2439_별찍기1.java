package com.example.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2439_별찍기1 {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputStarNum = br.readLine();

            int nStar = Integer.parseInt(inputStarNum); // 별 개수

            for(int i=1;i<=nStar;i++)
            {
                for(int j=0;j<i;j++)
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
