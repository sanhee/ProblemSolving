package com.example.BOJ.후위표기식2_1935;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfOperand = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();

        for(char word : expression){
            if(Character.isAlphabetic(word)){

            }
        }

        Map<Character, Integer> mapOfOperand = new HashMap<>();
        for (int i = 0; i < numberOfOperand; i++) {

        }

        bw.flush();
    }
}
