
# [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)

## 풀이
- 먼저 그래프를 받고나서,
- 부모를 제외한 dfs를 시켜주면 쉽게 구할 수 있는 문제

```java
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parents;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 그래프 간선 맺기 N-1개
        for (int i = 1; i < N; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            tree[vertex1].add(vertex2);
            tree[vertex2].add(vertex1);
        }

        parents = new int[N+1];

        scanner.close();
    }

    private static void dfs(int vertex, int parent) {

        for(int v : tree[vertex]){
            // 인접리스트 요소가 부모와 같다면 스킵
            if(v == parent){
                continue;
            }
            // 정상적인 자식을 뽑아냈다면-부모관계 맺어줌
            parents[v] = vertex;
            dfs(v, vertex);
        }
    }

    private static void process() {
        for(int i=2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(1, -1);
        process();
    }
}

```
