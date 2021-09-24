
# [귀여운 라이언](https://www.acmicpc.net/problem/15565)


## 내 풀이(실패)

```java

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static FastReader scan = new FastReader();
    private static int N;
    private static int K;
    private static int[] SEQUENCE;

    private static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        SEQUENCE = new int[N];

        for (int i = 0; i < N; i++) {
            SEQUENCE[i] = scan.nextInt();
        }
    }

    private static int process() {
        int length = Integer.MAX_VALUE;

        return Math.min(length, dfs(0));
    }

    private static int dfs(int index) {
        int length = 0;
        int count = 0;
        int right = 0;

        if(index > N){
            return Integer.MAX_VALUE;
        }

        for (int left = index; left < N; left++) {
            if(count > 3){
                right = left;
                break;
            }
            if (SEQUENCE[left] == 1) {
                count++;

                if(index > 0) {
                    length = dfs(left);
                }
            }
        }

        if(count == 3){
            length = right - index + 1;
        }

        return length == 0 ? -1 : length;
    }


    public static void main(String[] args) {
        input();
        System.out.println(process());
    }
}


```


## 해답

- 나는 배열을 0부터 쓰는 습관이 있는데, 문제 특성을 제대로 이해하지 못하고 써서 그런지 디버깅 하는데 오래걸렸다.
- 배열을 다룰 때는 인덱스를 세세하게 생각하는 거로..


```java
public class Main {

    private static FastReader scan = new FastReader();
    private static int N;
    private static int K;
    private static int[] SEQUENCE;

    private static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        SEQUENCE = new int[N];

        for (int i = 0; i < N; i++) {
            SEQUENCE[i] = scan.nextInt();
        }
    }

    private static void process() {
        int right = 0;
        int answer = -1;
        int sum = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && sum < K) {
                if (SEQUENCE[right++] == 1) {
                    sum++;
                }
            }

            if (sum == K) {
                if (answer == -1) {
                    answer = right - left;
                }
                answer = Math.min(answer, right - left);
            }
            if(SEQUENCE[left] == 1){
                sum--;
            }
        }

        System.out.println(answer);
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