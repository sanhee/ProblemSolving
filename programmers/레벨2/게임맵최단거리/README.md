
# 게임 맵 최단거리

- 예전에 비슷한 문제를 푼게 있어서, 풀이 생각하는데 어렵지 않았다.

>  https://programmers.co.kr/learn/courses/30/lessons/1844

```java
public class Solution {
    private final int[][] DIRECTION = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int WALL = 0;
    private int MAX_ROW;
    private int MAX_COLUMN;

    class Point {
        int y;
        int x;
        int distance;

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    private int bfs(int startRow, int startColumn, int endRow, int endColumn, int[][] maps) {

        boolean[][] visited = new boolean[MAX_ROW][MAX_COLUMN];
        Queue<Point> queue = new LinkedList<>();
        visited[startRow][startColumn] = true;
        queue.add(new Point(startRow, startColumn, 1));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.y == endRow && current.x == endColumn) {
                return current.distance;
            }

            // 인접 노드 새로운 좌표 생성
            for (int i = 0; i < DIRECTION.length; i++) {

                int newRow = current.y + DIRECTION[i][0];
                int newCol = current.x + DIRECTION[i][1];

                if (newRow < 0 || newRow > MAX_ROW - 1 || newCol < 0 || newCol > MAX_COLUMN - 1) {
                    continue;
                }
                if (visited[newRow][newCol]) {
                    continue;
                }
                if (maps[newRow][newCol] == WALL) {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.add(new Point(newRow, newCol, current.distance + 1));
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {

        MAX_ROW = maps.length;
        MAX_COLUMN = maps[0].length;

        return bfs(maps.length - 1, maps[0].length - 1, 0, 0, maps);
    }

}


```