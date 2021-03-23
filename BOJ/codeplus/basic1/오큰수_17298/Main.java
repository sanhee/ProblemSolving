package com.example.BOJ.codeplus.basic1.오큰수_17298;

import java.io.*;
import java.util.Stack;

/**
 * Created by 68936@naver.com on 2021-03-24 오전 12:42
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());
        String[] inputSequence = br.readLine().split(" ");
        int[] nge = new int[inputSequence.length];

        Stack<Integer> stack = new Stack<>();

        while (testCaseCount-- > 0) {
            for (int index = 0; index < inputSequence.length; index++) {
                int currentElement = Integer.parseInt(inputSequence[index]);

                if (stack.isEmpty()) {
                    stack.push(index);
                }
                while (stack.isEmpty()) {
                    if (Integer.parseInt(inputSequence[stack.peek()]) < currentElement) { // 오큰수 일경우
                        nge[stack.pop()] = currentElement;
                    } else {
                        break;
                    }
                }
            }
        }

        if (stack.size() == 1) {
            nge[stack.pop()] = -1;
        }

        for (int n : nge) {
            bw.write(n+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
