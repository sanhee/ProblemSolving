package com.example.BOJ.카드2_2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        // 풀이시간 : 13분
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++){
            queue.add(i);
        }

        while(!queue.isEmpty() && queue.size() != 1){
            queue.remove(); // 첫번째 값 제거
            queue.add(queue.poll());
        }

        if(!queue.isEmpty()) {
            bw.write(queue.poll()+"");
        }

        bw.flush();

    }
}
