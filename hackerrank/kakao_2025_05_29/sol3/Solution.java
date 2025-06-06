package com.example.hackerrank.kakao_2025_05_29.sol3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {


    public static List<Integer> getSubTeams(List<List<String>> edges, List<String> queries) {
        // 1) 트리 빌드
        Map<String, List<String>> tree = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for (List<String> e : edges) {
            tree.computeIfAbsent(e.get(0), k -> new ArrayList<>()).add(e.get(1));
            tree.putIfAbsent(e.get(1), new ArrayList<>());
            parent.put(e.get(1), e.get(0));
        }

        List<Integer> answer = new ArrayList<>();

        // 2) 쿼리 처리
        for (String q : queries) {
            String[] p = q.split(" ");
            switch (p[0]) {
                case "create_team":
                    tree.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[2]);
                    tree.putIfAbsent(p[2], new ArrayList<>());
                    parent.put(p[2], p[1]);
                    break;

                case "delete_team":
                    // 부모 링크 끊기
                    String par = parent.remove(p[1]);
                    if (par != null) tree.get(par).remove(p[1]);
                    // 재귀로 서브트리 제거
                    removeSubtree(tree, parent, p[1]);
                    break;

                case "count_teams":
                    answer.add(countSubTree(tree, p[1]));
                    break;
            }
        }
        return answer;
    }

    // 재귀로 서브트리 노드 전부 제거
    private static void removeSubtree(Map<String, List<String>> tree,
                                      Map<String, String> parent,
                                      String node) {
        for (String c : tree.getOrDefault(node, Collections.emptyList())) {
            removeSubtree(tree, parent, c);
        }
        tree.remove(node);
        parent.remove(node);
    }

    // 재귀로 서브트리 크기 계산
    private static int countSubTree(Map<String, List<String>> tree, String node) {
        int sum = 1;  // 자기 자신
        for (String c : tree.getOrDefault(node, Collections.emptyList())) {
            sum += countSubTree(tree, c);
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int existingTeamEdgesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int existingTeamEdgesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> existingTeamEdges = new ArrayList<>();

        IntStream.range(0, existingTeamEdgesRows).forEach(i -> {
            try {
                existingTeamEdges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        List<Integer> result = getSubTeams(existingTeamEdges, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")) + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}