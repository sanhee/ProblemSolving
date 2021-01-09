package com.example.BOJ._1052.JAVA;


import java.util.Arrays;

public class BOJ_1052 {

    static public void bottle(int a, int b){
        System.out.println("------------------------------");
        System.out.println(a+" "+b);
        System.out.println("------------------------------");
        int N = a; //m N개의 물병을 가지고 있다.
        int K = b; //m 한 번에 K개의 물병을 옮길 수 있다
        int max_cnt = 0;
        int remain_cnt = 0;
        int result = 0;
        int[] bottle = new int[N];
        Arrays.fill(bottle, 1); //m 기본 1L 제공


        if(N>K){
            for(int i=0;i<bottle.length-1;i++){
                if(bottle[i] != 0 && bottle[i] == bottle[i+1]) {
                    bottle[i] += bottle[i + 1];
                    bottle[i + 1] = 0;
                }
            }

            Arrays.sort(bottle); // 배열 정렬
            System.out.println("bottle 최대값: "+bottle[bottle.length-1]);

            for(int i=0;i<bottle.length;i++){
                if(bottle[i] == bottle[bottle.length-1]){
                    max_cnt++;
                }
                else if(bottle[i] != 0 && bottle[i] < bottle[bottle.length-1] ) {
                    remain_cnt++;
                }
            }

            System.out.println("cnt_max: "+max_cnt);
            System.out.println("cnt: "+remain_cnt);

            result = max_cnt*remain_cnt;
        }

        System.out.println(result);

    }

    static public void main(String args[]) {
        bottle(3,1);
        bottle(7,2);
        bottle(5,2);

    }
}
