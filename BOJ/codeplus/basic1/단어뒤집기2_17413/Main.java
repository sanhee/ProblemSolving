package com.example.BOJ.codeplus.basic1.단어뒤집기2_17413;

import java.io.*;
import java.util.Stack;

/**
 * Created by 68936@naver.com on 2021-03-15 오후 10:20
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> reverseWord = new Stack<>();
        boolean bracketFlag = false; //m 괄호 < 를 만나게 될 경우 true
        StringBuilder result = new StringBuilder();

        char[] inputCharArray = br.readLine().toCharArray();

        for (Character c : inputCharArray) {
            switch (c) {
                case '<':
                    bracketFlag = true;

                    while (!reverseWord.isEmpty()) {
                        result.append(reverseWord.pop());
                    }

                    result.append(c);
                    break;
                case '>':
                    bracketFlag = false;
                    result.append(c);
                    break;
                case ' ':

                    while (!reverseWord.isEmpty()) {
                        result.append(reverseWord.pop());
                    }

                    result.append(c);
                    break;
                default:
                    if (bracketFlag) {
                        result.append(c);
                    }
                    if (!bracketFlag) {
                        reverseWord.push(c);
                    }
                    break;
            }
        }

        while (!reverseWord.isEmpty()) {
            result.append(reverseWord.pop());
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
