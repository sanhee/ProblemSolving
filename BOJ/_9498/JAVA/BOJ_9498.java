package com.example.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9498 {

    public static void main(String[] args)
    {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputScore = br.readLine();
            int nScore = Integer.parseInt(inputScore);

            if( nScore>= 90 && nScore<=100 ) {
                System.out.println("A");

            }else if( nScore>= 80 && nScore<=89 ) {

                System.out.println("B");
            }else if( nScore>= 70 && nScore<=79 )
            {
                System.out.println("C");

            }else if( nScore>= 60 && nScore<=69 )
            {
                System.out.println("D");
            }else
            {
                System.out.println("F");
            }


        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}
