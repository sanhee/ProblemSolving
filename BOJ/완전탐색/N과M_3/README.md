
#[N과 M (3)](https://www.acmicpc.net/problem/15651)

- 왜 배열의 0번째부터 안쓰고 1부터 쓰지? 하면서 쓸데없는 고민으로 시간을 엄청 썼다..
 - 그래서 `M+1`이 정말 이해가 안갔었다.
 - 1~N까지 수열을 고르는 거라, 안햇갈리게 0번째 인덱스를 버린거였음.
- 수열 몇문제 풀어봤는데, 아직 익숙하지 않은거 봐선 좀 더 풀어봐야겠다.


```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] visited;
    static StringBuilder sb;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        sb = new StringBuilder();
        visited = new int[M + 1];
    }

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i=1; i<=N; i++) {
                visited[k] = i;
                rec_func(k+1);
                visited[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }


    static class FastReader {

        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
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