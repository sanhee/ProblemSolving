package com.example.LeetCode.NetworkDelay;

import java.util.*;

public class Solution {

    class Element implements Comparable {
        Integer weight;  // w
        Integer destination; // v

        public Element(int weight, int destination) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Element element = (Element) o;
            return this.weight.compareTo(element.weight);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // u, v, w

        // u, graph.get(u) = v, graph.get(u).get(v) = w를 넣기 위한 그래프
        List<List<Integer>> graph = new ArrayList<>();

        for (int u = 0; u < times.length; u++) {
            List<Integer> weights = new ArrayList<>();

            for (int v = 0; v < times[0].length; v++) {
                int w = times[u][v];
                weights.add(w);
            }
            graph.add(weights);
        }

        PriorityQueue<Element> queue = new PriorityQueue<>();

        queue.add(new Element(0,k));

        Map<Integer, Integer> distance = new HashMap<>();

        while (!queue.isEmpty()) {
            Element element = queue.poll();

            int node = element.destination; // 목적지
            int time = element.weight;

            if (!distance.containsKey(node)) {
                distance.put(node, time);

                for (int v = 0; v < graph.size(); v++) {
                    for (int nextV = 0; nextV < graph.get(v).size(); nextV++) {
                        int tempWeight = time + graph.get(v).get(nextV);
                        queue.add(new Element(tempWeight, nextV));
                    }
                }
            }

        }

        if (distance.size() == n) {

            int max = 0;
            for (Integer num : distance.values()) {
                max = Math.max(max, num);
            }
            return max;
        } else {
            return -1;
        }
    }
}
