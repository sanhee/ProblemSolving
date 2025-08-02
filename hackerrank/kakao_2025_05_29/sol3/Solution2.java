package com.example.hackerrank.kakao_2025_05_29.sol3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution2 {

    /* --------------------------- 핵심 로직 --------------------------- */

    public static List<Integer> getSubTeams(List<List<String>> edges,
                                            List<String> queries) {

        Map<String, List<String>> tree = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        /* 1) 트리 빌드 */
        for (List<String> e : edges) {
            tree.computeIfAbsent(e.get(0), k -> new ArrayList<>()).add(e.get(1));
            tree.putIfAbsent(e.get(1), new ArrayList<>());
            parent.put(e.get(1), e.get(0));
        }

        List<Integer> answer = new ArrayList<>();

        /* 2) 쿼리 처리 */
        for (String q : queries) {
            String[] p = q.split(" ");
            switch (p[0]) {

                case "create_team":
                    tree.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[2]);
                    tree.putIfAbsent(p[2], new ArrayList<>());
                    parent.put(p[2], p[1]);
                    break;

                case "delete_team":
                    // 부모-자식 끊기 (O(1))
                    String par = parent.remove(p[1]);
                    if (par != null) tree.get(par).remove(p[1]);

                    // ★ BFS로 서브트리 제거
                    removeSubtreeBFS(tree, parent, p[1]);
                    break;

                case "count_teams":
                    // ★ BFS로 서브트리 개수 계산
                    answer.add(countSubTreeBFS(tree, p[1]));
                    break;
            }
        }
        return answer;
    }

    /* ----------------------- 반복 BFS 구현부 ----------------------- */

    // ① 서브트리 전체 삭제(BFS)
    private static void removeSubtreeBFS(Map<String, List<String>> tree,
                                         Map<String, String> parent,
                                         String root) {

        Deque<String> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            String cur = q.poll();
            // 다음 레벨 자식 enqueue
            for (String child : tree.getOrDefault(cur, Collections.emptyList())) {
                q.add(child);
            }
            // 현재 노드 삭제
            tree.remove(cur);
            parent.remove(cur);
        }
    }

    // ② 서브트리 노드 수 계산(BFS)
    private static int countSubTreeBFS(Map<String, List<String>> tree, String root) {
        if (!tree.containsKey(root)) return 0;

        Deque<String> q = new ArrayDeque<>();
        q.add(root);

        int cnt = 0;
        while (!q.isEmpty()) {
            String cur = q.poll();
            cnt++;

            for (String child : tree.getOrDefault(cur, Collections.emptyList())) {
                q.add(child);
            }
        }
        return cnt;
    }

    /* -------------------------- I/O 래퍼 -------------------------- */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int edgeRows = Integer.parseInt(br.readLine().trim());
        int edgeCols = Integer.parseInt(br.readLine().trim()); // 사용 안 함

        List<List<String>> edges = new ArrayList<>();
        IntStream.range(0, edgeRows).forEach(i -> {
            try {
                edges.add(Arrays.asList(br.readLine().trim().split(" ")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        int qCnt = Integer.parseInt(br.readLine().trim());
        List<String> queries = IntStream.range(0, qCnt).mapToObj(i -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        List<Integer> res = getSubTeams(edges, queries);
        bw.write(res.stream().map(Object::toString).collect(Collectors.joining("\n")));
        bw.newLine();
        bw.flush();
    }
}
