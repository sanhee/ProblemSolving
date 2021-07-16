package com.example.programmers.레벨1.최대공약수와최소공배수;

public class Solution {

    // 최대공약수란? 두 수의 공약수중 가장 큰 약수를 뜻함
    // 유클리드 호제법
    // 두 수가 서로 상대방 수를 나누어서 결국 원하는 수를 얻는 알고리즘
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = (n*m)/answer[0]; // LCM * GCD = n*m  -> LCM = (n*m)/GCD
        return answer;
    }

}
