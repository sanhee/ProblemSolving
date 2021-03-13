package com.example.BOJ.codeplus.basic1.덱_10866;

import java.io.*;
import java.util.*;

/**
 * Created by 68936@naver.com on 2021-03-13 오후 5:27
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int testcaseCount = Integer.parseInt(br.readLine());

        while (testcaseCount-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekFirst() + "");
                    } else {
                        bw.write(-1 + "");
                    }
                    bw.newLine();
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "");
                    } else {
                        bw.write(-1 + "");
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekLast() + "");
                    } else {
                        bw.write(-1 + "");
                    }
                    bw.newLine();
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "");
                    } else {
                        bw.write(-1 + "");
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(deque.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(1 + "");
                    } else {
                        bw.write(0 + "");
                    }
                    bw.newLine();
                    break;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
