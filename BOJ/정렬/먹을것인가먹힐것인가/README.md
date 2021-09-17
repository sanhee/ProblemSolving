
# [먹을 것인가 먹힐 것인가](https://www.acmicpc.net/problem/7795)

## 내 풀이

```java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static FastReader scan = new FastReader();
    private static int[] A;
    private static int[] B;
    private static int N; // A의 수
    private static int M; // B의 수

    public static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        A = new int[N];
        B = new int[M];

        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        for (int i = 0; i < M; i++) {
            B[i] = scan.nextInt();
        }
    }


    public static void main(String[] args) {
        int numOfTestCase = scan.nextInt();
        for (int test = 0; test < numOfTestCase; test++) {
            int answer = 0;
            input();
            // 이분탐색을 위해 오름차순 정렬
            Arrays.sort(B);

            for (int i = 0; i < N; i++) {
                answer += lowerBound(0, M-1, A[i]);
            }
            System.out.println(answer);
        }

    }

    private static int lowerBound(int left, int right, int target) {

        int result = left;


        while (left <= right){

            int middle = (left+right)/2;

            if (B[middle] < target) {
                left = middle+1;
                result = middle;
            }else{
                right = middle-1;
            }

        }
        return result;
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