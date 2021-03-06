package com.example.BOJ.codeplus.basic1.괄호_9012.JAVA;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ParenthesisString = "";
        int testcaseNum = Integer.parseInt(br.readLine());
        int openCount = 0;

        while (testcaseNum-- > 0) {
            ParenthesisString = br.readLine();

            for (char word : ParenthesisString.toCharArray()) {
                if (word == '(') {
                    openCount++;
                } else if (word == ')') {
                    openCount--;
                }
                if (openCount < 0) { // 여는 괄호가 부족할 경우, 종료
                    bw.write("NO");
                    bw.write(System.lineSeparator());
                    break;
                }
            }
            if (openCount == 0) {// 모든 괄호가 짝이 맞음, 즉, ValidParenthesisString 만족
                bw.write("YES");
                bw.write(System.lineSeparator());
            } else if (openCount > 0) { // 여는 괄호가 더 많을 때
                bw.write("NO");
                bw.write(System.lineSeparator());
            }
            openCount = 0;
        }
        bw.flush();
    }
}