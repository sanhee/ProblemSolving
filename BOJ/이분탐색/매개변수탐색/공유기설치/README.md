## 집
- N개

## 집 좌표
- x_1, x_2, .... , x_n

## 목적
- 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개 설치

## 조건
- 최대한 많은 곳에서 와이파이를 사용하려 한다.
- 한 집에는 공유기를 하나만 설치할 수 있다.
- 가장 인접한 두 공유기 사이의 거리를 가능한 크게 설치

## 출력
- 첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.


----------------------------------


```
1-2----4------8-9
o      o      o
o      o        o
```

---

## 헷갈렷던 부분
- 가장 인접한 두 공유기의 최대 거리를 구하라!
  - 인접한 두 공유기의 최대 거리를 구하는 문제인 줄알고
  - 위 예시를 이해하는데 한참 걸렸음..
  
---

## 코드 풀기 전 내가 접근 할 방법은?

- 일단 오름차순 정렬을 해야 거리 파악하기 용이할 것 같다.
- 공유기를 집마다 각각 설치하면서 거리를 비교한다면?
 - 집 개수(200,000)*공유기 개수(200,000) = 40_000_000_000 (400억)
 - 문제 시간제한인 2초만에 불가능할 거 같음.

- 그렇다면, 최대값을 구하는 문제이니 파라메트릭 서치를 이용할 수 있는지 검사를 해보자
 - `ORIGIN`: C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
 - `REVERSE`: 가장 인접한 두 공유기 사이의 최대 거리를 만족하면서, C개의 공유기를 N개의 집에 적당히 설치할 수 있는지?(yes/no)

## 강의 보고나서
- 마냥 리버스하면 안되고, yeeeesssss/noooooo 형식이 될 수 있게 만들어야함

- 인접한 두 공유기 사이의 최대가 되려면, 가능한 멀리 떨어진 두 집을 골라야함.

- `ORIGIN`: C개의 공유기를 설치했을 때, 최대 인접거리는 얼마인가?
- `REVERSE`: 어떤 거리만큼 거리(D)를 둘 때, 공유기 c개를 설치할 수 있는가? (yes/no)
  - `yes`가 나오는 거리중에 가장 큰 값이 이 문제의 답..


## 풀이
- sort를 안하는 실수를 했었음 
- 


```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 도현이의 집 수
    private static int C; // 공유기 개수
    private static int[] HOUSES; // 집 좌표

    private static boolean determination(int diff) {

        int count = 1;
        int prev = HOUSES[0];

        for(int i=1; i<N; i++){
            if(HOUSES[i]-prev >= diff){
                count++;
                prev = HOUSES[i];
            }
        }
        return count >= C;
    }

    private static void process() {
        int left = 0;
        int right = 1_000_000_000;
        int answer = 0;

        Arrays.sort(HOUSES);

        while (left <= right) {
            int middle = (left + right) / 2;

            if (determination(middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle -1;
            }
        }
        System.out.println(answer);
    }


    private static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        HOUSES = new int[N];

        for (int i = 0; i < N; i++) {
            HOUSES[i] = scan.nextInt();
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
