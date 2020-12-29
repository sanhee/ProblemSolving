package com.example.BOJ._10869.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10869 {


    public static void main(String[] args) throws IOException {

        BufferedReader KeyboardInput = new BufferedReader(new InputStreamReader(System.in));

        String StrIn = KeyboardInput.readLine();
        String[] StrNum = StrIn.split(" ");

        int num1 = Math.max(Integer.parseInt(StrNum[0]), 1);
        int num2 = Math.min(Integer.parseInt(StrNum[1]), 10000);

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);
        System.out.println(num1 % num2);
    }
}
