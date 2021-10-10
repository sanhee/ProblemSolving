

# [행렬 테두리 회전하기](https://programmers.co.kr/learn/courses/30/lessons/77485)

## 나의 풀이

- 아니 문제에서 주어진 `queries의 각 행은 4개의 정수 [x1, y1, x2, y2]` 이거 해석을 잘못해서 완전 이상한 삽질함
- x를 당연히 컬럼으로 생각했는데, 주어진건 로우였음 허허ㅋㅋㅋ
- 배열을 복사해서 사용하지 않아도 풀이할 수 있는데, 풀 때 생각을 못했음

```java
import java.util.Arrays;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        Arrays.fill(answer, Integer.MAX_VALUE);

        initMatrix(rows, columns, matrix);

        int answerIndex = 0;
        for(int[] query : queries){
            int row1 = query[0]-1;
            int col1 = query[1]-1;
            int row2 = query[2]-1;
            int col2 = query[3]-1;

            int[][] matrixClone = new int[rows][columns];

            copyMatrix(rows, columns, matrix, matrixClone);


            for(int row= row1; row <= row2; row++){
                for(int col= col1; col <= col2; col++){

                    // 오른쪽 밀기
                    if(row == row1){
                        if(col == col1){
                            matrixClone[row][col] = matrix[row+1][col];
                            answer[answerIndex] = Math.min(answer[answerIndex], matrix[row+1][col]);
                        }else{
                            matrixClone[row][col] = matrix[row][col-1];
                            answer[answerIndex] = Math.min(answer[answerIndex], matrix[row][col-1]);
                        }
                    }

                    // 아래로 밀기
                    else if(col == col2){
                        matrixClone[row][col] = matrix[row-1][col];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row-1][col]);
                    }

                    // 왼쪽으로 밀기
                    else if(row == row2){
                        matrixClone[row][col] = matrix[row][col+1];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row][col+1]);
                    }

                    // 위로 밀기
                    else if(col == col1){
                        matrixClone[row][col] = matrix[row+1][col];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row+1][col]);
                    }
                }
            }

            copyMatrix(rows, columns, matrixClone, matrix);
            answerIndex++;
        }

        return answer;
    }

    private void copyMatrix(int rows, int columns, int[][] matrix, int[][] matrixClone) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrixClone[row][column] = matrix[row][column];
            }
        }
    }

    private void initMatrix(int rows, int columns, int[][] matrix) {
        int count = 1;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = count++;
            }
        }
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;

        int[][] queries = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        new Solution().solution(rows, columns, queries);
    }
}

```


## 다른 사람 풀이

```java
import java.util.*;

class Solution {
    int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        this.matrix = new int[rows][columns];  // 행렬 생성
        int[] answer = new int[queries.length]; // 정답 배열
        
        for(int i = 0; i < rows; i++){  // 행렬 초기화
            for(int j = 0; j < columns; j++){
                matrix[i][j] = i*columns + j + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++){ // 회전하고 최솟값 answer에 저장
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query){
        int r1 = query[0]-1; 
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;
        
        int temp = this.matrix[r1][c1]; // 시작위치 값 임시저장
        int min = temp;                 // min값 초기화
        for(int i = r1; i < r2; i++){ // 회전의 1번
            this.matrix[i][c1] = this.matrix[i+1][c1];
            if(min > this.matrix[i][c1]) min = this.matrix[i][c1];
        }
        for(int i = c1; i < c2; i++){ // 회전의 2번
            this.matrix[r2][i] = this.matrix[r2][i+1];
            if(min > this.matrix[r2][i]) min = this.matrix[r2][i];
        }
        for(int i = r2; i > r1; i--){ // 회전의 3번
            this.matrix[i][c2] = this.matrix[i-1][c2];
            if(min > this.matrix[i][c2]) min = this.matrix[i][c2];
        }
        for(int i = c2; i > c1; i--){ // 회전의 4번
            this.matrix[r1][i] = this.matrix[r1][i-1];
            if(min > this.matrix[r1][i]) min = this.matrix[r1][i];
        }
        this.matrix[r1][c1+1] = temp; // 임시저장한 값 저장
        
        return min; 최솟값 반환
    }
    
}
```