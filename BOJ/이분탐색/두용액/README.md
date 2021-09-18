
# [두 용액](https://www.acmicpc.net/problem/2470)



## 첫 시도

- 절대값으로 치환해서 정렬하면 좀 더 쉽게 탐색 할 수 있지 않을까?
```java
-2 4 -99 -1 98
```

```java
-1 -2 4 98 -99
```

- 생각처럼 잘 안돼서, 시도 좀 해보다가 답 참고



## 참고 풀이

```java
import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static int N;
    static int[] VALUES;


    public static void process() {

        // 이분탐색을 위한 오름차순 정렬
        Arrays.sort(VALUES);

        StringBuilder sb = new StringBuilder();

        int sum = Integer.MAX_VALUE;
        int[] elements = new int[2];

        // 배열 순회
        for (int i = 0; i < N; i++) {

            int index = lower_bound(VALUES, i + 1, N - 1, -VALUES[i]);

            // -99, -2, -2, 4, 98 인 경우에
            // 첫번째 -2를 순회할 때, 이분탐색으로 middle은 인덱스 3의 4가 나온다.
            // 하지만 인덱스2와 더했을 때, 더 작은 최소합이 나오므로, 이분탐색으로 구한 인덱스와 그 왼쪽 인덱스의 합을 비교해서 최소합을 구해야아 원하는 최소합을 구할 수 있다.

            if (index - 1 > i  && index - 1 < N && Math.abs(VALUES[i] + VALUES[index - 1]) < sum) {
                sum = Math.abs(VALUES[i] + VALUES[index - 1]);

                elements[0] = VALUES[i];
                elements[1] = VALUES[index - 1];
            }

            if (index < N && Math.abs(VALUES[i] + VALUES[index]) < sum) {
                sum = Math.abs(VALUES[i] + VALUES[index]);

                elements[0] = VALUES[i];
                elements[1] = VALUES[index];
            }

        }

        sb.append(elements[0]).append(" ").append(elements[1]);
        System.out.println(sb);
    }

    private static int lower_bound(int[] values, int left, int right, int target) {

        int index = right + 1;

        while (left <= right) {

            int middle = (left+right)/2;

            if(values[middle] >= target){
                index = middle;
                right = middle-1;
            }else {
                left = middle+1;
            }
        }

        return index;
    }


    public static void input() {
        N = scan.nextInt();
        VALUES = new int[N];

        for (int i = 0; i < N; i++) {
            VALUES[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        process();
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
