

# [두 수의 합](https://www.acmicpc.net/problem/3273)

# 내 풀이

- 문제 이해나 로직 짜는데 큰 어려움은 없었다.
- 하지만, binary Search안에 비교 대상 변수 findNumber를 만들어 놓고,
- 관련 없는 변수와 비교를 하다보니 원하는 결과가 나오지 않아, 디버깅하는데 오래걸렸다..
- 너무 어이없지만..내가 꼼꼼히 하지 못해 발생한 문제니까 다음부터 조심해야겠다.


```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static FastReader scan = new FastReader();
    private static int N; // 수열의 크기
    private static int[] SEQUENCE; // 수열
    private static int TARGET; // 타겟

    private static boolean binarySearch(int left, int right, int number) {

        // 넘어온 number와 더해서 TARGET을 만들어야 하므로, 차이를 구함
        int findNumber = Math.abs(TARGET - number);

        while (left <= right) {
            int middle = (left + right) / 2;

            if (SEQUENCE[middle] == findNumber) {
                return true;
            }

            if (SEQUENCE[middle] < findNumber) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }


    private static void process() {
        Arrays.sort(SEQUENCE);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (binarySearch(i + 1, N - 1, SEQUENCE[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void input() {
        N = scan.nextInt();
        SEQUENCE = new int[N];
        for (int i = 0; i < N; i++) {
            SEQUENCE[i] = scan.nextInt();
        }
        TARGET = scan.nextInt();
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
