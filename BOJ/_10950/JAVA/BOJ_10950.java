package com.example.BOJ._10950.JAVA;

import java.util.Scanner;

public class BOJ_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int TestCaseNum = sc.nextInt();

        for (int i = 0; i < TestCaseNum; i++) {
            sb.append(sc.nextInt() + sc.nextInt()).append("\n");
        }
        System.out.println(sb);
    }
}
