

## 내 풀이 (실패)
- 기본 테스트 케이스는 통과하지만, 운좋게 된듯

```java
package com.example.BOJ.이분탐색.매개변수탐색.기타레슨;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 총 N개의 강의, 정렬 보장
    private static int M; // N개의 강의를 블루레이 크기로 묶었을 때, 개수
    private static int[] LECTURES;


    private static void process() {
        int left = 0;
        int right = 1_000_000_000; // 강의의 수 x 강의의 길이
        int answer = 0; // 블루레이 크기 중 최소

        while (left <= right) {
            int middle = (left + right) / 2; // 블루레이 크기

            if (determination(middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean determination(int lectureLength) {

        int count = 0;
        int prev = LECTURES[0];

        for(int i=1; i<N; i++){

            if(LECTURES[i]+prev < lectureLength){
                prev += LECTURES[i];
            }else if(LECTURES[i]+prev >= lectureLength){
                count++;
                prev = LECTURES[i];
            }
        }
        return count >= M;
    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        // 정렬 보장
        LECTURES = new int[N];
        for (int i = 0; i < N; i++) {
            LECTURES[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}

```


## 해답 본 뒤 풀이

- determination 메서드 정의를 잘못했다는 것을 깨달았다.
    - 음원 길이, 큰 길이부터 오기 때문에, 초반 탐색에는 카운트가 작을 수 밖에 없다는 점을 인지하고 있어야했다.
    - 음원 길이가 작아질 수록 카운트가 많아지기 때문에, 그부분을 커팅해야한다.
    - 생각을 좀 더 세세하게 해야겠다.
- 이분탐색을 할 때도, 무지성으로 RIGHT, LEFT를 지정한 게 패착 원인
    - determination() == yes 인 경우, 최소 길이를 구하기 위해서는 right 를 점점 줄여 나가야 했다.
    - 생각을 잘하자.

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final FastReader scan = new FastReader();
    private static int N; // 총 N개의 강의, 정렬 보장
    private static int M; // N개의 강의를 블루레이 크기로 묶었을 때, 개수
    private static int[] LECTURES;


    private static void process() {
        int left = LECTURES[0];
        int right = 1_000_000_000; // 강의의 수 x 강의의 길이
        int answer = 0; // 블루레이 크기 중 최소

        // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다.
        for (int i = 0; i < N; i++) {
            left = Math.max(left,LECTURES[i]);
        }

        while (left <= right) {
            int middle = (left + right) / 2; // 블루레이 크기

            if (determination(middle)) {
                answer = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean determination(int lectureLength) {

        int count = 1;
        int sum = 0;

        for(int i=0; i<N; i++){
            if(LECTURES[i]+sum > lectureLength){
                count++;
                sum = LECTURES[i];
            }else{
                sum += LECTURES[i];
            }
        }
        return count <= M;
    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        // 정렬 보장
        LECTURES = new int[N];
        for (int i = 0; i < N; i++) {
            LECTURES[i] = scan.nextInt();
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
