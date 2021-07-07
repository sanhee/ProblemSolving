package com.example.BOJ.잃어버린괄호_1541;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> minusStack = new Stack<>();
        Stack<Integer> plusStack = new Stack<>();

        Scanner input = new Scanner(System.in);

        // 55-50+40
        String command = input.nextLine();

        boolean plusCheck = false;

        for (char word : command.toCharArray()) {

            if (!plusCheck) {
                minusStack.push(word - '0');
            }

            if (word == '+') {
                plusCheck = true;
            }

            if (word == '-') {


                plusCheck = false;
            }


        }


    }
}
