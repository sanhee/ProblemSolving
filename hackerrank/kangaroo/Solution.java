package com.example.hackerrank.kangaroo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

    //m 소요시간 : 약 2시간..
    static String kangaroo(int x1, int v1, int x2, int v2) {

        int curDiff = 0;
        int preDiff;
        int cnt = 0;

        while (true) {

            preDiff = curDiff;
            curDiff = Math.abs(x1 - x2);

            if (x1 != x2 && v1 == v2) {  //m 처음 설계할 때는 생각했는데, 코드를 다시 짜다보니 추가하지 못했다. 이거 역시 테스트 케이스를 보고 알았다..
                return "NO";
            }
            if (cnt > 0) {
                if (preDiff - Math.abs(v1 - v2) != curDiff) { //m 일정한 감소폭 패턴은 v2-v1을 통해 구할 수 있다.
                    //m x1 =14, v1 = 4, x2=98, v2 = 2 의 반례를 생각하지 못하고 테스트 케이스를 보고 알았다.
                    return "NO";
                }
                if (curDiff == 0) {
                    return "YES";
                }
            }
            x1 += v1;
            x2 += v2;

            cnt++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);
        int v1 = Integer.parseInt(x1V1X2V2[1]);
        int x2 = Integer.parseInt(x1V1X2V2[2]);
        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
