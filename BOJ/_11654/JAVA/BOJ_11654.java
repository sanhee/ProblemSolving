package com.example.BOJ._11654.JAVA;


// TODO. 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11654 {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        char Input = buff.readLine().charAt(0);

        int ASCII_NUM = (int) Input;

        System.out.println(ASCII_NUM);


    }
}
