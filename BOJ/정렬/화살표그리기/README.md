
# [화살표 그리기](https://www.acmicpc.net/problem/15970)


# 내 풀이

```java
public class Main {
    private static FastReader scan = new FastReader();
    private static Coordinate[] coordinates;
    private static int N;

    static class Coordinate implements Comparable<Coordinate> {
        int position;
        int color;

        public Coordinate(int position, int color) {
            this.position = position;
            this.color = color;
        }

        @Override
        public int compareTo(Coordinate other) {

            if(color != other.color){
                return color - other.color;
            }

            return position - other.position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return position == that.position && color == that.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, color);
        }
    }

    public static void input(){
        N = scan.nextInt();
        coordinates = new Coordinate[N];

        for(int i=0; i<N; i++){
            int position = scan.nextInt();
            int color = scan.nextInt();

            coordinates[i] = new Coordinate(position, color);
        }
    }

    public static void main(String[] args) {

        input();
        Arrays.sort(coordinates);

        int answer = 0;
        int len = coordinates.length;

        for(int i = 0; i < len; i++){

            Coordinate base = coordinates[i];
            int min = Integer.MAX_VALUE;

            for(int j= 0; j < len; j++){
                Coordinate cursor = coordinates[j];

                if(base.color != cursor.color){
                    continue;
                }

                if(base.equals(cursor)){
                    continue;
                }

                int diff = Math.abs(base.position - cursor.position);
                min = Math.min(min, diff);
            }
            answer += min;
       }

        System.out.println(answer);
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


## 다른 풀이

```java
import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        if (idx == 0)  // 왼쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == a[color].size())  // 오른쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void pro() {
        for (int color = 1; color <= N; color++)
            Collections.sort(a[color]);

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left_distance = toLeft(color, i);
                int right_distance = toRight(color, i);
                ans += Math.min(left_distance, right_distance);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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