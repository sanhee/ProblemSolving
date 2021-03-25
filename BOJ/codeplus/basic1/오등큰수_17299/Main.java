package com.example.BOJ.codeplus.basic1.오등큰수_17299;

import java.io.*;
import java.util.Arrays;
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
        int[] sequence  = new int[MAX_COUNT];
        Map<Integer,Integer> sequenceMap = new HashMap<>();

        for(int i=0 ; i< MAX_COUNT ; i++){
            int cursorNumber = Integer.parseInt(inputLine[i]);
            sequence[i] = cursorNumber;
            if(sequenceMap.containsKey(cursorNumber)) {
                sequenceMap.put(cursorNumber, sequenceMap.get(cursorNumber) + 1);
                continue;
            }
            sequenceMap.put(cursorNumber, 1);
        }
        System.out.println(Arrays.toString(sequence));
        System.out.println(sequenceMap.toString());

        br.close();
        bw.close();
    }
}
