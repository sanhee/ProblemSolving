
# [숫자 카드2](https://www.acmicpc.net/problem/10816)


# 내 풀이(실패)

```java
public class Main {

    private static FastReader scan = new FastReader();
    private static int N;
    private static int[] CARDS;
    private static int M;
    private static int[] TARGETS;

    private static int binarySearch(int target) {

        int count = 0;
        int left = 0;
        int right = N - 1;
        int middle = (left + right) / 2;

        while (left <= right) {

            if (CARDS[middle] == target) {
                count++;
                if (middle + 1 < N) {
                    middle = middle + 1;
                }else{
                    left = middle + 1;
                }
                continue;
            }

            middle = (left + right) / 2;

            if (CARDS[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return count;
    }

    private static void process() {
        Arrays.sort(CARDS);
        int[] answer = new int[M];

        for (int i = 0; i < M; i++) {
            answer[i] += binarySearch(TARGETS[i]);
        }
        System.out.println(Arrays.toString(answer));
    }

    private static void input() {
        N = scan.nextInt();
        CARDS = new int[N];
        for (int i = 0; i < N; i++) {
            CARDS[i] = scan.nextInt();
        }

        M = scan.nextInt();
        TARGETS = new int[M];
        for (int i = 0; i < M; i++) {
            TARGETS[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}

```

# 풀이 보고 난 뒤

- 중복 카운팅을 어떻게 할까.. 생각을 했는데 if문 덕지덕지 외에 도저히 방법이 안떠올랐었다.
- 류호석님 풀이로 lower bound와 upper bound 활용으로 인덱스를 통해 카운팅을 하는 방법에 대해 다시한번 상기할 수 있게 됐다.
- lowerBound, upperBound를 할 때는 인덱스를 내뱉기 때문에, 리턴 값의 기본 값을 배열 길이로 해줘야함.
 - 이부분이 바이너리 서치에는 없어서 햇갈렸었음.
- 출력 형식을 처음에 배열을 그대로 toString 했었는데, 다시 보니 그냥 `숫자 공백 숫자` 형식이었다...문제 잘 읽자.

```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static FastReader scan = new FastReader();
    private static int N;
    private static int[] CARDS;
    private static int M;
    private static int[] TARGETS;

    private static int lowerBound(int target) {
        int left = 0;
        int right = N-1;
        int findIndex = N;

        while(left <= right){

            int middle = (left+right)/2;

            // lower_bound로 탐색할 대상 중 가장 왼쪽을 찾는 게 목적
            // 찾았으니 탐색된 인덱스의 오른쪽은 더이상 탐색할 필요 없음
            if(CARDS[middle] >= target){
                findIndex = middle;
                right = middle - 1;
            }else{
                left = middle+1;
            }
        }
        return findIndex;
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = N-1;
        int findIndex = N;

        while(left <= right){

            int middle = (left+right)/2;

            // upper_bound로 탐색할 대상 보다 초과하는 대상중 가장 왼쪽을 찾는게 목적
            if(CARDS[middle] > target){
                findIndex = middle;
                right = middle - 1;
            }else{
                left = middle+1;
            }
        }
        return findIndex;
    }

    private static void process() {
        Arrays.sort(CARDS);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = TARGETS[i];
            int upperIndex = upperBound(x);
            int lowerIndex = lowerBound(x);
            sb.append(upperIndex-lowerIndex).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void input() {
        N = scan.nextInt();
        CARDS = new int[N];
        for (int i = 0; i < N; i++) {
            CARDS[i] = scan.nextInt();
        }

        M = scan.nextInt();
        TARGETS = new int[M];
        for (int i = 0; i < M; i++) {
            TARGETS[i] = scan.nextInt();
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
