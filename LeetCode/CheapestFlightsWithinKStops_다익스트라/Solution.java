package com.example.LeetCode.CheapestFlightsWithinKStops_다익스트라;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // 길이 없을 경우
        if (flights.length == 0) {
            return -1;
        }


        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        // 그래프 build
        for (int[] flight : flights) {

            // 그래프에 노드가 존재하지 않는 경우, 그래프 초기화

            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<int[]>());
            }

            // 해당 노드에서 다른 노드로 가는 비용에 대한 정보 그래프 삽입
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }


        // 인접 노드로 갈 때 최소비용인 곳으로 가야하므로, 정렬이 가능한 PriorityQueue 사용
        // 비용 기준 오름차순 정렬
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> (a.cost - b.cost));

        // 인접노드???
        q.add(new Node(src, 0, -1));


        while (!q.isEmpty()) {

            Node current = q.poll();

            if (current.city == dst) {
                return current.cost;
            }

            // 경유할 수 있는 횟수가 남았다면, 다른 인접 노드 탐색
            if (current.stop < K) {
                List<int[]> nexts = graph.getOrDefault(current.city, new ArrayList<int[]>());

                for (int[] next : nexts) {
                    q.add(new Node(next[0], current.cost + next[1], current.stop + 1));
                }
            }

        }
        return -1;
    }

}


class Node {
    int city;
    int cost;
    int stop;

    public Node(int city, int cost, int stop) {
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}


