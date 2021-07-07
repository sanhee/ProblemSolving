package com.example.BOJ.여행가자_1976_서로소집합;


/*
한국 도시 N개
임의의 두 도시 사이에 길이 있을 수 있고, 없을 수 있다.

여행 일정이 가능한 것인지

중간에 다른도시를 경유해서 여행할 수 ㅣㅇㅆ다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// K 코드 따라치기
public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] graph;
    public static int[] disjoinSet; // 서로소 집합

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수

        if (M == 0) {
            System.out.println("YES"); // 이해가 안감
            System.exit(0);
        }

        graph = new int[N + 1][N + 1];
        disjoinSet = new int[N + 1];

        // 서로소 집합 자기 자신으로 초기화
        for (int i = 0; i < disjoinSet.length; i++) {
            disjoinSet[i] = i;
        }
        initGraph();

        // 여행계획
        int[] itinerary = new int[M];
        initItinerary(itinerary);
        initDisjointSet();


        int currentSet = disjoinSet[itinerary[0]];

        for (int city : itinerary) {
            if (findParent(city) != currentSet) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");

    }

    private static void initDisjointSet() {
        int N = disjoinSet.length - 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    unionParent(i, j);
                }
            }
        }

    }

    private static void initItinerary(int[] itinerary) throws IOException {
        int M = itinerary.length;
        StringTokenizer cities = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            itinerary[i] = Integer.parseInt(cities.nextToken());
        }
    }

    public static void initGraph() throws IOException {
        int N = graph.length - 1;
        for (int i = 1; i <= N; i++) {
            StringTokenizer edges = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(edges.nextToken());
                if (graph[i][j] == 1) {
                    unionParent(i, j);
                }
            }

        }

    }

    private static void unionParent(int i, int j) {
        int a = findParent(i);
        int b = findParent(j);

        if (a < b) {
            disjoinSet[j] = a;
        } else if (a > b) {
            disjoinSet[i] = b;
        }

    }

    private static int findParent(int node) {
        int parent = disjoinSet[node];
        if (node == parent) {
            return node;
        }
        return disjoinSet[node] = findParent(parent);
    }


}
