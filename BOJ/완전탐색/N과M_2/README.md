
# [N과 M (2)](https://www.acmicpc.net/problem/15650)

- 이전(4) 예제와 비슷했다. 그때는 비내림차순이어서 자기자신을 허용하는 오름차순 이었는데 이번엔 자기자신을 제외한 오름차순!
- 비내림차순일 때는, 이전값을 for문의 인덱스로
- 오름차순일 때는, 이전값의 +1을 인덱스로

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;
    private static StringBuilder sb;
    private static int[] selected;

    public static void init(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        sb = new StringBuilder();
    }

    public static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=selected[k-1]+1; i<=N; i++){
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        rec_func(1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
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