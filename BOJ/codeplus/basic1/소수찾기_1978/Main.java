package com.example.BOJ.codeplus.basic1.소수찾기_1978;

import java.io.*;

public class Main {

    public static boolean prime(int num){
        if(num < 2) return false;

        for(int i=2 ; i*i<=num ; i++){
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

        final int testcaseMax = Integer.parseInt(br.readLine());
        String[] intputCommand = br.readLine().split(" ");
        int check = 0;
        for(int i =0; i< testcaseMax; i++){
            check = prime(Integer.parseInt(intputCommand[i])) ? ++check:check;
        }

        bw.write(String.valueOf(check));
        bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
