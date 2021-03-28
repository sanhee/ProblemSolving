package com.example.BOJ.codeplus.basic1.나머지_10430;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.printf("%d"+System.lineSeparator(),(a+b)%c);
        System.out.printf("%d"+System.lineSeparator(),((a%c)+(b%c)%c));
        System.out.printf("%d"+System.lineSeparator(),(a*b)%c);
        System.out.printf("%d"+System.lineSeparator(),((a%c)*(b%c)%c));

        sc.close();
    }
}
