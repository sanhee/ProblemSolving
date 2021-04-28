package com.example.BOJ.균형잡힌세상_4949;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        while (true) {
            char[] charArray = br.readLine().toCharArray();

            if (charArray.length == 1 && charArray[0] == '.') {
                break;
            }

            for (char c : charArray) {

                if (!Character.isAlphabetic(c)) { // 특수문자 일 때

                    switch (c) {

                        case '(':
                        case '[':
                            stack.push(c);
                            break;
                        case ')':
                            if (!stack.isEmpty() && stack.peek() == '(') {
                                stack.pop();
                            } else if (stack.isEmpty()) {
                                stack.push(c);
                            }
                            break;
                        case ']':
                            if (!stack.isEmpty() && stack.peek() == '[') {
                                stack.pop();
                            } else if (stack.isEmpty()) {
                                stack.push(c);
                            }
                            break;

                    }

                }

            }
            if (stack.isEmpty()) {
                sb.append("yes").append(System.lineSeparator());
            } else {
                sb.append("no").append(System.lineSeparator());
            }
            stack = new Stack<>();
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}
