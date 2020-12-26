package com.example.BOJ._10951.JAVA;

import java.util.Scanner;

public class BOJ_10951 {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
