package com.example.BOJ.codeplus.basic1.오등큰수_17299;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer,Integer> sequence = new HashMap<>();

        for(int i=0 ; i< MAX_COUNT ; i++){
            int cursorNumber = Integer.parseInt(inputLine[i]);

            sequence.put(cursorNumber,sequence.get(cursorNumber)+1);
        }
        System.out.println(sequence.toString());

        br.close();
        bw.close();
    }
}
