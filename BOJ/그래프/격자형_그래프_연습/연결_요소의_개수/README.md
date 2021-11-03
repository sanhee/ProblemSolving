# [연결 요소의 개수](https://www.acmicpc.net/problem/11724)

## 첫 시도. 시간초과

```java
public class Main {
    private static int N; // 정점의 개수
    private static int M; // 간선의 개수
    private static List<Integer>[] graph;
    private static boolean[][] visited;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1][N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // 방향 없는 그래프
            graph[u].add(v);
            graph[v].add(u);
        }

    }

    private static void dfs(int node1, int node2) {
        visited[node1][node2] = true;
        visited[node2][node1] = true;

        for (int n : graph[node2]) {
            if (!visited[node2][n] || !visited[n][node2]) {
                dfs(node2, n);
            }
        }
    }

    private static void process() {
        int answer = 0;
        for (int i = 1; i < graph.length; i++) {
            for (int node : graph[i]) {
                if (!visited[i][node] || !visited[node][i]) {
                    answer++;
                    dfs(i, node);
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
```

## 개선

기존에 잘못한 점
1. 무방향인데, 양방향으로 visited 체크를 함
2. dfs 진입전에는 해당노드가 방문했는지만 체크하면 되는데, 그것뿐만 아니라 노드와 연결돼있는 
모든 노드리스트들을 불러오고, 또 그 노드들이 방문했는지 체크한 후에 dfs를 하게 됨.
   - dfs에서는 불러온 노드의 리스트를 또 불러오고...
    

```java
import java.util.*;

public class Main {
    private static int N; // 정점의 개수
    private static int M; // 간선의 개수
    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // 방향 없는 그래프
            graph[u].add(v);
            graph[v].add(u);
        }

    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    private static void process() {
        int answer = 0;

        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }

}

```
