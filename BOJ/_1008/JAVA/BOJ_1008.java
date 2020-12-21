package com.example.BOJ._1008.JAVA;


import java.util.Scanner;

public class BOJ_1008 {

    static public void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextInt();
        double b = sc.nextInt();

        if(a < 0 || b>10) return;

        double div = a/b;
        System.out.println(String.format("%.9f",div));

        sc.close();

    }

}
