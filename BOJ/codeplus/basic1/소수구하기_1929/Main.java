package com.example.BOJ.codeplus.basic1.소수구하기_1929;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            final String[] INPUT_RANGE = br.readLine().split(" ");
            final int RANGE_END = Integer.parseInt(INPUT_RANGE[1]);

            int[] prime = new int[1_000_000];
            boolean[] chekedNotPrime = new boolean[1_000_001];
            int primeCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= RANGE_END; i++) {
                if (!chekedNotPrime[i]) {
                    prime[primeCount++] = i;
                    if(i>2) {
                       sb.append(i).append(System.lineSeparator());
                    }

                    for(int j=i*2; j<=RANGE_END ; j+=i){
                        chekedNotPrime[j] = true;
                    }
                }
            }
            bw.write(sb.toString().trim());
            bw.flush();
        }
    }
}
