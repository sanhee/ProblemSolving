
# [바이러스](https://www.acmicpc.net/problem/2606)

# 내 풀이

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int countOfComputer;
    static int countOfEdge;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int total;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        countOfComputer = scanner.nextInt();
        countOfEdge = scanner.nextInt();

        visited = new boolean[countOfComputer + 1];
        graph = new ArrayList[countOfComputer + 1];

        for (int i = 1; i <= countOfComputer; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < countOfEdge; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }
    }

    private static void dfs(int computerNumber) {
        visited[computerNumber] = true;

        for(int num : graph[computerNumber]){
            if(visited[num]){
                continue;
            }
            total++;
            dfs(num);
        }
    }

    private static void process() {
        dfs(1);
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(total);
    }
}

```


## 류호석님 풀이

```java
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1;i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        // start는 방문 가능한 점이므로 que에 넣어준다.
        que.add(start);
        visit[start] = true;  // start를 갈 수 있다고 표시하기 (중요!!!)

        while (!que.isEmpty()) {  // 더 확인할 점이 없다면 정지
            int x = que.poll();

            for (int y: adj[x]){
                if (visit[y]) continue;  // x 에서 y 를 갈 수는 있지만, 이미 탐색한 점이면 무시

                // y를 갈 수 있으니까 que에 추가하고, visit 처리 하기!
                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        bfs(1);
        int ans = 0;
        for (int i = 2; i <= N; i++)
            if (visit[i])
                ans ++;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
```
