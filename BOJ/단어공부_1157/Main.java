package com.example.BOJ.단어공부_1157;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toUpperCase(Locale.ROOT).toCharArray();

        int[] count = new int[26];

        Arrays.fill(count, 0);


        for (int i = 0; i < input.length; i++) {
            count[input[i] - 'A'] += 1;
        }

        int max = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[max] < count[i]) {
                max = i;
            }
        }

        int cnt = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[max] == count[i]) {
                cnt++;
            }
        }


        if (cnt > 1) {
            bw.write('?');
        } else {
            bw.write(max + 'A');
        }


        bw.flush();
    }
}
