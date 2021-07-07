package com.example.hackerrank.time_conversion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

        StringBuilder sb = new StringBuilder(s);

        String strHour = s.charAt(0) + "" + s.charAt(1);
        int nHour = Integer.parseInt(strHour);

        if (s.contains("PM")) {
            nHour = nHour < 12 ? nHour + 12 : nHour;
            sb.delete(sb.indexOf("P"), sb.length());
        } else if (s.contains("AM")) {
            nHour = nHour >= 12 ? nHour - 12 : nHour;
            sb.delete(sb.indexOf("A"), sb.length());
        }

        if (nHour / 10 >= 1) {
            sb.replace(0, 2, Integer.toString(nHour));
        } else {
            sb.replace(0, 1, "0");
            sb.replace(1, 2, Integer.toString(nHour));
        }
        return sb.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
