package com.example.BOJ.후위표기식2_1935;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        double[] values = new double[N];

        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        double result = 0.0;

        for (char c : input) {
            if (Character.isAlphabetic(c)) {
                stack.push(values[(c - 65)]);  // 유니코드 A: 65
            } else {
                if (stack.size() > 1) {

                    double operand1 = stack.pop();
                    double operand2 = stack.pop();

                    switch (c) {

                        case '+':
                            stack.push((operand2 + operand1));
                            break;
                        case '-':
                            stack.push(operand2 - operand1);
                            break;
                        case '*':
                            stack.push(operand2 * operand1);
                            break;
                        case '/':
                            stack.push(operand2 / operand1);
                            break;

                    }
                }

            }
        }

        if(!stack.isEmpty()) {
            bw.write(String.format("%.2f",stack.pop()));
        }

        bw.flush();
    }

}
