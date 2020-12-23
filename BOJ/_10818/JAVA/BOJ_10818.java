package com.example.BOJ._10818.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int TestCaseNum = Integer.parseInt(buff.readLine());
        String[] arrayNum = buff.readLine().split(" ");

        int[] answer = new int[2];

        for(int i=0;i<TestCaseNum-1;i++){
            answer[0] = Math.min(Integer.parseInt(arrayNum[i]), Integer.parseInt(arrayNum[i + 1]));
            answer[1] = Math.max(Integer.parseInt(arrayNum[i]), Integer.parseInt(arrayNum[i + 1]));
        }
        System.out.println(answer[0]+" "+answer[1]);

    }
}
