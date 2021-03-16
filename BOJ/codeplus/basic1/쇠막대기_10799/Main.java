package com.example.BOJ.codeplus.basic1.쇠막대기_10799;

import java.io.*;
import java.util.Stack;

/**
 * Created by 68936@naver.com on 2021-03-16 오후 12:00
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> openBracketStack = new Stack<>();
        int totalCount = 0;
        char[] inputCharArray = br.readLine().toCharArray();
        boolean closeBracketCheck = false;

        for(Character c : inputCharArray){

            switch (c){
                case '(':
                    closeBracketCheck = false;
                    openBracketStack.push(c);
                    break;
                case ')':
                    if(closeBracketCheck){
                        totalCount+=1;
                        openBracketStack.pop();
                    }else{
                        if (!openBracketStack.isEmpty()){
                            openBracketStack.pop();

                            totalCount += openBracketStack.size();
                        }
                        closeBracketCheck = true;
                    }
                    break;
            }
        }
        bw.write(String.valueOf(totalCount));
        bw.flush();

        br.close();
        bw.close();
    }
}
