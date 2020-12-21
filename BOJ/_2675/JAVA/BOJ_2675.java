package com.example.BOJ._2675.JAVA;

// TODO. 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
// TODO. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buff.readLine()); // 테스트 케이스 개수

        for (int i=0;i<T;i++) {
            String[] InPutData = buff.readLine().split(" "); // 공백을 기준으로 짤라서 배열에 넣는다.

            int R = Integer.parseInt(InPutData[0]); // 문자 반복 횟수
            String S = InPutData[1]; // 문자열

            for(int j=0;j<S.length();j++)
            {
                for(int k=0;k<R;k++){
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }

    }
}
