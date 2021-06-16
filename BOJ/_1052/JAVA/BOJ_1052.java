package com.example.BOJ._1052.JAVA;


import java.io.*;

public class BOJ_1052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]); // 현재 물병의 개수
        int K = Integer.parseInt(inputs[1]); // 한번에 옮길 수 있는 물병의 개수

        // 물병의 개수의 비트 개수를 구하면, 한번에 옮길 수 있는지 판단할 수 있음.
        // ex) N:3 (11), K:1
        int bitCount = Integer.bitCount(N);

        // 2의 거듭제곱인 경우에 물병을 한번에 옮길 수 있음.
        // 2의 거듭제곱의 bit는 1이 한개만 존재함. 1 2 4 8 16..
        // 필요한 물병은 현재 물병 이후, 2의 거듭제곱인 물병의 개수에서 빼면 구할 수 있음.
        int temp = N;
        while (bitCount > K) {
            temp++;
            bitCount = Integer.bitCount(temp);
        }

        bw.write(temp - N + "");
        bw.flush();
    }

}
