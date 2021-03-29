package com.example.BOJ.codeplus.basic1.GCD와LCM_2609;

import java.io.*;

public class Main {
    public static int gcd(int a, int b){
        // 유클리드 호제법
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        bw.write(String.valueOf(gcd(a,b)));
        bw.newLine();
        bw.write(String.valueOf(a*b/gcd(a,b)));

        bw.flush();
        br.close();
        bw.close();
    }
}
