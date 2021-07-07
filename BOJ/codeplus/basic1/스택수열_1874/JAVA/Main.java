package com.example.BOJ.codeplus.basic1.스택수열_1874.JAVA;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int cursor = 0; // 스택에 들어간 마지막 수
        StringBuilder sb = new StringBuilder();
        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {

            int inputSequence = Integer.parseInt(br.readLine()); // 입력된 수열

            if (cursor < inputSequence) {
                while (cursor != inputSequence) {
                    stack.push(++cursor);
                    sb.append("+").append("\n");
                }
            }
            if (cursor >= inputSequence) { //스택에 들어갔던 마지막 수가 입력된 수열보다 크거나 같을 경우
                if (stack.pop() == inputSequence) {
                    sb.append("-").append("\n");
                } else { // pop 을 할때마다 수열이 만들어지므로, 불가능한 경우
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
