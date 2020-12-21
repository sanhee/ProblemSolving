package com.example.BOJ._1330.JAVA;

/*
   1330	두 수 비교하기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1330 {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputNumbers = br.readLine(); //입력받을값이 int일때

            // 먼저 @ 의 인덱스를 찾는다.
            int idx = inputNumbers.indexOf(" ");

            String strFirst =  inputNumbers.substring(0, idx);
            String strSecond =  inputNumbers.substring(idx+1);

            int nFirst = Integer.parseInt(strFirst);
            int nSecond = Integer.parseInt(strSecond);

            String str = "";
            if (nFirst == nSecond )
            {
                str = "==";
            } else
            {
                str = (nFirst>nSecond) ? ">" : "<";
            }
            System.out.println(str);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
