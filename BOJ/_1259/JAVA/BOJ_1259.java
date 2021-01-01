package com.example.BOJ._1259.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder command = new StringBuilder();
        StringBuilder command2 = new StringBuilder();


        while (true) {
            command.insert(0,buff.readLine());
            if(command.length() == 1 && command.charAt(0) == '0') break;

            command2.insert(0, command);
            command.reverse();

            boolean check = true;
            for(int i=0; i<command.length();i++){
                if(command.charAt(i)!=command2.charAt(i)){
                    check = false;
                }
            }
            if(check){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }

            command.delete(0,command.length());
            command2.delete(0,command2.length());

        }
        System.out.println(sb);

    }
}
