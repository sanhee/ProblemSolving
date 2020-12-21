package com.example.BOJ._11720.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputMax = br.readLine();
            String inputNumber = br.readLine();

            String[] array_num; // 스트링을 담을 배열

            array_num = inputNumber.split(""); // 배열에 한글자씩 저장
            int nSum = 0; // 입력된 수의 합산을 담을 변수

            for(int i=0; i<Integer.parseInt(inputMax);i++) {
                nSum = nSum+Integer.parseInt(array_num[i]);
            }
            System.out.println(nSum);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
