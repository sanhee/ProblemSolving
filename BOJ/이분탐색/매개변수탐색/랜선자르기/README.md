
# [랜선 자르기](https://www.acmicpc.net/problem/1654)

- ORIGIN: N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
- REVERSE: 센티미터 단위의 길이의 정수로, 랜선 N개를 만들 수 있는지? (yes/no)


1. 랜선 길이마다 모든 필요 길이를 탐색할 경우
    - 1_000_000 x 21억
2. 필요 길이를 이분 탐색하면서 랜선의 길이를 구한다면?
    - log21억 x 1_000_000


# 내 풀이
 - 실패 왜일까?
 - 자료형의 중요성..하아
  - 문제분석 제대로 하자.

```java
public class Main {

    private static FastReader scan = new FastReader();
    private static int K; // 랜선의 개수
    private static int N; // 필요한 랜선의 개수
    private static int[] LENGTH_OF_LAN_CABLE;


    private static boolean determination(int splitLength) {

        int needLength = 0;

        for (int i = 0; i < K; i++) {
            needLength += (LENGTH_OF_LAN_CABLE[i] / splitLength);
        }

        return needLength >= N;
    }

    private static void process() {
        int left = 0;
        int right = (int) Math.pow(2, 31) - 1;
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

    private static void input() {
        K = scan.nextInt();
        N = scan.nextInt();

        LENGTH_OF_LAN_CABLE = new int[K];

        for (int i = 0; i < K; i++) {
            LENGTH_OF_LAN_CABLE[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}

```

## 해답 보고 난뒤 풀이

  - long을 생각하지 못한 부분
     - `long left = 0;`
     - `long right = Integer.MAX_VALUE;`
     - `long answer = 0;`
     - `long needLength = 0;`

```java

public class Main {

    private static FastReader scan = new FastReader();
    private static int K; // 랜선의 개수
    private static int N; // 필요한 랜선의 개수
    private static int[] LENGTH_OF_LAN_CABLE;

    private static boolean determination(long splitLength) {
        // 랜선 개수= K는 1이상 10,000이하의 정수
        // splitLength가 1이면, LENGTH_OF_LAN_CABLE = 2^31-1
        // 랜선 개수X IntegerMax -> long

        long needLength = 0;

        for (int i = 0; i < K; i++) {
            needLength += (LENGTH_OF_LAN_CABLE[i] / splitLength);
        }

        return needLength >= N;
    }

    private static void process() {
        long left = 0;
        long right = Integer.MAX_VALUE;
        long answer = 0;

        while (left <= right) {

            long middle = (left + right) / 2;

            if (determination(middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(answer);
    }

    private static void input() {
        K = scan.nextInt();
        N = scan.nextInt();

        LENGTH_OF_LAN_CABLE = new int[K];

        for (int i = 0; i < K; i++) {
            LENGTH_OF_LAN_CABLE[i] = scan.nextInt();
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
