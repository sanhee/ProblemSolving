package com.example.BOJ.codeplus.basic1._1874.JAVA;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int cursor = 0; // 스택에 들어간 마지막 수

        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {

            int inputSequence = Integer.parseInt(br.readLine()); // 입력된 수열

            if(cursor < inputSequence){
                while (cursor != inputSequence) {
                    stack.push(++cursor);
                    bw.write("+");
                    bw.newLine();
                }
            }
            if(cursor >= inputSequence) { //스택에 들어갔던 마지막 수가 입력된 수열보다 크거나 같을 경우
                if(stack.pop()==inputSequence){
                    bw.write("-");
                    bw.newLine();
                }else{ // pop 을 할때마다 수열이 만들어지므로, 불가능한 경우
                    bw = new BufferedWriter(new OutputStreamWriter(System.out));
                    bw.write("NO");
                    break;
                }
            }
        }
        bw.flush();
    }
}
