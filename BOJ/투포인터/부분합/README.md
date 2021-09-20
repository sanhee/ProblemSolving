
# [부분합](https://www.acmicpc.net/problem/1806)

## 내 풀이(참고풀이)
- 배열을 주어진 사이즈 +1 해서 다루니 햇갈려서 실수했음.
- 길이 구하는 부분을 `right- left + 1` 을 잘못 생각해서 시간이 조금 걸림
- 내가 기존에 알고있던 투포인터 방식은 `좌-> <-우` 이런방식으로 다가오는 거 였는데, 색달랐다.

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final FastReader scan = new FastReader();
    private static int N; // 수열 길이
    private static int S;  // 부분합 기준
    private static int[] SEQUENCE; // 수열
    
    private static void process() {

        int answer = N + 1;
        int right = 0;
        int sum = 0;

        for (int left = 1; left <= N; left++) {

            sum -= SEQUENCE[left - 1];

            while (right + 1 <= N && sum < S) {
                right++;
                sum += SEQUENCE[right];
            }

            if (sum >= S) {
                int length = right - left + 1;
                answer = Math.min(answer, length);
            }
        }

        if (answer == N + 1) {
            answer = 0;
        }

        System.out.println(answer);
    }

    private static void input() {
        N = scan.nextInt();
        S = scan.nextInt();

        // 투포인터 사용하기 위해 공간 +1
        SEQUENCE = new int[N + 1];

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
