
# [N과 M (1)](https://www.acmicpc.net/submit/15649)

- N과 M(3) 문제에서 가지치기만 하면 되는 문제


## 2021.10.21 -  2회 풀이

```java
public class Main {
    static int N;
    static int M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new int[M];
        visited = new boolean[N];

        rec_func(0);

        System.out.println(sb.toString());
        scanner.close();
    }

    private static void rec_func(int index) {
        if(index == M){
            for(int num : selected){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=N; i++){
                if(visited[i-1]){
                    continue;
                }
                selected[index] = i;
                visited[i-1] = true;

                rec_func(index+1);
                selected[index] = 0;
                visited[i-1] = false;
            }
        }
    }
}
```


## 2021.09.01 -  1회 풀이

```java

public class Main {

    static int N, M;
    static StringBuilder sb;

    static int selected[];
    static boolean visited[];


    static void input(){

        FastReader scan = new FastReader();

        sb = new StringBuilder();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        visited = new boolean[N+1];
    }

    static void rec_func(int k){

        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else{

            for(int i=1; i<=N; i++){

                // 가지치기
                if(visited[i]){
                    continue;
                }

                selected[k] = i;
                visited[i] = true;
                rec_func(k+1);

                selected[k] = 0;
                visited[i] = false;

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

        public FastReader(String s) throws FileNotFoundException {
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