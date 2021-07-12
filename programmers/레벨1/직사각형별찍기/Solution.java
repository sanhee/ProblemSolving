package com.example.programmers.레벨1.직사각형별찍기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowMax = sc.nextInt();
        int columnMax = sc.nextInt();

        for(int column=0; column<columnMax ; column++){
            for(int row=0; row<rowMax ; row++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
