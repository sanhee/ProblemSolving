package com.example.codility.krafton.sol4;

import java.util.*;

public class Solution {

    public int solution(int[] T, int[] A) {
        boolean[] visited = new boolean[T.length];
        ArrayList<Integer>[] adj = new ArrayList[T.length];


        for (int i = 0; i < T.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < T.length; i++) {
            adj[T[i]].add(i);
        }

        Set<Integer> neededSkills = new HashSet<>();
        for (int skill : A) {
            findNeededSkills(skill, T, neededSkills);
        }

        return bfs(neededSkills, adj, visited);
    }

    private void findNeededSkills(int skill, int[] T, Set<Integer> neededSkills) {
        while (!neededSkills.contains(skill)) {
            neededSkills.add(skill);
            skill = T[skill];
        }
    }

    public static int bfs(Set<Integer> neededSkills, ArrayList<Integer>[] adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        int skillCount = 0;

        while (!queue.isEmpty()) {
            int currentSkill = queue.poll();
            if (neededSkills.contains(currentSkill)) {
                skillCount++;
            }

            for (int neighbor : adj[currentSkill]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return skillCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] T0 = {0,0,1,1};
        int[] A0 = {2};
        System.out.println(testCase("Test Case 0", sol.solution(T0, A0), 3));  // Expected: 3


        // 테스트 케이스 1: 루트 스킬만 필요한 경우
        int[] T1 = {0};
        int[] A1 = {0};
        System.out.println(testCase("Test Case 1", sol.solution(T1, A1), 1));  // Expected: 1

        // 테스트 케이스 2: 루트와 바로 연결된 하나의 스킬
        int[] T2 = {0, 0};
        int[] A2 = {1};
        System.out.println(testCase("Test Case 2", sol.solution(T2, A2), 2));  // Expected: 2

        // 테스트 케이스 3: 스킬 트리가 직선으로 이어지는 경우
        int[] T3 = {0, 0, 1, 2, 3};
        int[] A3 = {4};
        System.out.println(testCase("Test Case 3", sol.solution(T3, A3), 5));  // Expected: 5

        // 테스트 케이스 4: 중간 스킬들을 생략하고 최종 스킬만 배우려는 경우
        int[] T4 = {0, 0, 1, 1, 3};
        int[] A4 = {4};
        System.out.println(testCase("Test Case 4", sol.solution(T4, A4), 4));  // Expected: 4

        // 테스트 케이스 5: 여러 독립된 스킬들이 존재하는 경우
        int[] T5 = {0, 0, 0, 1, 2, 3};
        int[] A5 = {1, 2, 5};
        System.out.println(testCase("Test Case 5", sol.solution(T5, A5), 5));  // Expected: 5

        // 테스트 케이스 6: A 배열에 여러 스킬이 주어졌을 때, 모든 스킬이 최종적으로 배워지는지 검증
        int[] T6 = {0, 0, 1, 1, 2, 3};
        int[] A6 = {5, 4};
        System.out.println(testCase("Test Case 6", sol.solution(T6, A6), 6));  // Expected: 6

        // 테스트 케이스 7: 루트만 배우고 더 이상 스킬이 없는 경우
        int[] T7 = {0};
        int[] A7 = {0};
        System.out.println(testCase("Test Case 7", sol.solution(T7, A7), 1));  // Expected: 1        // 테스트 케이스 7: 루트만 배우고 더 이상 스킬이 없는 경우

        int[] T8 = {0, 0,1,2};
        int[] A8 = {1, 2};
        System.out.println(testCase("Test Case 8", sol.solution(T8, A8), 3));  // Expected: 3

        int[] T9 = {0, 3, 0, 0, 5, 0, 5};
        int[] A9 = {4, 2, 6, 1, 0};
        System.out.println(testCase("Test Case 9", sol.solution(T9, A9), 7));  // Expected: 7



        // 테스트 케이스 10: 루트 스킬만 필요한 경우 (N=1, M=1)
        int[] T10 = {0};
        int[] A10 = {0};
        System.out.println(testCase("Test Case 10", sol.solution(T10, A10), 1));  // Expected: 1

        // 테스트 케이스 11: 루트와 바로 연결된 하나의 스킬 (N=2, M=1)
        int[] T11 = {0, 0};
        int[] A11 = {1};
        System.out.println(testCase("Test Case 11", sol.solution(T11, A11), 2));  // Expected: 2

        // 테스트 케이스 12: 스킬 트리가 직선으로 이어지는 경우 (N=5, M=1)
        int[] T12 = {0, 0, 1, 2, 3};
        int[] A12 = {4};
        System.out.println(testCase("Test Case 12", sol.solution(T12, A12), 5));  // Expected: 5

        // 테스트 케이스 13: 중간 스킬들을 생략하고 최종 스킬만 배우려는 경우 (N=5, M=1)
        int[] T13 = {0, 0, 1, 1, 3};
        int[] A13 = {4};
        System.out.println(testCase("Test Case 13", sol.solution(T13, A13), 4));  // Expected: 4

        // 테스트 케이스 14: 여러 독립된 스킬들이 존재하는 경우 (N=6, M=3)
        int[] T14 = {0, 0, 0, 1, 2, 3};
        int[] A14 = {1, 2, 5};
        System.out.println(testCase("Test Case 14", sol.solution(T14, A14), 5));  // Expected: 5

        // 테스트 케이스 15: A 배열에 여러 스킬이 주어졌을 때, 모든 스킬이 최종적으로 배워지는지 검증 (N=6, M=2)
        int[] T15 = {0, 0, 1, 1, 2, 3};
        int[] A15 = {5, 4};
        System.out.println(testCase("Test Case 15", sol.solution(T15, A15), 6));  // Expected: 6

        // 테스트 케이스 16: 루트만 배우고 더 이상 스킬이 없는 경우 (N=1, M=1)
        int[] T16 = {0};
        int[] A16 = {0};
        System.out.println(testCase("Test Case 16", sol.solution(T16, A16), 1));  // Expected: 1

        // 테스트 케이스 17: 최대 크기 N과 M을 테스트 (N=100,000, M=1)
        int[] T17 = new int[100000];
        for (int i = 1; i < 100000; i++) {
            T17[i] = i - 1;  // 트리를 일렬로 만듦
        }
        int[] A17 = {99999};  // 마지막 스킬만 배움
        System.out.println(testCase("Test Case 17", sol.solution(T17, A17), 100000));  // Expected: 100000

    }

    // 테스트 결과를 출력하는 함수
    public static String testCase(String testCaseName, int actual, int expected) {
        String result = (actual == expected) ? "Passed" : "Failed";
        return String.format("%s: Expected = %d, Actual = %d -> %s", testCaseName, expected, actual, result);
    }
}