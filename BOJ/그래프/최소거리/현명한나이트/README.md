
# [현명한 나이트](https://www.acmicpc.net/problem/18404)

- 인풋을 꼭 처음부터 다 할 필요가 없다, 필요할 때 인풋을 받는 연습을 하자.
 - 적 엔티티의 좌표를 거리 계산 다하고, 나중에 받는 게 연산이 더 빠르고 쉬움

## 풀이

```java
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] distance;
    static int[][] DIR = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Point point = input();
        bfs(point);

        print();
        scanner.close();
    }
    
    static class Point {

        int row, col;
        public Point(int row, int y) {
            this.row = row;
            this.col = y;
        }

    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            for (int index = 0; index < DIR.length; index++) {
                int newRow = current.row + DIR[index][0];
                int newCol = current.col + DIR[index][1];

                if (newRow < 0 || newCol < 0 || newRow > N - 1 || newCol > N - 1) {
                    continue;
                }
                if (distance[newRow][newCol] != -1) {
                    continue;
                }

                distance[newRow][newCol] = distance[current.row][current.col] + 1;
                queue.add(new Point(newRow, newCol));
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M-1; i++){
            sb.append(distance[scanner.nextInt()-1][scanner.nextInt()-1]).append(" ");
        }
        sb.append(distance[scanner.nextInt()-1][scanner.nextInt()-1]);

        System.out.print(sb);
    }

    private static Point input() {
        N = scanner.nextInt();
        M = scanner.nextInt();

        // King이 다녀간 거리를 저장하는 변수
        // 기본값: 0:
        distance = new int[N][N];

        for(int row = 0; row< distance.length; row++){
            for(int col= 0; col< distance[row].length; col++){
                distance[row][col] = -1;
            }
        }

        int startRow = scanner.nextInt()-1;
        int startCol = scanner.nextInt()-1;

        // 시작 지점 0
        distance[startRow][startCol] = 0;

        return new Point(startRow, startCol);
    }
}

```


## 류호석님 풀이

```java
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sx, sy;
    static int[][] dist;
    static int[][] dir = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        sx = scan.nextInt();
        sy = scan.nextInt();
        dist = new int[N + 1][N + 1];
    }

    static void bfs() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        dist[sx][sy] = 0;
        Q.add(sx);
        Q.add(sy);

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (dist[nx][ny] != -1) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        while (M-- > 0) {
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            System.out.print(dist[ex][ey]+ " ");
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
```
