
# [수들의 합2](https://www.acmicpc.net/problem/2003)

## 내 풀이(성공)

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final FastReader scan = new FastReader();
    private static int N;
    private static int M;
    private static int[] A;

    private static void process() {

        int count = 0;
        int sum = 0;
        int right = 0;

        for(int i=1; i<=N; i++){
            sum -= A[i-1];

            while(right + 1 <= N && sum < M){
                right++;
                sum += A[right];
            }

            if(sum == M){
                count++;
            }
        }

        System.out.println(count);
    }

    private static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
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
