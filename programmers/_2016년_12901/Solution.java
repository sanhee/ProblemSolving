package com.example.programmers._2016년_12901;

import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);

        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        switch (localDate.getDayOfWeek().toString()) {

            case "SUNDAY":
                return day[0];
            case "MONDAY":
                return day[1];
            case "TUESDAY":
                return day[2];
            case "WEDNESDAY":
                return day[3];
            case "THURSDAY":
                return day[4];
            case "FRIDAY":
                return day[5];
            case "SATURDAY":
                return day[6];
        }

        return "";
    }
}
