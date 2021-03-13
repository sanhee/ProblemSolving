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

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int n=0; n<(N-1);n++){  // 이 과정은 N명의 사람이 모두 제거될 때까지 계속되지만, queue에 남아있는 마지막 K를 지울 때 ',' 를 더하면 안되므로 N-1까지 조건
            for(int k=0 ; k<(K-1); k++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
