package com.example.BOJ.codeplus.basic1._1874.JAVA;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int cursor = 0; // 스택에 들어간 마지막 수
        StringBuilder strOut = new StringBuilder();

        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {

            int inputSequence = Integer.parseInt(br.readLine()); // 입력된 수열

            if(cursor < inputSequence){
                while (cursor != inputSequence) {
                    stack.push(++cursor);
                    strOut.append("+");
                }
            }
            if(cursor >= inputSequence) {
                while (!stack.empty()) {
                    stack.pop();
                    if(cursor==inputSequence){
                        strOut.append("-");
                    }else{
                        strOut = new StringBuilder();
                        strOut.append("NO");
                        break;
                    }
                }
            }
        }
        bw.write(strOut.toString());
        bw.flush();
    }

}
