package com.example.programmers.line_2025_08_02.sol2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
   제출 코드
 */


public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine().trim();
        char[] s = w.toCharArray();

        for (int k = 0; k <= 3; k++) {
            if (canMakePalindromeWithinK(s, k)) {
                System.out.println(k);
                return;
            }
        }
        System.out.println(-1);
    }

    // --- 여기부터 DFS 버전 ---
    private static boolean canMakePalindromeWithinK(char[] s, int k) {
        return dfs(s, 0, s.length - 1, k);
    }

    /** dfs(left, right, remain): s[left..right]를 remain회 이하 삭제로 회문 가능? */
    private static boolean dfs(char[] s, int left, int right, int remain) {
        // 일치하는 동안 포인터를 안쪽으로 당김(불필요한 분기 제거)
        while (left < right && s[left] == s[right]) {
            left++;
            right--;
        }
        if (left >= right) return true;  // 이미 회문
        if (remain == 0) return false;   // 더 못 지우는데 불일치

        // 불일치 지점: 왼쪽 삭제 OR 오른쪽 삭제로 분기
        return dfs(s, left + 1, right, remain - 1)
                || dfs(s, left, right - 1, remain - 1);
    }
}
