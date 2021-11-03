
# [유기농 배추](https://www.acmicpc.net/problem/1012)


```java
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int M; // 배추밭 가로길이
    private static int N; // 배추밭 세로길이
    private static int K; // 배추가 심어져 있는 위치의 개수
    private static boolean[][] positions;
    private static boolean[][] visited;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void input() {
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        positions = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int column = sc.nextInt();
            int row = sc.nextInt();

            positions[row][column] = true;
        }
    }

    private static void process() {

        int answer = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                // 방문하지 않은 배추밭
                if (!visited[row][col] && positions[row][col]) {
                    answer++;
                    dfs(row, col);
                }
            }
        }

        System.out.println(answer);
    }

    // 탐색할 수 있는 좌표부터 시작
    private static void dfs(int startRow, int startCol) {

        visited[startRow][startCol] = true;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = startRow + DIRECTIONS[i][0];
            int newCol = startCol + DIRECTIONS[i][1];

            // board 경계 벗어난 경우에 대한 예외처리
            if (newRow < 0 || newCol < 0 || newRow > N - 1 || newCol > M - 1) {
                continue;
            }

            // 배추밭이 아닌 경우
            if(!positions[newRow][newCol]){
                continue;
            }

            // 이미 방문한 배추밭인 경우 탐색 제외
            if (visited[newRow][newCol]) {
                continue;
            }
            // 방문하지 않은 새로운 배추인 경우 탐색 시작
            dfs(newRow, newCol);
        }

    }

    public static void main(String[] args) {
        int testCaseNum = sc.nextInt();

        while (testCaseNum-- > 0) {
            input();
            process();
        }
    }

}
```
