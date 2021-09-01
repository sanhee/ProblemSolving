
# [N과 M (4)](https://www.acmicpc.net/problem/15652)

-  비내림차순이란게, 이전 요소 사용을 안하면 구현 가능
-  조합 구하는 로직이랑 비슷했던 것 같음
-  코드를 반복적으로 하니까, 어렵진않은데, 실전에서 이러한 코드를 도출해 내는게 관건..

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;
    static int[] selected;

    public static void input() {

        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        sb = new StringBuilder();
        selected = new int[M+1];
    }


    public static void rec_func(int k){

        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else{
            int prevSelect = selected[k-1] != 0 ? selected[k-1] : 1;

            for(int i=prevSelect; i<=N; i++){
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
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