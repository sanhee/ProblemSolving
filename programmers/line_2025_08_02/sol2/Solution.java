package com.example.programmers.line_2025_08_02.sol2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine().trim();
        char[] s = w.toCharArray();

        // k = 0,1,2,3 순서로 가능한지 확인
        for (int k = 0; k <= 3; k++) {
            if (canMakePalindromeWithinK(s, k)) {
                System.out.println(k);
                return;
            }
        }
        System.out.println(-1); // 3회 이내 모두 실패
    }

    /**
     * s를 k회 이하 삭제로 회문으로 만들 수 있는지 여부.
     * 분기 수가 작으므로(최대 2^k) 큐(BFS)로 상태를 확장한다.
     */
    private static boolean canMakePalindromeWithinK(char[] s, int k) {
        int n = s.length;

        // 상태: [left, right, usedDel]
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, n - 1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int left = cur[0];
            int right = cur[1];
            int usedDel = cur[2];

            // 1) 같을 동안(불일치가 나올 때까지) 한 번에 당겨서 불필요한 분기 방지
            while (left < right && s[left] == s[right]) {
                left++;
                right--;
            }

            // 2) 회문이 되었으면 성공
            if (left >= right) return true;

            // 3) 불일치 지점에서 삭제 분기 (왼쪽 삭제 or 오른쪽 삭제)
            if (usedDel < k) {
                // 왼쪽 글자를 삭제
                q.addLast(new int[]{left + 1, right, usedDel + 1});
                // 오른쪽 글자를 삭제
                q.addLast(new int[]{left, right - 1, usedDel + 1});
            }
            // usedDel == k 인 상태에서 불일치면 더 이상 진행 불가 → 다음 상태로
        }
        return false;
    }
}
