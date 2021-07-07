package com.example.BOJ.균형잡힌세상_4949;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        while (true) {
            char[] charArray = br.readLine().toCharArray();

            if (charArray.length == 1 && charArray[0] == '.') {
                break;
            }

            boolean check = true;

            for (char c : charArray) {
                if (!Character.isAlphabetic(c)) { // 특수문자 일 때
                    switch (c) {
                        case '(':
                        case '[':
                            stack.push(c);
                            break;
                        case ')':
                            if (stack.isEmpty() || stack.pop() != '(') {
                                check = false;
                            }
                            break;
                        case ']':
                            if (stack.isEmpty() || stack.pop() != '[') {
                                check = false;
                            }
                            break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                check = false;
            }
            if (check) {
                bw.write("yes");
                bw.newLine();
            } else {
                bw.write("no");
                bw.newLine();
            }
            stack.clear();
        }
        bw.flush();
    }
}
