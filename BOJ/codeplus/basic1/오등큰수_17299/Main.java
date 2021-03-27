package com.example.BOJ.codeplus.basic1.오등큰수_17299;

import java.io.*;
import java.util.Stack;

/**
 * Created by 68936@naver.com on 2021-03-25 오후 8:26
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX_COUNT = Integer.parseInt(br.readLine());
        final String[] inputLine = br.readLine().split(" ");
        int[] sequence = new int[MAX_COUNT];
        int[] NGF = new int[MAX_COUNT];
        int[] frequent = new int[1000001]; // 원소 범위: 1 ≤ Ai ≤ 1,000,000
        Stack<Integer> stack = new Stack<>(); // 스택에 쌓으면서 각 요소의 NGF를 구하기 위함임.

        for (int i = 0; i < MAX_COUNT; i++) {  //m 수열을 담고, 등장횟수를 계산하는 반복문
            sequence[i] = Integer.parseInt(inputLine[i]);
            frequent[sequence[i]] += 1;
        }

        for (int i = 0; i < MAX_COUNT; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && frequent[sequence[stack.peek()]] < frequent[(sequence[i])]) {
                NGF[stack.pop()] = sequence[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            NGF[stack.pop()] = -1;
        }

        for (int n : NGF) {
            bw.write(n + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
