package com.example.LeetCode.ReverseInteger;

public class Solution {

    public static int reverse(int x) {

        StringBuilder sb = new StringBuilder(""+x);
        int answer = 0;
        boolean negative = false;
        System.out.println();
        System.out.println(sb);

        if (sb.charAt(sb.length()-1) == '-'){  //m -8463847412- 예외처리를 위해
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.charAt(0) == '-'){
            negative = true;
            sb.deleteCharAt(0);
        }
        sb.reverse();

        if(negative){
            if (sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
            sb.insert(0,"-");
        }
        if (sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        double temp = Double.parseDouble(sb.toString());

        if ( temp>Integer.MAX_VALUE || temp<Integer.MIN_VALUE) { // 정수범위 체크
            answer = 0; // 정수 범위를 벗어날 경우
        }
        else {
            answer = Integer.parseInt(sb.toString());
        }
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {

        reverse(123);
        reverse(-123);
        reverse(120);
        reverse(-530);
        reverse(0);
        //reverse(-8463847412-);

    }
}
