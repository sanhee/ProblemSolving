package com.example.BOJ.codeplus.basic1._9093.JAVA;

import java.io.*;
import java.util.*;

public class solution {
    //M 모범답안 참고
    //m 메모리: 29328 KB
    //m 시간: 596 ms

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCaseNum = Integer.parseInt(br.readLine());

            for (int testNum = 0; testNum < testCaseNum; testNum++) {

                String separatedLine = br.readLine()+'\n';
                Stack<Character> stack = new Stack<>();

                for(char word:separatedLine.toCharArray()){
                    if(word == ' ' || word == '\n'){
                        while (!stack.empty()){
                            bw.write(stack.pop());
                        }
                        bw.write(word); //m 마지막 'n'을 출력하기 위해 필요함.
                    }else{
                        stack.push(word);
                    }
                }
            }

            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}