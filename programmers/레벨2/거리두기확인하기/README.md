## 거리두기 확인하기

> https://programmers.co.kr/learn/courses/30/lessons/81302

- 문제 해석이 오래걸려서 2시간 걸렸지만, 답 안보고 내 스스로 풀었다는 거에 너무 뿌듯하다.
- 처음엔 DFS로 풀어야하나? 생각을 했는데 주변을 계속 비교해야해서 포기했다.
- 시작을 DFS로 하다보니 가지치기 하려고 visited 변수를 남겨뒀었는데, 내가 작성한 로직은 가지치기를 하면 안되는 로직이었다. 
  - 노드 양쪽에서 거리두기 비교를 해야하는데, visited를 써버리면 비교를 못함..

- ![image-20210812035122923](images/image-20210812035122923.png)



```java
class Solution {

    private static final int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String EMPTY = "O";
    private static final String PLAYER = "P";

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        // 3차원 배열 - 이렇게 하는게 맞을까? -_-
        List<List<List<String>>> list = new ArrayList<>();

        // 문자열을 2차원 배열로 변환 ex) "POOOP" -> {P,O,O,O,P}
        for (String[] place : places) {
            List<List<String>> tempMatrix = new ArrayList<>();
            for (int i = 0; i < place.length; i++) {
                tempMatrix.add(Arrays.asList(place[i].split("")));
            }
            list.add(tempMatrix);
        }

        int index = 0;

        for (List<List<String>> matrix : list) {
            result[index] = search(matrix);
            index++;
        }

        return result;
    }

    private int search(List<List<String>> matrix) {

        for (int row = 0; row < matrix.size(); row++) {

            for (int column = 0; column < matrix.get(row).size(); column++) {

                String currentElement = matrix.get(row).get(column);

                // O 가 P를 만나는 거 카운트
                int count = 0;

                for (int i = 0; i < DIRECTION.length; i++) {
                    int newRow = row + DIRECTION[i][0];
                    int newColumn = column + DIRECTION[i][1];

                    // 생성된 인근 좌표가 유효하지 않을 경우
                    if (newRow < 0 || newRow > 4 || newColumn < 0 || newColumn > 4) {
                        continue;
                    }
                    String nextElement = matrix.get(newRow).get(newColumn);

                    if (currentElement.equals(PLAYER) && currentElement.equals(nextElement)) {
                        return 0;
                    }
                    if ((currentElement.equals(EMPTY) && nextElement.equals(PLAYER))) {
                        if (count == 1) {
                            return 0;
                        }
                        count++;
                    }
                }
            }

        }
        return 1;
    }
}
```

## 다른 사람 풀이



```java

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int[] answer;

    public void dfs(int num, int x, int y, int count, String[] places){
        if (count > 2) return;
        if (count > 0 && count <= 2 && places[x].charAt(y) == 'P'){
            //2칸 범위내에 다른 응시자가 있을 경우 거리두기 미준수로 0처리
            answer[num] = 0;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사, 파티션으로 분리되어 있는 경우 상관 없음.
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && places[nx].charAt(ny) != 'X') {
                if (visit[nx][ny]) continue; //이미 방문한 곳일 경우 생략
                visit[nx][ny] = true;
                dfs(num, nx, ny, count + 1, places);
                visit[nx][ny] = false;
            }
        }
    }

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P'){
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
}
```

