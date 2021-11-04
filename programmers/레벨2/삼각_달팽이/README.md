
# [삼각 달팽이](https://programmers.co.kr/learn/courses/30/lessons/68645)

## 내 풀이 
- 어제 달팽이 배열 연습해서 풀이 할 수 있었던 것 같다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int[][] board;
    static int number = 1;
    static int maxNumber;
    static int N;

    enum Direction {
        DOWN, RIGHT, DIAGONAL
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


    public int[] solution(int n) {
        N = n;
        board = new int[n][n];

        for(int i=1; i<=N; i++){
            maxNumber += i;
        }

        insert(new Point(Direction.DOWN, 0, 0));

        return getAnswer();
    }

    private void insert(Point point) {

        while (number <= maxNumber) {

            board[point.row][point.col] = number++;

            int newRow, newCol;

            switch (point.direction) {
                case DOWN:
                    newRow = point.row + 1;
                    if (newRow > N - 1 || board[newRow][point.col] != 0) {
                        point.direction = Direction.RIGHT;
                        point.col++;
                    } else {
                        point.row = newRow;
                    }
                    break;
                case RIGHT:
                    newCol = point.col + 1;
                    if (newCol > N - 1 || board[point.row][newCol] != 0) {
                        point.direction = Direction.DIAGONAL;
                        point.row--;
                        point.col--;
                    } else {
                        point.col = newCol;
                    }
                    break;
                case DIAGONAL:
                    newRow = point.row - 1;
                    newCol = point.col - 1;

                    if (newRow > N - 1 || newCol > N - 1 || board[newRow][newCol] != 0) {
                        point.direction = Direction.DOWN;
                        point.row++;
                    } else {
                        point.row = newRow;
                        point.col = newCol;
                    }
                    break;
            }
        }
    }

    private int[] getAnswer() {
        List<Integer> answerList = new ArrayList<>();

        for(int row=0; row<N; row++){
            for(int col=0; col<N; col++){
                if(board[row][col] != 0){
                    answerList.add(board[row][col]);
                }
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }
}
```
