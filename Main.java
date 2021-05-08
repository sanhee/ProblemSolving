package com.example;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcaseCount = Integer.parseInt(br.readLine());


        while (testcaseCount-- > 0) {

            String input = br.readLine();
            char[] commands = input.replaceAll("[a-zA-Z0-9]", "").toCharArray();
            String keys = input.replaceAll("[^a-zA-Z0-9]", "");

            List<Character> keyList = new LinkedList<>();
            ListIterator<Character> cursor = keyList.listIterator();

            for (Character key : keys.toCharArray()) {
                keyList.add(key);
            }

            for (char cmd : commands) {
                switch (cmd){
                    case '>':
                        if(cursor.hasNext()){
                            cursor.next();
                        }
                        break;
                    case '<':
                        if(cursor.hasPrevious()){
                            cursor.previous();
                        }
                        break;
                    case '-':
                        if(cursor.hasPrevious()){
                            cursor.previous();
                            cursor.remove();
                        }
                        break;

                }
            }


        }

        bw.flush();
    }

}
