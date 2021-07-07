package com.example.BOJ.스택_10828;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int testNum = Integer.parseInt(br.readLine());

        while (testNum-- > 0) {

            String[] command = br.readLine().split(" ");

            switch (command[0]) {

                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(stack.pop() + "");
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(stack.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    bw.newLine();
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(stack.peek() + "");
                    }
                    bw.newLine();
                    break;
            }
        }

        bw.flush();

    }
}
