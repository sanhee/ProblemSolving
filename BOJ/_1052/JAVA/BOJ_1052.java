package com.example.BOJ._1052.JAVA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr[] = br.readLine().split(" ");

        int n = Integer.parseInt(inputStr[0]);
        int k = Integer.parseInt(inputStr[1]);
        int need = 0;

        int bitCount = Integer.bitCount(n);

        if(bitCount<=k) need = 0;
        else{
            for(int i=0;i<n;i++){
                int temp = (int)Math.pow(2,i); //m 2^n ...
                if(n<temp){
                    need = temp-n;
                    break;
                }
            }
        }

        System.out.println(need);

        br.close();
    }

}
