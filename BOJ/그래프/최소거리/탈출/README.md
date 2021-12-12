
# [탈출](https://www.acmicpc.net/problem/3055)

### 실수 정리
 1. int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   - 생각없이 하다가 1,1 -1,1 같이 이상한 방향 좌표를 만들어서 디버깅 하는 데 한 세월 걸림
 2. 물, 두더지 각자의 도달시간을 구해야 하므로, visited를 각 bfs마다 초기화를 해줘야하는데 그생각을 못했음
 3. 이해 잘못했었던 부분
```java
// 갈 수 없는 경로:: 이동하려는 좌표에 물이 먼저 도착할 경우
// 새롭게 이동하려는 좌표까지 물이 도달한 시간 <= 현재 고슴도치가 있는 위치까지 도달한 시간 + 1 (다음 거리)
if (waterTime[newRow][newCol] != -1 && (waterTime[newRow][newCol] <= hedgehogTime[point.row][point.col] + 1)) {
    continue;
}
```


## 참고 풀이
- 물부터 bfs 하고, bfs를 두번 해야겠다는 생각은 했지만
- 각각의 시간을 구해두는 방식을 전혀 생각 못했다.
- 또 멀티 소스 bfs 하는 방식이 감이 안와서 쉽게하지 못한 것 같다.
- 갈 수 없는 곳: `T_물 <= T_두더지+1` 을 전혀 생각 못했다 ㅠ


```java
public class Main {

    static int R;
    static int C;
    static int[][] waterTime; // 물이 도달하는 시간
    static int[][] hedgehogTime; // 고슴도치가 도달하는 시간
    static boolean[][] visited;
    static String[] matrix;
    static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Point goalPoint;

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void input() {

        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();

        waterTime = new int[R][C];
        hedgehogTime = new int[R][C];
        visited = new boolean[R][C];

        matrix = new String[R];

        scanner.nextLine();

        for (int row = 0; row < R; row++) {
            matrix[row] = scanner.nextLine();
        }

        scanner.close();
    }

    private static void waterBFS() {
        Queue<Point> queue = new LinkedList<>();

        // waterTime 초기화 과정
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                // 물이 아직 탐색하지 않은 영역이므로 -1로 초기화
                waterTime[row][col] = -1;
                visited[row][col] = false;

                if (matrix[row].charAt(col) == '*') {
                    // 물 자기 위치까지는 0초 걸림
                    waterTime[row][col] = 0;
                    visited[row][col] = true;

                    queue.add(new Point(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < DIR.length; i++) {
                int newRow = point.row + DIR[i][0];
                int newCol = point.col + DIR[i][1];

                if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }
                // 물은 '.'외에 갈 수 없다.
                if (matrix[newRow].charAt(newCol) != '.') {
                    continue;
                }

                waterTime[newRow][newCol] = waterTime[point.row][point.col] + 1;
                visited[newRow][newCol] = true;
                queue.add(new Point(newRow, newCol));
            }

        }
    }

    private static void hedgehogBFS() {

        Queue<Point> queue = new LinkedList<>();

        // hedgehogTime 초기화 과정
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                // 고슴도치가 아직 탐색하지 않은 영역이므로 -1로 초기화
                hedgehogTime[row][col] = -1;
                visited[row][col] = false;

                if (matrix[row].charAt(col) == 'S') {
                    // 고슴도치 자기 위치까지는 0초 걸림
                    hedgehogTime[row][col] = 0;
                    visited[row][col] = true;

                    queue.add(new Point(row, col));
                } else if (matrix[row].charAt(col) == 'D') {
                    goalPoint = new Point(row, col);
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < DIR.length; i++) {
                int newRow = point.row + DIR[i][0];
                int newCol = point.col + DIR[i][1];

                if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }
                if (matrix[newRow].charAt(newCol) != '.' && matrix[newRow].charAt(newCol) != 'D') {
                    continue;
                }
                // 갈 수 없는 경로:: 이동하려는 좌표에 물이 먼저 도착할 경우
                // 새롭게 이동하려는 좌표까지 물이 도달한 시간 <= 현재 고슴도치가 있는 위치까지 도달한 시간 + 1 (다음 거리)
                if (waterTime[newRow][newCol] != -1 && (waterTime[newRow][newCol] <= hedgehogTime[point.row][point.col] + 1)) {
                    continue;
                }

                visited[newRow][newCol] = true;
                hedgehogTime[newRow][newCol] = hedgehogTime[point.row][point.col] + 1;
                queue.add(new Point(newRow, newCol));
            }
        }
    }

    private static void process() {

        waterBFS();
        hedgehogBFS();

        int minTime = hedgehogTime[goalPoint.row][goalPoint.col];

        if (minTime == -1) {
            System.out.print("KAKTUS");
        } else {
            System.out.print(minTime);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}

```


