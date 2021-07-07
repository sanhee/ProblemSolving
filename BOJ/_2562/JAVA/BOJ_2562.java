package com.example.BOJ._2562.JAVA;


//TODO. 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성
//O 3번째 시도 : 배열 사용 X, 재귀함수 제거, try-catch 구문 제거 및 throws IOException 추가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562 {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int number = 0;
            number = Integer.parseInt(buf.readLine());

            if (maxValue < number) {
                maxValue = number;
                index = i + 1;
            }
        }
        System.out.println(maxValue);
        System.out.println(index);
    }
}
