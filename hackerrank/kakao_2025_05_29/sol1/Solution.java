package com.example.hackerrank.kakao_2025_05_29.sol1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {


    /**
     * 암호문(encrypted)을 원반을 반시계 방향으로 k칸 회전해 해독한다.
     *
     * @param encrypted 암호문 (대문자 A-Z)
     * @param k         반시계 방향 이동 칸 수
     * @return 해독된 평문
     */
    public static String getDecryptedString(String encrypted, int k) {
        // 1. 유효 이동 칸수(0~25)로 축소
        final int shift = k % 26;

        final StringBuilder answer = new StringBuilder(encrypted.length());

        // 2. 각 문자 해독
        for (int i = 0; i < encrypted.length(); i++) {
            char alphabet = encrypted.charAt(i);

            // 'A' 기준 0~25 위치 계산
            int alphabetPos = alphabet - 'A';
            int newPos  = (alphabetPos - shift + 26) % 26;  // 음수 보정
            char newAlphabet  = (char) ('A' + newPos);

            answer.append(newAlphabet);
        }
        return answer.toString();  // 3. 평문 반환
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String encrypted = br.readLine().trim();    // 예: CDEF
        int k            = Integer.parseInt(br.readLine().trim()); // 예: 2
        System.out.println(getDecryptedString(encrypted, k)); // -> ABCD
    }
}