# [N-Queen](https://www.acmicpc.net/problem/9663)


```
/*
    퀸은 대각선, 가로라인을 자유롭게 다닐 수 있음.

    - [1로우]에 해당하는 컬럼의 개수는 1개여야함.
      - 컬럼마다 놓으면서 서로 공격할 수 있는지 검사를 한다.
      - 절대 세로로 일렬로 놓을 수 없음
      - 공격할 수 없으면 [카운트 +1]

    - 공격체크
      - 같은 로우에 있는지
        - (row,col) == (prev) (row,col)

      - 이전 로우의 대각선 범위에 있는지
        - 좌측 대각선 판단: row-col == (prev) row-col
        - 우측 대각선 판단: row+col == (prev) row+col

*/
```

```java
public class Main {

    private static int[] column;
    private static int result;
    private static FastReader scan = new FastReader();
    private static int N;
    
    private static boolean attackable(int r1, int c1, int r2, int c2) {

        if(c1 == c2 || r1+c1 == r2+c2 || r1-c1 == r2-c2 ){
            return true;
        }
        return false;
    }

    private static void rec_func(int row) {

        if(row == N){
            result++;
        }else{

            for(int i=0; i<N; i++){
                boolean possible = true;

                for(int j=0; j<row; j++){
                    if(attackable(row, i, j, column[j])){
                        possible = false;
                        break;
                    }
                }

                if(possible){
                    column[row] = i;
                    rec_func(row+1);
                    column[row] = 0;
                }
            }

        }

    }


    private static void input(){
        N = scan.nextInt();
        column = new int[N];
    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(0);
        System.out.println(result);
    }
}

```