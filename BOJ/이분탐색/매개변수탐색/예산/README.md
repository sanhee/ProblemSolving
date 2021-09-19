

# [예산](https://www.acmicpc.net/problem/2512)

- 파라메트릭 서치를 할 때, 생각없이 right 범위를 매개 변수로 정한 값이 들어가갈 수 있는 최대값으로 지정했다가 문제를 틀렸다.
    - 조건: `정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법`에 따라
    - 요청 금액을 탐색해서 최대값을 right로 초기화 시켜줘야함.

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 지방의 수
    private static int[] REQUESTS; // 각 지방의 예산요청
    private static int M; // 총 예산


    private static void process() {

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            right = Math.max(right, REQUESTS[i]);
        }
        
        int answer = 0;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (determination(middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean determination(int budget) {
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += Math.min(REQUESTS[i], budget);
        }

        return M >= total;
    }

    private static void input() {
        N = scan.nextInt();
        REQUESTS = new int[N];

        for (int i = 0; i < N; i++) {
            REQUESTS[i] = scan.nextInt();
        }

        M = scan.nextInt();
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
