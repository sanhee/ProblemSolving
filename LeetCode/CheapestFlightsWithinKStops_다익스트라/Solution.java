package com.example.LeetCode.CheapestFlightsWithinKStops_다익스트라;

import java.util.*;

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


        Map<Integer, Integer> weight = new HashMap<>();


        // 인접 노드로 갈 때 최소비용인 곳으로 가야하므로, 정렬이 가능한 PriorityQueue 사용
        // 비용 기준 오름차순 정렬
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> (a.cost - b.cost));

        // [목적지, 비용, 경유횟수] 초깃값 정하기, 자기자신은 0비용이고, 경유를 -1부터 시작해야 한번이라도 움직일 수 있음.
        q.add(new Node(src, 0, -1));


        while (!q.isEmpty()) {

            Node current = q.poll();

            // 큐에서 꺼낸 현재 도시가 목적지와 같다면, 현재 비용을 리턴하고 끝낸다.
            if (current.city == dst) {
                return current.cost;
            }

            // 경유할 수 있는 횟수가 남았다면, 현재 노드의 인접 노드 그래프 탐색 (BFS)
            if (current.stop < K) {
                // 키 값으로 그래프에서 나온 value 이므로, 인근 노드의 {목적지 노드, 비용} 리스트가 나올거임.
                List<int[]> nexts = graph.getOrDefault(current.city, new ArrayList<int[]>());


                for (int[] next : nexts) {

                    int to = next[0];
                    int alt = current.cost + next[1];

                    if (weight.getOrDefault(to, 99999) > alt) {
                        weight.put(to, alt);
                        q.add(new Node(to, alt, current.stop + 1));
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 2;
        int k = 0;

        if (new Solution().findCheapestPrice(n, flights, src, dst, k) == 500) {
            System.out.println("CASE1. 성공");
        } else {
            System.out.println("CASE1. 실패");
        }

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


