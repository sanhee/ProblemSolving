
# [섬의 개수](https://www.acmicpc.net/problem/4963)
- 문제는 안 어려운데, 입출력 때문에 너무 헤멨음..
- input 메소드 안에 scanner를 넣고 close를 안해주니까, 정상작동을 안해서.. 

```java
import java.util.Scanner;

public class Main {
    private static int w;
    private static int h;
    private static boolean[][] visited;
    private static int[][] board;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    private static Scanner scan = new Scanner(System.in);

    private static void input() {
        w = scan.nextInt();
        h = scan.nextInt();

        board = new int[h][w];
        visited = new boolean[h][w];

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                board[row][col] = scan.nextInt();
            }
        }
    }

    private static void dfs(int startRow, int startCol) {
        visited[startRow][startCol] = true;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = startRow + DIRECTIONS[i][0];
            int newCol = startCol + DIRECTIONS[i][1];


            if(newRow < 0 || newCol < 0 || newRow > h-1 || newCol > w-1){
                continue;
            }
            if(board[newRow][newCol] == 0){
                continue;
            }
            if(visited[newRow][newCol]){
                continue;
            }

            dfs(newRow, newCol);
        }

    }

    private static void process() {
        int answer = 0;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (!visited[row][col] && board[row][col] == 1) {
                    answer++;
                    dfs(row, col);
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (w == 0 && h == 0) {
                break;
            }
            process();
        }
        scan.close();
    }
}
```
