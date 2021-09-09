
# [부분수열의 합](https://www.acmicpc.net/problem/1182)

> 문제에서 말하는 `크기가 양수인 부분수열`이란 말이 아직 이해가 가지 않는다.

```java
public class Main {

    private static int N, S;
    private static int[] sequence;
    private static int answer;
    private static FastReader scan = new FastReader();

    private static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = scan.nextInt();
        }
    }

    private static void rec_func(int index, int value) {
        if (index == N) {
            if (value == S) {
                answer++;
            }
        } else {
            rec_func(index + 1, value + sequence[index]);
            rec_func(index + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0, 0);

        // 진부분집합
        if (S == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    static class FastReader {

        private BufferedReader br;
        private StringTokenizer st;

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