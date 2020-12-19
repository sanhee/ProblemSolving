package com.example.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2753_윤년 {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputYear = br.readLine();

            int nYear = Integer.parseInt(inputYear);

            if ( (nYear%4 == 0 && nYear%100 != 0) ||  (nYear % 400 == 0) )
                System.out.println(1);
            else
                System.out.println(0);


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