## 첫 풀이(실패)

```java
public class Main {
    static int R;
    static int C;
    static char[][] matrix;
    static int[][] distance;
    static boolean[][] visited;
    static final int[][] DIR = new int[][]{{-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    static Queue<Point> waterPos;
    static Queue<Point> userPos;
    static Point gaolPos;

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();

        matrix = new char[R][C];
        distance = new int[R][C];
        visited = new boolean[R][C];

        // 방문하지 않은 거리 기본값 -1
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                distance[r][c] = -1;
            }
        }

        waterPos = new LinkedList<>();
        userPos = new LinkedList<>();

        // matrix 초기 설정 및 물, 고슴도치 위치 수집
        for (int r = 0; r < R; r++) {
            String matrixLine = scanner.next();
            for (int c = 0; c < C; c++) {
                char element = matrixLine.charAt(c);
                matrix[r][c] = element;

                if (element == '*') {
                    waterPos.add(new Point(r, c));
                } else if (element == 'S') {
                    userPos.add(new Point(r, c));
                    distance[r][c] = 0;
                } else if (element == 'D') {
                    gaolPos = new Point(r, c);
                }
            }
        }

        scanner.close();
    }

    private static String bfs() {

        while (!waterPos.isEmpty()) {

            if(userPos.isEmpty()){
                return "KAKTUS";
            }

            Point w = waterPos.poll();
            visited[w.row][w.col] = true;

            for (int i = 0; i < DIR.length; i++) {
                int newRow = w.row + DIR[i][0];
                int newCol = w.col + DIR[i][1];

                if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }
                if (matrix[newRow][newCol] == 'X' || matrix[newRow][newCol] == 'D' || matrix[newRow][newCol] == '*') {
                    continue;
                }

                matrix[newRow][newCol] = '*';
                waterPos.add(new Point(newRow, newCol));
                visited[newRow][newCol] = true;
            }

            while (!userPos.isEmpty()) {
                Point u = userPos.poll();

                for (int i = 0; i < DIR.length; i++) {
                    int newRow = u.row + DIR[i][0];
                    int newCol = u.col + DIR[i][1];

                    if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                        continue;
                    }
                    if (visited[newRow][newCol]) {
                        continue;
                    }
                    if (matrix[newRow][newCol] == 'X' || matrix[newRow][newCol] == '*') {
                        continue;
                    }

                    distance[newRow][newCol] = distance[u.row][u.col] + 1;
                    visited[newRow][newCol] = true;
                    userPos.add(new Point(newRow, newCol));


                    if (matrix[newRow][newCol] == 'D') {
                        return String.valueOf(distance[newRow][newCol]);
                    }
                }
            }
        }

        if(waterPos.isEmpty() && !userPos.isEmpty()){
            while (!userPos.isEmpty()) {
                Point u = userPos.poll();

                for (int i = 0; i < DIR.length; i++) {
                    int newRow = u.row + DIR[i][0];
                    int newCol = u.col + DIR[i][1];

                    if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                        continue;
                    }
                    if (visited[newRow][newCol]) {
                        continue;
                    }
                    if (matrix[newRow][newCol] == 'X' || matrix[newRow][newCol] == '*') {
                        continue;
                    }

                    distance[newRow][newCol] = distance[u.row][u.col] + 1;
                    visited[newRow][newCol] = true;
                    userPos.add(new Point(newRow, newCol));


                    if (matrix[newRow][newCol] == 'D') {
                        return String.valueOf(distance[newRow][newCol]);
                    }
                }
            }
        }

        return "KAKTUS";
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(distance[gaolPos.row][gaolPos.col]);
    }
}

```
