
# [케빈 베이컨의 6단계 법칙](https://www.acmicpc.net/problem/1389)

## 설명

- 케빈 베이컨 게임: 
  - 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임

```java
ex) 
        
천민호 - 이강호
천민호 - 최백준
최백준 - 김선영
김선영 - 김도현
김도현 - 민세희

- 이강호 - 민세희 몇 단계?
        
- 이강호-천민호-최백준-김선영-김도현-민세희 와 같이 5단계만 거치면 된다.
```

- 양방향 그래프만들고, 조회하는 식으로 하면 될 듯

## 목적
- 케빈 베이컨의 수 총합이 가장 작은 사람을 찾는 것


## 풀이

### 실수했던 점
1. 각각의 원소의 케빈 베이컨의 수를 어떻게 구할지 감이 안와, 해답을 봤다.
 - 자기 자신 인덱스를 제외하고 순회해야하나? 이런 생각들이 머리를 지배했었는데,
 - 애초에 모든 사람들과 연결이 돼있다는 조건이 있었기 때문에, bfs로 끝까지 순회하면서 거리를  구하면 되는 것이었다.
 - 다만 distance를 1차원으로 쓸거라면 사람마다 각각 사용해야 하므로 초기화를 제대로 해줘야 함.

2. 최소거리 계산할 때, 자꾸 bfs 메서드 파라미터를 사용하는 실수를 한다.
  - 큐에서 꺼낸 vertex 기준으로 거리 계산을 해야하는데.. 찾기도 힘들고 기억해두자.
  -  `distance[v] = distance[vertex] + 1;`

```java
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] distance;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int vertex = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            graph[vertex].add(vertex2);
            graph[vertex2].add(vertex);
        }

        distance = new int[N + 1];

        scanner.close();
    }

    // 케빈 베이컨의 수 구하기
    // 실수한 포인트 매개변수 start와 vetex 헷갈림
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 각각의 원소가 distance를 사용해야 하므로, 매번 초기화 해줘야함
        // 2차원 배열 안쓸거라면
        Arrays.fill(distance, -1);

        // 자기 자신 거리 0 설정
        distance[start] = 0;
        int count = distance[start];

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            count += distance[vertex];

            for (int v : graph[vertex]) {
                if (distance[v] != -1) {
                    continue;
                }

                queue.add(v);
                distance[v] = distance[vertex] + 1;
            }

        }
        return count;
    }

    private static void process() {
        int minValue = bfs(1);
        int minIndex = 1;

        for (int i = 2; i <= N; i++) {
            int nextValue = bfs(i);

            if (minValue > nextValue) {
                minValue = nextValue;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
```
