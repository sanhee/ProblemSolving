package com.example.LeetCode.NetworkDelay;

import java.util.*;

public class Solution {

    class Edge implements Comparable<Edge> {
        private final int time;
        private final int node;

        public Edge(int time, int node) {
            this.time = time;
            this.node = node;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time; // 오름차순
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new Edge(w, v));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        // 소요시간, 출발노드
        queue.add(new Edge(0, k));
        Map<Integer, Integer> dist = new HashMap<>();

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int time = e.time;
            int node = e.node;
            if (!dist.containsKey(node)) {
                dist.put(node, time);
                if (!graph.containsKey(node)) {
                    continue;
                }
                for (Edge edge : graph.get(node)) {
                    int alt = time + edge.time;
                    queue.add(new Edge(alt, edge.node));
                }
            }
        }
        if (dist.size() == n) {
            return dist.values().stream().mapToInt(d -> d).max().orElse(-1);
        }
        return -1;
    }

}
