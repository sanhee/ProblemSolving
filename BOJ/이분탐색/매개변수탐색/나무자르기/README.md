
#[나무자르기](https://www.acmicpc.net/problem/2805)

## 접근 - 매개 변수 만들어 보기
- 매개 변수 탐색을 하기 위해서 매개 변수를 만들어야 함.

----

`ORIGIN`: `적어도 M미터의 나무를` 집에 가져가기 위해서 절단기에 설정할 수 있는 `높이의 최댓값`을 출력한다.

---

`REVERSE`: 절단기 `높이의 최댓값`으로 했을 때, `적어도 M미터의 나무를` 집에 갈 수 있는가? (`YES/NO`)

----

## 핵심은 이게 `결정문제`인지 확인하고, 이게 `더 쉬운 문제`인지? 판단을 해야함

- 결정 문제로 풀었을 때 o(n)
    - 높이로 다 자르면서 판단하면 되기 때문임.
    
----

## 체크
- [X] 정답을 `매개 변수(Parameter)`로 만들고 `Yes/No 문제(결정 문제)`로 바꿔 보기
- [X] 모든 값에 대해서 Yes/No 를 채웠다고 생각했을 때, 정렬된 상태인가?
- [X] Yes/No 결정하는 문제를 풀기


## 풀이

- 매개 변수 탐색...아직 처음이라 어색하다.

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final FastReader scan = new FastReader();
    private static int N; // 나무의 수
    private static int M; // 나무의 길이
    private static int[] TREES;

    private static boolean determination(int height) {
        // H=0의 높이로 자를 경우에는 1_000_000 x 2_000_000_000 = long
        long sum = 0L;

        for(int i=0; i<N; i++){
            if(TREES[i] > height){
                sum+= TREES[i] - height;
            }
        }
        return sum >= M;
    }

    private static void process(){
        int left = 0;
        int right = 2_000_000_000;

        int findIndex = 0;

        while(left <= right){
            int middle = (left+right)/2;

            if(determination(middle)){
                findIndex = middle;
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        System.out.println(findIndex);
    }

    public static void main(String[] args) {
        input();
        process();
    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        TREES = new int[N];

        for (int i = 0; i < N; i++) {
            TREES[i] = scan.nextInt();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}



```
