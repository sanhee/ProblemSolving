package com.example.BOJ._8958.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {


    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String InputSTR = "";
        StringBuilder sb = new StringBuilder(); // 개별적인 출력 결과를 잇기 위한 스트링빌드

        int testCaseNum = Integer.parseInt(buff.readLine()); // 테스트케이스 개수

        for (int i = 0; i < testCaseNum; i++) {
            int totalSUM = 0;
            int cnt = 0;
            InputSTR = buff.readLine();
            int strLen = InputSTR.length();

            for (int j = 0; j < strLen; j++) {

                if (InputSTR.charAt(j) == 'O') {
                    cnt = cnt + 1;
                    totalSUM += cnt;
                } else {
                    cnt = 0;
                }

            }

            sb.append(totalSUM).append('\n');

        }
        System.out.println(sb);
    }
}
