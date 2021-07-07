package com.example.BOJ._10757.JAVA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//m 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
public class BOJ_10757 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");

        BigInteger a = new BigInteger(num[0]);
        BigInteger b = new BigInteger(num[1]);


        System.out.println(a.add(b));

        br.close();


    }
}
