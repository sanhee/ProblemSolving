package com.example.LeetCode.CheapestFlightsWithinKStops_다익스트라;

import java.util.*;

public class Solution {

    private final static int INF = 99999; // 비용 무한을 표시

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


        // 인접 노드를 모두 탐색(BFS)해야하므로, Queue 자료구조를 이용한다.
        // 만약 priority queue를 통해 정렬을 하면, 정상적인 BFS 탐색을 할 수 없음.
        Queue<Node> queue = new LinkedList<>();

        // 최종 비용을 담을 변수
        int result = INF;

        // [목적지, 비용, 경유횟수] 초깃값 정하기, 자기자신은 0비용이고, 경유를 -1부터 시작해야 한번이라도 움직일 수 있음.
        queue.add(new Node(src, 0, -1));


        while (!queue.isEmpty()) {

            Node current = queue.poll();

            // 큐에서 꺼낸 현재 도시가 목적지와 같다면, 최종비용을 업데이트 한다.
            // 경유지 내 최소비용으로 가야하므로, min을 사용
            if (current.city == dst) {
                result = Math.min(result, current.cost);
            }

            // 경유할 수 있는 횟수가 남았다면, 현재 노드의 인접 노드 그래프 탐색 (BFS)
            if (current.stop < K) {
                // 키 값으로 그래프에서 나온 value 이므로, 인근 노드의 {목적지 노드, 비용} 리스트가 나올거임.
                List<int[]> nexts = graph.getOrDefault(current.city, new ArrayList<int[]>());


                for (int[] next : nexts) {

                    int to = next[0];
                    int alt = current.cost + next[1];

                    // 불필요한 BFS를 막기위한 조건
                    // 같은 목적지를 가면서 굳이 더 비싼 경로를 탐색할 필요가 없기 때문임.
                    if (weight.getOrDefault(to, INF) > alt) {
                        weight.put(to, alt);
                        queue.add(new Node(to, alt, current.stop + 1));
                    }
                }
            }

        }
        return result < INF ? result : -1;
    }
}

class Node {
    int city;
    int cost; // 비용
    int stop; // 경유 횟수

    public Node(int city, int cost, int stop) {
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}


