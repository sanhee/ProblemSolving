package com.example.BOJ._1052.JAVA;


import java.io.*;

public class BOJ_1052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int bitCount = Integer.bitCount(N);

        int temp = N;
        while (bitCount > K) {
            temp++;
            bitCount = Integer.bitCount(temp);
        }

        bw.write(temp - N + "");
        bw.flush();
    }

}
