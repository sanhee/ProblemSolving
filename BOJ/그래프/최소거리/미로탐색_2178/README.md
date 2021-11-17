
# [미로 탐색](https://www.acmicpc.net/problem/2178)

## 메모리 초과 해결
- 시도 한 것
   - distance 배열 초기화 부분을 bfs로 이동
   - visited 처리 위치
    
- 정확하게 왜 메모리초과 였는지 모르겠음..

```java
public class Main {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[][] distance;
    static final int[][] DIRECTION = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        visited = new boolean[N][M];
        distance = new int[N][M];

        matrix = new int[N][M];

        for (int row = 0; row < N; row++) {
            char[] line = scanner.next().toCharArray();
            for (int col = 0; col < M; col++) {
                matrix[row][col] = line[col] - '0';
            }
        }

        scanner.close();
    }

    private static void bfs(Point point) {

        // 배열 초기화
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                distance[row][col] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        distance[point.row][point.col] = 1; // 시작점은 거리 1
        visited[point.row][point.col] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < DIRECTION.length; i++) {
                int newRow = p.row + DIRECTION[i][0];
                int newCol = p.col + DIRECTION[i][1];

                if (newRow < 0 || newCol < 0 || newRow > N - 1 || newCol > M - 1) {
                    continue;
                }
                if(matrix[newRow][newCol] == 0){
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }

                queue.add(new Point(newRow, newCol));
                visited[newRow][newCol] = true;
                distance[newRow][newCol] = distance[p.row][p.col] + 1;
            }

        }

    }

    public static void main(String[] args) {
        input();
        bfs(new Point(0, 0));

        System.out.println(distance[N - 1][M - 1]);
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
```

## 내 풀이
- 테스트 케이스도 모두 통과하고, 로직은 맞는 것 같은데 *메모리 초과*가 뜬다..

```java
public class Main {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[][] distance;
    static final int[][] DIRECTION = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                distance[row][col] = -1;
            }
        }
        // 시작점은 거리 1
        distance[0][0] = 1;

        matrix = new int[N][M];

        for (int row = 0; row < N; row++) {
            char[] line = scanner.next().toCharArray();
            for (int col = 0; col < M; col++) {
                matrix[row][col] = line[col] - '0';
            }
        }

        scanner.close();
    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.row][p.col] = true;

            for (int i = 0; i < DIRECTION.length; i++) {
                int newRow = p.row + DIRECTION[i][0];
                int newCol = p.col + DIRECTION[i][1];

                if (newRow < 0 || newCol < 0 || newRow > N - 1 || newCol > M - 1) {
                    continue;
                }
                if(matrix[newRow][newCol] == 0){
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }

                queue.add(new Point(newRow, newCol));
                distance[newRow][newCol] = distance[p.row][p.col] + 1;
            }

        }

    }

    public static void main(String[] args) {
        input();
        bfs(new Point(0, 0));

        System.out.println(distance[N - 1][M - 1]);
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
```


## 류호석님 풀이
- 내가 생각한 로직과 비슷함

```java
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist = new int[N][M];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        // dist 배열 초기화
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) dist[i][j] = -1;

        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (a[nx].charAt(ny) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        // 시작점이 (0, 0)인 탐색 시작
        bfs(0, 0);

        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
```