package com.example.BOJ.codeplus.basic1.최소공배수_1934;

import java.util.Scanner;

public class Main {
    public static int lcm(int a, int b){
        int multiply = a*b;

        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return multiply/a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCaseCount = sc.nextInt();

        while (testCaseCount-- > 0){
            sb.append(lcm(sc.nextInt(), sc.nextInt())).append(System.lineSeparator());
        }
        System.out.print(sb.toString());

        sc.close();
    }
}
