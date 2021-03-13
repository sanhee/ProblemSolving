package com.example.BOJ.codeplus.basic1.요세푸스_1158;

import java.io.*;
import java.util.*;

/**
 * Created by 68936@naver.com on 2021-03-13 오후 2:25
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */

// 큐를 이용한 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputCommand = br.readLine().split(" ");
        int N = Integer.parseInt(inputCommand[0]);
        int K = Integer.parseInt(inputCommand[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<= N; i++){
            queue.add(i);
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            if (count < K) {
                queue.offer(queue.poll());
            }
            if (count == K){
                sb.append(queue.poll());
            }
            count++;

            if (count > K && !queue.isEmpty()){
                count = 1;
            }
        }
        String[] strArr = sb.toString().split("");
        StringJoiner sj = new StringJoiner(", ", "<",">");
        for(String s : strArr){
            sj.add(s);
        }
        bw.write(sj.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
