package com.example.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2884_알람시계 {
    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inputTime = br.readLine(); //입력받을값이 int일때

            // 먼저 @ 의 인덱스를 찾는다.
            int idx = inputTime.indexOf(" ");

            String strHour =  inputTime.substring(0, idx);
            String strMinutes =  inputTime.substring(idx+1);

            int nHour = Integer.parseInt(strHour);
            int nMinutes = Integer.parseInt(strMinutes);

            int earlyMinute = 45;  //  "45분 일찍 알람 설정 정적변수"
            int earlyAlarm = nMinutes-earlyMinute;  // 입력된 알람시간의 분에서 45분 마이너스

            if(earlyAlarm < 0) { // 음수일 경우, 시간과 분을 뒤로 돌려야 하므로,
                if(nHour == 0) { // 0시 인경우 23시를 만들기 위해
                    nHour = 23;
                }
                else {
                    nHour--;
                }
                nMinutes = 60+ earlyAlarm; // 음수인 Minute을 60분에서 빼준다.
            }
            else { // 양수일 경우, 시간을 돌릴 필요 없음.
                nMinutes = earlyAlarm;
            }

            System.out.println(nHour+" "+nMinutes);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
