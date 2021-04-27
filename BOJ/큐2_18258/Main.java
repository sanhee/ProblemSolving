package com.example.BOJ.큐2_18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new ArrayDeque<>();

        int testNum = Integer.parseInt(br.readLine());

        while(testNum-- > 0){

            String[] command = br.readLine().split(" ");

            switch (command[0]){

                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else {
                        bw.write(queue.pop()+"");
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(queue.size()+"");
                    bw.newLine();
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        bw.write("1");
                    }else{
                        bw.write("0");
                    }
                    bw.newLine();
                    break;
                case "front":
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(queue.getFirst()+"");
                    }
                    bw.newLine();
                    break;
                case "back":
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(queue.getLast()+"");
                    }
                    bw.newLine();
                    break;
            }
        }

        bw.flush();

    }
}
