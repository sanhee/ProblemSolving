package com.example.BOJ._114681.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14681 {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String strStartNumber = br.readLine();
            String strEndNumber = br.readLine();

            int nStart = Integer.parseInt(strStartNumber);
            int nEnd = Integer.parseInt(strEndNumber);

            int answer = 0;

            if (nStart > 0) // 1사분면 또는 4사분면
            {
                answer = nEnd>0 ? 1:4;
            } else // 2사분면 또는 3사분면
            {
                answer = nEnd>0 ? 2:3;
            }

            System.out.println(answer);


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
