
# [수열](https://www.acmicpc.net/problem/2559)

## 해답 풀이

- 아직 투포인터 개념이 너무 약해서 그런지 범위 커팅 하는 부분을 쉽게 생각하지 못해서 해답을 보게됐다.
- 배열 마지막으로 갈 수록 K만큼 더하지 못하는 경우를 생각못함.
    - left + K - 1 = (현재커서 + 연속날짜 - 1) 로 반복문 제한을 두는 부분을 아예 생각못했다.
    
```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 온도를 측정한 전체 날짜의 수
    private static int K; // 합을 구하기 위한 연속적인 날짜의 수
    private static int[] SEQUENCE;

    private static void process() {
        int answer = -100 * N;
        int right = 0;
        int sum = 0;

        for (int left = 1; left + K - 1 <= N; left++) {
            if (left > 0) {
                sum -= SEQUENCE[left - 1];
            }

            while (right + 1 <= left + K - 1) {
                sum += SEQUENCE[++right];
            }

            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    private static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        SEQUENCE = new int[N+1];

        for (int i = 1; i <= N; i++) {
            SEQUENCE[i] = scan.nextInt();
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


## 내 풀이(실패)

```java
public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 온도를 측정한 전체 날짜의 수
    private static int K; // 합을 구하기 위한 연속적인 날짜의 수
    private static int[] SEQUENCE;

    private static void process() {

        int answer = 0;
        int right = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int count = 1;

            if (i > 0) {
                sum -= SEQUENCE[i - 1];
            }

            while (right + 1 < N && count < K) {
                sum += SEQUENCE[right++];
                count++;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    private static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        SEQUENCE = new int[N];

        for (int i = 0; i < N; i++) {
            SEQUENCE[i] = scan.nextInt();
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