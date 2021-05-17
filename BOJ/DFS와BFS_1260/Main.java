package com.example.BOJ.DFS와BFS_1260;

import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int V;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 정점 개수
        M = scanner.nextInt(); // 간선 개수
        V = scanner.nextInt(); // 시작할 정점의 번호

        Map<Integer, Set<Integer>> graph = new HashMap<>(); // graph 1->2  1->3  1->4 1->%
        initGraph(graph, scanner);

        boolean[] visited = new boolean[N + 1];
        dfs(graph, V, visited);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(graph, V, visited);

    }

    private static void initGraph(Map<Integer, Set<Integer>> graph, Scanner scanner) {
        for(int i=0; i<M; i++){
            int v1 = scanner.nextInt(); //정점 A
            int v2 = scanner.nextInt(); // 정점 B

            Set<Integer> v1Edges = graph.getOrDefault(v1, new TreeSet<>()); // 왜 Treeset일까..?
            v1Edges.add(v2);
            graph.put(v1, v1Edges);

            Set<Integer> v2Edges = graph.getOrDefault(v2, new HashSet<>());
            v2Edges.add(v1);
            graph.put(v2, v2Edges);
        }
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, Integer vertex, boolean[] visited){
        if(visited[vertex]){ // 방문한 정점인 경우
            return;
        }

        System.out.print(vertex + " "); // 방문한 정점을 출력한다.
        visited[vertex] = true;

        for (Integer v : graph.getOrDefault(vertex, new TreeSet<>())){   // 정점과 인접한 정점을 탐색한다.
            dfs(graph,v,visited);
        }
    }

    private static void bfs(Map<Integer, Set<Integer>> graph, Integer vertex, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited[vertex] = true;

        while(!queue.isEmpty()){
            Integer v0 = queue.poll();
            System.out.print(v0 + " ");

            for(Integer v : graph.getOrDefault(v0, new TreeSet<>())){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                }
            }

        }


    }


}
