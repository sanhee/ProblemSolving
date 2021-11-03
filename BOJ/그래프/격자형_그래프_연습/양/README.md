
# [양](https://www.acmicpc.net/problem/3184)

## 첫 시도 - 틀림

```java
public class Main {
    private static int R;
    private static int C;
    private static String[][] board;
    private static boolean[][] visited;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int initWolf;
    private static int initSheep;
    private static int tempWolf;
    private static int tempSheep;

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();

        board = new String[R][C];
        visited = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            String s = scanner.next();
            String[] lines = s.split("");
            for (int col = 0; col < C; col++) {
                board[row][col] = lines[col];

                if (board[row][col].equalsIgnoreCase("V")) {
                    initWolf++;
                } else if (board[row][col].equalsIgnoreCase("O")) {
                    initSheep++;
                }

            }
        }
        scanner.close();
    }

    // 목적: 동일한 영역 찾기
    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < DIRECTIONS.length; i++) {

            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];

            if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            // 울타리인 경우
            if (board[newRow][newCol].equalsIgnoreCase("#")) {
                continue;
            }

            if (board[newRow][newCol].equalsIgnoreCase("V")) {
                tempWolf++;
            } else if (board[newRow][newCol].equalsIgnoreCase("O")) {
                tempSheep++;
            }
            dfs(newRow, newCol);

        }

    }

    private static void process() {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                if (!visited[row][col] && board[row][col].equalsIgnoreCase(".") ){

                    tempWolf = 0;
                    tempSheep = 0;

                    dfs(row, col);

                    if (tempWolf >= tempSheep) {
                        initSheep = initSheep - tempSheep;
                    } else {
                        initWolf = initWolf - tempWolf;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(initSheep + " " + initWolf);
    }
}

```

## 개선

- 한 영역의 늑대와 양을 구하는 것을 dfs에서 새로운 좌표를 구한 이후에 했었는데 이게 잘못됐던 거였다.
- dfs를 시작할 때부터, 양이나 늑대가 들어올 수 있는데 그런 경우가 무시되서 그런 것..
- visitied같이 사전에 미리 체크하고 업데이트 해줘야한다.


```java
import java.util.Scanner;

public class Main {
    private static int R;
    private static int C;
    private static String[][] board;
    private static boolean[][] visited;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int initWolf;
    private static int initSheep;
    private static int tempWolf;
    private static int tempSheep;

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();

        board = new String[R][C];
        visited = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            String s = scanner.next();
            String[] lines = s.split("");
            for (int col = 0; col < C; col++) {
                board[row][col] = lines[col];

                if (board[row][col].equalsIgnoreCase("V")) {
                    initWolf++;
                } else if (board[row][col].equalsIgnoreCase("O")) {
                    initSheep++;
                }

            }
        }
        scanner.close();
    }

    // 목적: 동일한 영역 찾기
    private static void dfs(int row, int col) {
        visited[row][col] = true;

        if (board[row][col].equalsIgnoreCase("V")) {
            tempWolf++;
        } else if (board[row][col].equalsIgnoreCase("O")) {
            tempSheep++;
        }

        for (int i = 0; i < DIRECTIONS.length; i++) {

            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];

            if (newRow < 0 || newCol < 0 || newRow > R - 1 || newCol > C - 1) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            // 울타리인 경우
            if (board[newRow][newCol].equalsIgnoreCase("#")) {
                continue;
            }

            dfs(newRow, newCol);
        }

    }

    private static void process() {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                if (!visited[row][col] && !board[row][col].equalsIgnoreCase("#") ){

                    tempWolf = 0;
                    tempSheep = 0;

                    dfs(row, col);

                    if (tempWolf >= tempSheep) {
                        initSheep = initSheep - tempSheep;
                    } else {
                        initWolf = initWolf - tempWolf;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(initSheep + " " + initWolf);
    }
}

```
