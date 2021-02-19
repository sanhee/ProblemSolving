package com.example.BOJ.codeplus.basic1._9093.JAVA;

import java.io.*;
import java.util.*;

public class solution {
    //M 처음 내가 작성한 코드
    //m 메모리: 34840 KB
    //m 시간: 680 ms

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCaseNum = Integer.parseInt(br.readLine());

            for (int testNum = 0; testNum < testCaseNum; testNum++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                while (st.hasMoreTokens()) {
                    String t = st.nextToken();
                    int len = t.length();
                    for (int i = 0; i < len; i++) {
                        stack.push(t.charAt(i));
                    }
                    while (!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                }
                bw.newLine();
            }

            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}