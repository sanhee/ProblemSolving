package com.example.programmers.line_2025_08_02.sol4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static final int MODULUS = 998244353;
    private static final int PRIMITIVE_ROOT = 3;
    private static final char[] HANDS = {'R', 'S', 'P'};

    /*
     * 컨벌루션(Convolution) + NTT를 이용한 고속 다항식 곱셈 및 신호 처리
     *
     * ▶ 컨벌루션이란?
     *   한 수열(또는 함수)을 뒤집어 다른 수열과 겹치는 구간의
     *   대응 원소들을 곱한 뒤 그 합을 계산하여 새로운 수열을 만드는 연산입니다.
     *
     * ▶ 다항식 곱셈 예시
     *   A(x) = a·x^2 + b·x + c     → 계수 벡터 [a, b, c]
     *   B(x) = d·x + f             → 계수 벡터 [d, f]
     *
     * - 전통적인 전개 -
     *   A(x)B(x)
     *   = (a·x^2 + b·x + c)(d·x + f)
     *   = a·d·x^3
     *     + a·f·x^2 + b·d·x^2
     *     + b·f·x + c·d·x
     *     + c·f
     *   = a·d·x^3 + (a·f + b·d)·x^2 + (b·f + c·d)·x + c·f
     *
     * - 컨벌루션 관점 -
     *   [a, b, c] * reverse([d, f]) = [a, b, c] * [f, d]
     *
     *   C[0] = a·f
     *   C[1] = a·d + b·f
     *   C[2] = b·d + c·f
     *   C[3] = c·d
     *
     * ▶ 신호 필터링 예시
     *   신호 S = [1, 0, 1, 1, 1]
     *   커널 K = [1, 1, 0]
     *
     *   reverse(K) = [0, 1, 1]
     *
     *   C[k] = Σ_i S[i] * reverse(K)[k - i]
     *
     *   k=0: C[0] = S[0]*0                       = 0
     *   k=1: C[1] = S[0]*1 + S[1]*0             = 1
     *   k=2: C[2] = S[0]*1 + S[1]*1 + S[2]*0     = 1
     *   k=3: C[3] = S[1]*1 + S[2]*1 + S[3]*0     = 1
     *   k=4: C[4] = S[2]*1 + S[3]*1 + S[4]*0     = 2
     *   k=5: C[5] = S[3]*1 + S[4]*1              = 2
     *   k=6: C[6] = S[4]*1                       = 1
     *
     * ▶ 문제점
     *   벡터 길이가 N, M일 때 직접 계산은 O(N·M)으로, N, M이 크면 비효율적입니다.
     *
     * ▶ NTT(수론적 변환)를 이용한 고속 컨벌루션
     * 1) N := 다음 2의 거듭제곱 ≥ (N_S + N_K)
     * 2) S, K를 길이 N으로 0으로 패딩
     * 3) (컨벌루션 정의에 따라) S를 뒤집어 준비: S_rev[i] = S[N_S - 1 - i]
     * 4) A_ntt = Ntt.transform(S_rev, false)
     * 5) B_ntt = Ntt.transform(K,     false)
     * 6) for i in 0..N-1: C_ntt[i] = A_ntt[i] * B_ntt[i] % MODULUS
     * 7) C = Ntt.transform(C_ntt, true)
     * 8) 유효 구간 C[0..N_S-1] 사용   // 첫 번째 시퀀스 길이만큼 결과 활용
     *
     * 이렇게 하면 O(N log N)에 컨벌루션을 수행하고,
     * 그중 0..N_S-1 위치를 실제 시프트 결과로 해석할 수 있습니다.
     */
    static class Ntt {
        private static int size;            // 변환 길이 (2의 거듭제곱)
        private static int modulus;         // 소수 모듈로
        private static int primitiveRoot;   // 원시 루트
        private static int[] bitReverse;    // 비트 반전 인덱스
        private static long[] rootPowers;   // 정방향 트위들 팩터
        private static long[] invRootPowers;// 역방향 트위들 팩터

        /** NTT용 테이블 사전 계산 */
        static void init(int n, int mod, int root) {
            size = n;
            modulus = mod;
            primitiveRoot = root;
            bitReverse = new int[size];
            for (int i = 1, j = 0; i < size; i++) {
                int half = size >> 1;
                while ((j & half) != 0) {
                    j ^= half;
                    half >>= 1;
                }
                j |= half;
                bitReverse[i] = j;
            }
            rootPowers = new long[size + 1];
            invRootPowers = new long[size + 1];
            for (int len = 2; len <= size; len <<= 1) {
                long unity = modPow(primitiveRoot, (modulus - 1L) / len, modulus);
                rootPowers[len] = unity;
                invRootPowers[len] = modPow(unity, modulus - 2, modulus);
            }
        }

        /** in-place 정/역방향 NTT 수행 */
        static void transform(long[] a, boolean invert) {
            // 비트 반전 재배열
            for (int i = 0; i < size; i++) {
                int j = bitReverse[i];
                if (i < j) {
                    long tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            // Cooley–Tukey 버터플라이
            for (int len = 2; len <= size; len <<= 1) {
                int half = len >> 1;
                long unity = invert ? invRootPowers[len] : rootPowers[len];
                for (int base = 0; base < size; base += len) {
                    long w = 1;
                    for (int offset = 0; offset < half; offset++) {
                        long u = a[base + offset];
                        long v = a[base + offset + half] * w % modulus;
                        long sum = u + v;
                        a[base + offset] = sum < modulus ? sum : sum - modulus;
                        long diff = u - v;
                        a[base + offset + half] = diff >= 0 ? diff : diff + modulus;
                        w = w * unity % modulus;
                    }
                }
            }
            // 역변환 후 정규화
            if (invert) {
                long invSize = modPow(size, modulus - 2, modulus);
                for (int i = 0; i < size; i++) {
                    a[i] = a[i] * invSize % modulus;
                }
            }
        }
    }

    /** 빠른 거듭제곱: base^exp % m */
    private static long modPow(long base, long exp, int m) {
        long result = 1;
        base %= m;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % m;
            base = base * base % m;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        char[] machineMoves = reader.readLine().trim().toCharArray();
        char[] playerMoves  = reader.readLine().trim().toCharArray();

        int machineLen = machineMoves.length;
        int playerLen  = playerMoves.length;
        int fftSize = 1;
        while (fftSize < Math.max(machineLen, playerLen) * 2) fftSize <<= 1;

        Ntt.init(fftSize, MODULUS, PRIMITIVE_ROOT);

        long[] winCounts = new long[fftSize];
        long[] polyA     = new long[fftSize];
        long[] polyB     = new long[fftSize];

        for (int shapeIdx = 0; shapeIdx < HANDS.length; shapeIdx++) {
            Arrays.fill(polyA, 0);
            Arrays.fill(polyB, 0);

            // 아래에 구현하세요.
        }
    }
}
