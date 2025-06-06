package com.example.hackerrank.kakao_2025_05_29.sol2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * “비밀 메시지 체인” 풀이 (라인-by-라인 주석 버전)
 *
 * 1) 단어를 길이 오름차순으로 정렬
 * 2) 각 단어에서 글자 하나를 삭제해 생성되는 모든 ‘이전 단어’가
 *    이미 사전에 있으면 체인을 이어붙일 수 있다고 판단
 * 3) dpMap 에 단어별 최장 체인 길이를 저장하면서 전체 최댓값을 구한다
 */

public class Solution {

    /* ============================== 핵심 DP 로직 ============================== */
    private static int longestChain(List<String> words) {
        /* ❶ 중복 제거(deduplication) 후 길이 오름차순 정렬 ------------- */
        List<String> sortedWords = words.stream()          // 스트림 생성
                .distinct()                                // 동일 단어 한 번만 남김
                .sorted(Comparator.comparingInt(String::length)) // 길이 기준 오름차순
                .toList();             // 리스트로 변환

        /* ❷ 빠른 포함 여부 체크용 HashSet ------------------------------------ */
        Set<String> wordSet = new HashSet<>(sortedWords);   // O(1) contains()

        /* ❸ DP(단어 → 최장 체인 길이) 저장용 HashMap ------------------------ */
        Map<String, Integer> map = new HashMap<>();

        int maxChainLength = 1;                               // 최소 길이 = 1

        /* ❹ 길이 짧은 것부터 순차 처리 -------------------------------------- */
        for (String word : sortedWords) {

            int best = 1;                                  // word 자체만 쓴 경우

            /* ❺ 글자 하나씩 제거해 ‘이전 단어’ 후보 생성 ------------------- */
            for (int i = 0; i < word.length(); i++) {
                // i 번째 글자를 제거해 prev 생성
                String prev = word.substring(0, i) + word.substring(i + 1);

                // prev 가 사전에 존재 → 체인 연결 가능
                if (wordSet.contains(prev)) {
                    // prev 로 끝나는 체인 길이 + 1
                    int candidate = map.getOrDefault(prev, 1) + 1;
                    best = Math.max(best, candidate);      // 최대값 갱신
                }
            }

            /* ❻ 현재 단어의 최장 체인 길이를 dpMap에 기록 ------------------ */
            map.put(word, best);

            /* ❼ 전체 최댓값 갱신 ------------------------------------------ */
            maxChainLength = Math.max(maxChainLength, best);
        }
        return maxChainLength;                                // 정답 반환
    }

    /* ============================== 입출력 메인 ============================== */
    public static void main(String[] args) throws IOException {

        /* ① 입력 스트림 준비 (BufferedReader) ------------------------------ */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* ② 출력 스트림 준비 (BufferedWriter) ------------------------------ */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* ③ 단어 개수 n 읽기 ------------------------------------------------ */
        int n = Integer.parseInt(br.readLine().trim());

        List<String> words = new ArrayList<>(n);           // 입력 단어 저장
        for (int i = 0; i < n; i++) {
            words.add(br.readLine().trim());               // 한 줄씩 단어 추가
        }

        /* ④ 핵심 로직 호출 -------------------------------------------------- */
        int result = longestChain(words);

        /* ⑤ 결과 출력 ------------------------------------------------------- */
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();                                        // 스트림 비우기
    }
}
