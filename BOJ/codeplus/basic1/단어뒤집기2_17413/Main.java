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
        int bracketFlag = 0; //m
        StringBuilder result = new StringBuilder();

        char[] inputCharArray = br.readLine().toCharArray();
        int arraylength = inputCharArray.length;

        for (int i = 0; i < arraylength; i++) {
            switch (inputCharArray[i]) {
                case '<':
                    bracketFlag = (bracketFlag == 0) ? 1 : 3;
                    if(bracketFlag == 1) {
                        result.append(inputCharArray[i]);
                    }else if(bracketFlag == 3){
                        while(!reverseWord.isEmpty()){
                            result.append(reverseWord.pop());
                        }
                        result.append(inputCharArray[i]);
                    }
                    break;
                case '>':
                    bracketFlag = 2;
                    result.append(inputCharArray[i]);
                    break;
                default:
                    if (bracketFlag % 2 != 0) {
                        result.append(inputCharArray[i]);
                    }
                    if (bracketFlag == 2 || bracketFlag == 0) {
                        reverseWord.push(inputCharArray[i]);
                    }
                    break;
            }
        }
        while(!reverseWord.isEmpty()){
            result.append(reverseWord.pop());
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
