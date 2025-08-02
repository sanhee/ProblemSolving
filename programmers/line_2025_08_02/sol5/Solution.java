package com.example.programmers.line_2025_08_02.sol5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    /*
    펜윅 트리 (Binary Indexed Tree)

    기능:
    1) 점 업데이트: O(log n) 안에 단일 인덱스에 값을 더함
    2) 구간 합 질의: O(log n) 안에 배열[0..idx] 합을 구함

    사용 예:
    - 단일 요소를 자주 갱신하고, 누적 합이나 개수를 빠르게 조회해야 하는
      동적 배열에 적합합니다.
    */
    static class Fenwick {
        int n;          // 원본 배열의 크기
        int[] bit;      // 길이 n+1, 1 기반 인덱싱 트리 배열

        // 길이 n 배열을 위한 펜윅 트리를 구성합니다.
        public Fenwick(int n) {
            this.n = n;
            this.bit = new int[n + 1];
        }

        // update(idx, val): 0 기반 idx 위치에 val을 더합니다.
        public void update(int idx, int val) {
            for (int i = idx + 1; i <= n; i += i & -i) {
                bit[i] += val;
            }
        }

        // sum(idx): 배열[0..idx] 구간 합을 반환합니다.
        // 예시:
        //     fw.update(2, 3) 호출 후, 개념상 배열은 [0,0,3,0,0]
        //     int x = fw.sum(2); // x == 3
        public int sum(int idx) {
            int s = 0;
            for (int i = idx + 1; i > 0; i -= i & -i) {
                s += bit[i];
            }
            return s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        // 여기에 구현하세요
    }
}
