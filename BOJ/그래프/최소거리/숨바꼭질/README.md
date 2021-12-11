
# [숨바꼭질](https://www.acmicpc.net/problem/1697)

- 수빈: N 점
    - WALK
      : 1초 후 X-1 or X+1
    - TELEPORT
      : 1초 후 2*X
- 동생: K 점

### 문제 파악하기
- 정답의 최대치
   - N > K 라면, 갈 수 있는 방법이 -1씩 감소하는 것뿐
   - N=10만, K=0인 경우, 10만 초로 제일 오래 걸린다.  


## 내 풀이(성공)
- 처음 최소치와, 최대치를 잘못 구해서, 문제를 틀렸었음.
- 문제 파악을 잘하자.

```java
import java.util.Scanner;

public class Main {

    static final int[] DIR = {-1, 1, 2};
    static int N; // 수빈이가 있는 위치
    static int K; // 동생이 있는 위치
    static int[] time; // 걸리는 시간을 담는 배열
    static int min;
    static int max;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        // 정답의 최대치
        // N > K 라면, 갈 수 있는 방법이 -1씩 감소하는 것뿐
        // N=10만, K=0인 경우, 10만 초로 제일 오래 걸린다.
        max = 100_000;
        min = 0;

        time = new int[max+1];

        Arrays.fill(time, -1);
        time[N] = 0;

        scanner.close();
    }

    private static int bfs(int start) {
        int searchTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int i=0; i<3; i++){
                if(time[K] != -1){
                    return time[K];
                }

                int newCol;

                if(i!=2) {
                    newCol = current + DIR[i];
                }else{
                    newCol = current * DIR[i];
                }

                if(newCol < min || newCol > max){
                    continue;
                }
                if(time[newCol] != -1){
                    continue;
                }

                queue.add(newCol);
                time[newCol] = time[current] + 1;
            }
        }

        return searchTime;
    }

    public static void main(String[] args) {
        input();
        bfs(N);
        System.out.print(time[K]);
    }
}

```

## 류호석님 풀이
- 순회 방향이 3가지 뿐이고, +,-,* 3가지 사칙 연산이 필요하다.
- 어거지로 반복문 순회 + 조건문 조합보다는
- 류호석님 풀이처럼 중복되더라도, 아래처럼 작성하는 게 가독성이 좋은듯.

```java
 // 숨바꼭질 시작~
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            if (x - 1 >= 0 && !visit[x - 1]) {
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                Q.add(x - 1);
            }
            if (x + 1 <= 100000 && !visit[x + 1]) {
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                Q.add(x + 1);
            }
            if (x * 2 <= 100000 && !visit[x * 2]) {
                visit[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                Q.add(x * 2);
            }
        }
    }
```
