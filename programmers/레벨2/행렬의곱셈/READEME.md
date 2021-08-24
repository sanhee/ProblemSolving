
# 행렬의 곱셈

> https://programmers.co.kr/learn/courses/30/lessons/12949

- 행렬을 코드로 구현하려니까 생각보다 쉽게 되지 않았다..(아직 반복문을 제대로 못다루는 거 같다.)


# 내 풀이

```java

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < arr1.length; row++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int col = 0; col < arr1[0].length; col++) {
                queue.add(arr1[row][col]);
            }

            for (int col2 = 0; col2 < arr2[0].length; col2++) {
                for (int row2 = 0; row2 < arr2.length; row2++) {

                    if (!queue.isEmpty()) {
                        int temp = queue.poll();
                        answer[row][col2] += temp * arr2[row2][col2];
                        queue.add(temp);
                    }
                }
            }

        }
        return answer;
    }
}
```

## 다른 사람 풀이

```java
class ProductMatrix {
    public int[][] productMatrix(int[][] A, int[][] B) {
        int[][] answer = new int[A.length][B[0].length];
        if (A[0].length == B.length) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        answer[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return answer;
    }
}
```