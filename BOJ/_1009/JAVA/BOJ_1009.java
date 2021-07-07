package com.example.BOJ._1009.JAVA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1009 {

    static public void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] InputData = new String[2];

        int TestCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < TestCaseNum; i++) {
            InputData = br.readLine().split(" ");

            //int LastProcessID = Math.pow(Integer.parseInt(InputData[0]),Integer.parseInt(InputData[1]))%10;

            int base = Integer.parseInt(InputData[0]);
            int exponent = Integer.parseInt(InputData[1]);
            int result = 1;
            //m 블로그 참조
            for (int pow = 0; pow < exponent; pow++) {
                result = (result * base) % 10;
            }
            if (result == 0) result = 10;

            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

}
