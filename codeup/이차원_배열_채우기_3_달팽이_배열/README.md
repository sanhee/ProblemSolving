
# [1505 : 2차원 배열 채우기 3(달팽이 배열)](https://codeup.kr/problem.php?id=1505)

```
위에 부딪히면, 오른
오른쪽에 부딪히면, 아래
왼쪽에 부딪히면, 위
아래에 부딪히면, 왼쪽
부딪힌다 기준:
  1. 배열의 범위를 벗어나는 경우
  2. 해당 인덱스의 배열에 원소가 존재하는 경우
```


```java
public class Main {

    private static int number = 1;
    private static int N;
    private static int[][] board;

    enum Direction {
        RIGHT, DOWN, LEFT, UP;
    }

    static class Point {
        Direction direction;
        int row, col;

        public Point(Direction direction, int row, int col) {
            this.direction = direction;
            this.row = row;
            this.col = col;
        }
    }

    private static void insert(Point point) {
        if(number > N*N){
            return;
        }

        board[point.row][point.col] = number;
        number++;

        moveAndBalance(point);
        insert(point);
    }


    private static void moveAndBalance(Point point) {
        final int MAX_POS = board.length;

        switch (point.direction){
            case RIGHT:
                if(point.col+1 >= MAX_POS || board[point.row][point.col+1] != 0){
                    point.direction = Direction.DOWN;
                    point.row++;
                }else{
                    point.col++;
                }
                break;
            case DOWN:
                if(point.row+1 >= MAX_POS || board[point.row+1][point.col] != 0){
                    point.direction = Direction.LEFT;
                    point.col--;
                }else{
                    point.row++;
                }
                break;
            case LEFT:
                if(point.col-1 < 0 || board[point.row][point.col-1] != 0){
                    point.direction = Direction.UP;
                    point.row--;
                }else{
                    point.col--;
                }
                break;
            case UP:
                if(point.row-1 < 0 || board[point.row-1][point.col] != 0){
                    point.direction = Direction.RIGHT;
                    point.col++;
                }else{
                    point.row--;
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        insert(new Point(Direction.RIGHT, 0, 0));

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                sb.append(board[row][col]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        sc.close();
    }
}

```