package com.example.BOJ.codeplus.basic1.단어뒤집기_9093.JAVA;

import java.io.*;
import java.util.*;

public class solution {
    //M 모범답안 참고
    //m 메모리: 28864 KB
    //m 시간: 572 ms
    //m try-with-resources 구문을 빼고 메소드에 throws 예외를 지명했더니, 좀 더 빨라졋다.
    //m for문에 있는 변수 선언을 안하고 while에서 테스트케이스를 줄이면서 진행했더니 좀더 빨라졌다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {

            String separatedLine = br.readLine() + '\n';
            Stack<Character> stack = new Stack<>();

            for (char word : separatedLine.toCharArray()) {
                if (word == ' ' || word == '\n') {
                    while (!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(word); //m 마지막 'n'을 출력하기 위해 필요함.
                } else {
                    stack.push(word);
                }
            }
        }
        bw.flush();
    }
}
